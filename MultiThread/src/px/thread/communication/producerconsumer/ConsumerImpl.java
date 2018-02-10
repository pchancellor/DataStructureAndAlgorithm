package px.thread.communication.producerconsumer;

import java.util.List;

public class ConsumerImpl<T> implements Consumer<T> {
	
	private List<T> messagePool ;
	private Object lock ;
	
	public ConsumerImpl(List<T> pool, Object lock) {
		messagePool = pool;
		this.lock = lock;
	}

	@Override
	public T consume() throws InterruptedException {
		T message = null;
		synchronized (lock) {
			while (messagePool.size() == 0) {
				System.out.println(Thread.currentThread().getName() + " waiting...");
				lock.wait();
			}
			message = messagePool.remove(0);
			System.out.println(Thread.currentThread().getName() + " consume:"+message);
			lock.notifyAll();
		}
		return message;
	}

}
