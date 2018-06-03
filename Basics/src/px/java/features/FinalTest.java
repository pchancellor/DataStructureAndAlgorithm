package px.java.features;

public class FinalTest {

	private final String string_01 = "str-1";
	private final String string_02 ;
	
	private static final String string_03 ;
	
	static {
		string_03 = "";
	}
	
	{
		string_02 = "";
	}
	
	public FinalTest(String string02) {
//		string_02 = string02;
	}
	
	public void init() {
		
	}
	
	public static void clInit() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class StaticExtendsTest extends FinalTest {

		public StaticExtendsTest(String string02) {
			super(string02);
			// TODO Auto-generated constructor stub
		}
		
		public static void clInit() {
			
		}
	}
	
}
