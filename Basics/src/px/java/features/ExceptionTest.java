package px.java.features;

public class ExceptionTest {

	public static void main(String[] args) {
		Exception exception = new Exception("", new Throwable());
		exception.getCause();
	}

}
