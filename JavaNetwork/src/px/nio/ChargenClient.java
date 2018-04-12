package px.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class ChargenClient {

	public static void main(String[] args) {
		try {
			SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 8000));
			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel writer = Channels.newChannel(System.out);
			while (client.read(buffer) != -1) {
				buffer.flip();
				writer.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
