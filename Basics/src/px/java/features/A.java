package px.java.features;

/**
 * Java���ԣ���д������
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
        System.out.println("1--" + a1.show(b));//��������ת�� B->A
        System.out.println("2--" + a1.show(c));//��������ת�� C->A
        System.out.println("3--" + a1.show(d));//�������� D
        System.out.println("4--" + a2.show(b));//��̬������A��ʵ��������B����д����һ���ǣ���ΪA��û��BΪ������show���������Բ�������ת�� B->A��ѡA�е�show(A)���������÷�����B������д������ʵ��ִ��ѡB�е�show(A)����
        System.out.println("5--" + a2.show(c));//��4����
        System.out.println("6--" + a2.show(d));//��ΪA����show(D)��������û����B�б���д����ִ��ʱѡA�е�show(D)����
        System.out.println("7--" + b.show(b));//�򵥵ķ�������
        System.out.println("8--" + b.show(c));//��������ת�� C->B
        System.out.println("9--" + b.show(d));//B�м̳���A�е�show(D)��������û����д������ѡA��show(D)����
    }
}
