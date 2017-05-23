package px.structure.test;

public class InnerClassVisibility {

	private String id;
	
	class InnerClass {
		private InnerClassVisibility visibilityTest;
		
		public InnerClass() {
			visibilityTest = new InnerClassVisibility();
			System.out.println(visibilityTest.id);
		}
	}
}

class OutterClass {
	private InnerClassVisibility visibility ;
	
	public OutterClass() {
		visibility = new InnerClassVisibility();
		System.out.println(visibility);
	}
}