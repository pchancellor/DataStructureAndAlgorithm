package px.practice.offer;

import java.util.Stack;

public class StackWithMinPractice {
	
	Stack<Integer> entity = new Stack<>();
	int min ;

    public void push(int node) {
    	if (!entity.isEmpty()) {
			min = node > min ? min : node;
		} else {
			min = node;
		}
        entity.push(node);
    }
    
    public void pop() {
        if (entity.pop() == min) {
			findMin();
		}
    }
    
    public int top() {
        return entity.peek();
    }
    
    public int min() {
        return min;
    }
    
    private void findMin() {
    	if (entity.isEmpty()) {
			return;
		}
    	int tmp = entity.get(0);
		for (int i = 1; i < entity.size(); i++) {
			tmp = tmp > entity.get(i) ? entity.get(i) : tmp;
		}
		min = tmp;
	}
    
    public static void main(String[] args) {
//		StackWithMinPractice practice = new StackWithMinPractice();
		StackWithMinPractice2 practice = new StackWithMinPractice2();
		practice.push(3);
		System.out.println(practice.min());
		practice.push(4);
		System.out.println(practice.min());
		practice.push(2);
		System.out.println(practice.min());
		practice.push(3);
		System.out.println(practice.min());
		practice.pop();
		System.out.println(practice.min());
		practice.pop();
		System.out.println(practice.min());
		practice.pop();
		System.out.println(practice.min());
		practice.push(0);
		System.out.println(practice.min());
	}
}
