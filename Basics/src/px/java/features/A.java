package px.java.features;

/**
 * Java特性：重写和重载
 * @author WD
 *
 */
public class A {
    public String show(D obj) {
        return ("A and D");
    }
    public String show(A obj) {
        return ("A and A");
    } 
    static class B extends A{
	    public String show(B obj){
	        return ("B and B");
	    }
	    public String show(A obj){
	        return ("B and A");
	    } 
	}
	static class C extends B{

	}
	static class D extends B{

	}
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b));//参数向上转型 B->A
        System.out.println("2--" + a1.show(c));//参数向上转型 C->A
        System.out.println("3--" + a1.show(d));//方法重载 D
        System.out.println("4--" + a2.show(b));//静态类型是A，实际类型是B，重写重载一起考虑，因为A中没有B为参数的show方法，所以参数向上转型 B->A，选A中的show(A)方法，但该方法在B中有重写，所以实际执行选B中的show(A)方法
        System.out.println("5--" + a2.show(c));//和4类似
        System.out.println("6--" + a2.show(d));//因为A中有show(D)方法，且没有在B中被重写，故执行时选A中的show(D)方法
        System.out.println("7--" + b.show(b));//简单的方法重载
        System.out.println("8--" + b.show(c));//参数向上转型 C->B
        System.out.println("9--" + b.show(d));//B中继承了A中的show(D)方法，且没有重写，所以选A的show(D)方法
    }
}
