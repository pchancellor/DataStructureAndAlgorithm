package px.thread.volatiletest;

public class VolatileHappensBefore {
	
//	private volatile int value;
	private int value;
	private volatile boolean ready ;
//	private boolean ready ;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 30; i++) {
			VolatileHappensBefore beforeTest = new VolatileHappensBefore();
			Thread setThread = new Thread(new SetThread(beforeTest));
			setThread.start();
			Thread getThread = new Thread(new GetThread(beforeTest));
			getThread.start();
		}
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	static class SetThread implements Runnable {
		
		private VolatileHappensBefore before ;

		public SetThread(VolatileHappensBefore before) {
			this.before = before;
		}
		
		@Override
		public void run() {
			before.setValue(1);
			before.ready = true;
		}
		
	}

	static class GetThread implements Runnable {
		
		private VolatileHappensBefore before ;

		public GetThread(VolatileHappensBefore before) {
			this.before = before;
		}
		
		@Override
		public void run() {
			if (before.ready) {
				System.out.println(before.getValue());
			}
		}
		
	}
}
