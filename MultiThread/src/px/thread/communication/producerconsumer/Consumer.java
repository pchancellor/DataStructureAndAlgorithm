package px.thread.communication.producerconsumer;

public interface Consumer<T> {

	public T consume() throws InterruptedException;
	
}
