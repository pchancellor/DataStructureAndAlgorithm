package px.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChargenServer {

	public static void main(String[] args) {
		byte[] data = new byte[95*2];
		for (byte i = ' '; i <= '~'; i++) {
			data[i - ' '] = i ;
			data[i + 95 - ' '] = i;
		}
		
		ServerSocketChannel serverSocketChannel ;
		Selector selector ;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			ServerSocket serverSocket = serverSocketChannel.socket();
			serverSocket.bind(new InetSocketAddress(8000));
			serverSocketChannel.configureBlocking(false);
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			return ;
		}
		
		while (true) {
			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = keys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) iterator.next();
				iterator.remove();
				try {
					if (selectionKey.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
						SocketChannel client = server.accept();
						System.out.println("Accepted connection from " + client);
						client.configureBlocking(false);
						SelectionKey selectionKey2 = client.register(selector, SelectionKey.OP_WRITE);
						ByteBuffer buffer = ByteBuffer.allocate(74);
						buffer.put(data, 0, 72);
						buffer.put((byte) '\r').put((byte) '\n');
						buffer.flip();
						selectionKey2.attach(buffer);
					} else if (selectionKey.isWritable()) {
						SocketChannel client = (SocketChannel) selectionKey.channel();
						ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
						if (!buffer.hasRemaining()) {
							buffer.rewind();
							int first = buffer.get();
							buffer.rewind();
							int position = first - ' ' + 1;
							buffer.put(data, position, 72);
							buffer.put((byte) '\r').put((byte) '\n');
							buffer.flip();
						}
						client.write(buffer);
					}
				} catch (Exception e) {
					selectionKey.cancel();
					try {
						selectionKey.channel().close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		}
	}
	
}
