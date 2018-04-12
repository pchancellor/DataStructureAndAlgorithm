package px.thread.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		int count = 5;
		final CyclicBarrier barrier = new CyclicBarrier(count+1);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(count));
		for (int i = 0; i < count; i++) {
			threadPoolExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("enter thread " + Thread.currentThread().getName());
						Thread.sleep(new Random().nextInt(10) * 1000);
						System.out.println("exit thread " + Thread.currentThread().getName());
						barrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		try {
			barrier.await();
			System.out.println("main finish waiting");
			threadPoolExecutor.shutdown();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
