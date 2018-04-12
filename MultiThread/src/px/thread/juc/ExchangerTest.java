package px.thread.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		final Exchanger<List<Integer>> exchanger = new Exchanger<>();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				List<Integer> list = new ArrayList<>();
				list.add(1);
				list.add(2);
				try {
					list = exchanger.exchange(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread-1:" + list);
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				List<Integer> list = new ArrayList<>();
				list.add(3);
				list.add(4);
				try {
					list = exchanger.exchange(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread-2:" + list);
			}
		}).start();
	}

}
