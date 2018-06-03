package px.java.features;

public class OuterClass {
	
	int val = 0;
	static int staticVal = 0;

	class Inner {
		public void print() {
			val = 1;
			System.out.println("val:" + val);
		}
	}
	
	static class StaticInner {
		public void print() {
			staticVal = 2;
			System.out.println("staticVal:" + staticVal);
		}
	}
	
	private class PrivateInner {
		public void print() {
			val = 3;
			System.out.println("val:" + val);
		}
	}

	public void print() {
		new Inner().print();
	}
	
	public void printPrivate() {
		new PrivateInner().print();
	}
	
	public void printStatic() {
		new StaticInner().print();
	}
	
	public void printMethodInner(int val) {
		class MethodInner {
			public void print() {
				System.out.println(val);
			}
		}
		new MethodInner().print();
	}
}
