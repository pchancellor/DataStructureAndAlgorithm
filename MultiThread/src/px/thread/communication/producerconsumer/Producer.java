package px.thread.communication.producerconsumer;

public interface Producer<T> {

	public void produce(T elem) throws InterruptedException;
	
}
