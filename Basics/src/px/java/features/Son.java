package px.java.features;

public class Son extends Father {

	static String name = "";
	int age ;
	public Son() {
		super(name);
		System.out.println(new Father(name).getName());
	}
	
	public int getAge() {
		return age;
	}
	
	public static void main(String[] args) {
		Father father = new Son();
		Son son = (Son) father;
		System.out.println(son.getAge());
	}
	
}
