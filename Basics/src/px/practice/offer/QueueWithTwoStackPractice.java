package px.practice.offer;

import java.util.Stack;

public class QueueWithTwoStackPractice {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    boolean inverseWithQueue = true;
    
    public void push(int node) {
        if (!inverseWithQueue) {
			inverse(stack1, stack2);
			inverseWithQueue = true;
		}
        if (stack1.isEmpty()) {
			stack2.push(node);
		} else {
			stack1.push(node);
		}
    }
    
    public int pop() {
    	if (inverseWithQueue) {
			inverse(stack1, stack2);
			inverseWithQueue = false;
		}
    	if (stack1.isEmpty()) {
			return stack2.pop();
		} else {
			return stack1.pop();
		}
    }
    
    private void inverse(Stack<Integer> stack1, Stack<Integer> stack2) {
    	if (stack1.isEmpty() && stack2.isEmpty()) {
			return;
		}
		if (stack2.isEmpty()) {
			inverse(stack2, stack1);
		} else {
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		}
	}
    
    public static void main(String[] args) {
		QueueWithTwoStackPractice queue = new QueueWithTwoStackPractice();
		for (int i = 0; i < 5; i++) {
			queue.push(i);
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(queue.pop() + " ");
		}
		for (int i = 5; i < 9; i++) {
			queue.push(i);
		}
		for (int i = 0; i < 6; i++) {
			System.out.println(queue.pop() + " ");
		}
	}
}
