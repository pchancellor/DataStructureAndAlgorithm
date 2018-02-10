package px.thread.communication.producerconsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProducerConsumerDemo<AnyType> {

	private Object lock = new Object();
	private List<AnyType> messageQueue = new ArrayList<>();
	private int capacity ;
	
	public ProducerConsumerDemo(int cap) {
		capacity = cap;
	}
	
	public static void main(String[] args) {
		ProducerConsumerDemo<Integer> demo = new ProducerConsumerDemo<>(10);
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		int producerNum = 3;
		int consumerNum = 2;
		for (int i = 0; i < producerNum; i++) {
			ProducerConsumerDemo<Integer>.ProducerThread pThread = demo.new ProducerThread();
			pThread.loadMessages(list);
			new Thread(pThread).start();
		}
		
		for (int i = 0; i < consumerNum; i++) {
			ProducerConsumerDemo<Integer>.ConsumerThread pThread = demo.new ConsumerThread();
			new Thread(pThread).start();
		}
	}
	
	public class ProducerThread implements Runnable {
		
		List<AnyType> messagaToSend = new ArrayList<>();
		
		public void loadMessages(List<AnyType> messages) {
			messagaToSend.addAll(messages);
		}

		@Override
		public void run() {
			Producer<AnyType> producer = new ProducerImpl<>(messageQueue, capacity, lock);
			for (AnyType message : messagaToSend) {
				try {
					producer.produce(message);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public class ConsumerThread implements Runnable {
		
		@Override
		public void run() {
			Consumer<AnyType> consumer = new ConsumerImpl<>(messageQueue, lock);
			while (true) {
				try {
					consumer.consume();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
		}
		
	}
}
