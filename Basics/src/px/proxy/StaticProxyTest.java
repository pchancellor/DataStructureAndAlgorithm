package px.proxy;

public class StaticProxyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static interface Calculator {
		int add(int a, int b);
	}
	
	static class CalculatorImpl implements Calculator {

		@Override
		public int add(int a, int b) {
			return a + b;
		}
		
	}
	
	static class CalculatorProxy implements Calculator {
		private Calculator calculator;
		public CalculatorProxy(Calculator calculator) {
			this.calculator = calculator;
		}
		public int add(int a, int b) {
			//do other job before execution
			int result = calculator.add(a, b);
			//do other job after execution
			return result;
		}
	}
}
