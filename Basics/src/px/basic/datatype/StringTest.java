package px.basic.datatype;

public class StringTest {

	public static void main(String[] args) {
		String aString = "hello";
		String bString = "hello";
		char[] chars = new char[]{'h','e','l','l','o'};
		System.out.println(aString == bString);
		System.out.println(aString.equals(chars));
		System.out.println(((Object)chars) instanceof String);
	}

}
