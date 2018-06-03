package px.java.features;

public class Entity implements InterfaceA, InterfaceB {
	public static void main(String[] args) {
		System.out.println(InterfaceA.name);
		Entity entity = new Entity();
		entity.print();
		test1(entity, "prefix-A:");
	}
	
	public static void test1(Entity entity, String prefix) {
		entity.test(new InterfaceA() {
			@Override
			public void print(String target) {
				System.out.println(prefix + target);
			}
		});
	}

	@Override
	public void print() {
		System.out.println("print method");
	}

	@Override
	public void print(String target) {
		System.out.println(target);
	}
	
	public void test(InterfaceA a) {
		a.print("anonymous inner class");
	}
}
interface InterfaceA {
	String name = "a";
	void print(String target);
}
interface InterfaceB {
	String name = "b";
	void print();
}
