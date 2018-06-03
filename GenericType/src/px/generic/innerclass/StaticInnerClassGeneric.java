package px.generic.innerclass;

public class StaticInnerClassGeneric<AnyType extends Comparable<? super AnyType>> {

	public static void main(String[] args) {
		
	}
	
	private StaticInner<AnyType>[] inner ;
	
	private static final int DEFAULT_INNER_SIZE = 1;
	
	public StaticInnerClassGeneric(AnyType elem) {
		inner = new StaticInner[DEFAULT_INNER_SIZE];
	}
	
	static class StaticInner<AnyType> {
		
	}
}
