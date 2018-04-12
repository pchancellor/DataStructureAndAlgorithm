package px.java.features;

public class Father {
	
	protected String name;
	
	public Father(String name) {
		this.name = name;
		System.out.println("father" + name);
	}
	
	protected String getName() {
		return name;
	}
}
