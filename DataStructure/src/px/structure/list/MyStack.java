package px.structure.list;

import java.util.List;

public class MyStack<AnyType> {
	
	private List<AnyType> list ;
	private int topOfStack = -1;
	
	public boolean push(AnyType val) {
		list.add(val);
		topOfStack++;
		return true;
	}
	
	public AnyType pop() {
		if (topOfStack == -1) {
			
		}
		return list.get(topOfStack--);
	}
	
}
