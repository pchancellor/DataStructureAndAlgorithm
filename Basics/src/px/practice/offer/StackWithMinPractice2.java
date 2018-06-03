package px.practice.offer;

import java.util.Stack;

public class StackWithMinPractice2 {

	Stack<Integer> entity = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
    	if (minStack.isEmpty() || minStack.peek() >= node) {
			minStack.push(node);
		}
        entity.push(node);
    }
    
    public void pop() {
        if (entity.pop() == minStack.peek()) {
        	minStack.pop();
		}
    }
    
    public int top() {
        return entity.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
