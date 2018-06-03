package px.basic.datatype;

public class AutoBoxing {

	public static void main(String[] args) {
		Byte a = 127;
		Byte c = a;
		System.out.println(++c);
		System.out.println(a);
//		Byte b = 127;
//		add(++a);
//		System.out.println(a);
//		add(b);
//		System.out.println(b);
	}

	public static void add(Byte b) {
		b = b++;
	}
}
