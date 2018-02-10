package px.thread.communication.producerconsumer;

import java.util.List;

public class ProducerImpl<T> implements Producer<T> {
	
	private List<T> messagePool ;
	private int cap ;
	private Object lock ;
	
	public ProducerImpl(List<T>	pool, int capacity, Object lock) {
		messagePool = pool;
		cap = capacity;
		this.lock = lock;
	}

	@Override
	public void produce(T elem) throws InterruptedException {
		synchronized (lock) {
			while (messagePool.size() == cap) {
				System.out.println(Thread.currentThread().getName() + " waiting...");
				lock.wait();
			}
			messagePool.add(elem);
			System.out.println(Thread.currentThread().getName() + " produce:"+elem);
			lock.notifyAll();
		}
	}

}
