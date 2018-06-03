package px.java.features;

import px.java.features.OuterClass.StaticInner;

public class Main {

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		OuterClass.Inner inner = outerClass.new Inner();
		StaticInner staticInner = new StaticInner();
		inner.print();
		staticInner.print();
		outerClass.print();
		outerClass.printStatic();
		outerClass.printPrivate();
		outerClass.printMethodInner(4);
	}

}
