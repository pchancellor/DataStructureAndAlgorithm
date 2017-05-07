package px.generic.type;

public class SimpleGenericType<AnyType> {
	
	private AnyType storeValue ;
	
	public AnyType read() {
		return storeValue;
	}
	
	public void write(AnyType t) {
		storeValue = t;
	}
}
