package px.basic.datatype;

public class FloatPrecisionTest {

	public static void main(String[] args) {
//		testFloatPresicion();
		testFloatRange();
	}
	
	public static void testFloatPresicion() {
		float f = 16777215f;
		for (int i = 0; i < 10; i++) {
			System.out.println(f);
			f++;
		}
	}

	public static void testFloatRange() {
		float f = 2.2f;
		double d = f;
		System.out.println(d);
		f = 2.25f;
		d = f;
		System.out.println(d);
	}
}
