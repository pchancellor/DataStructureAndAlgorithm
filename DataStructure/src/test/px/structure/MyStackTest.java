package test.px.structure;

import px.structure.list.MyStack;

public class MyStackTest {

	public static void main(String[] args) {
		try {
			infix2postfix();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void postfixCalculation() {
		String[] strings = new String[]{"6","5","2","3","+","8","*","+","3","+","*"};
		MyStack<Integer> myStack = new MyStack<>();
		for (String string : strings) {
			if (string.equals("+")) {
				myStack.push(myStack.pop()+myStack.pop());
			} else if (string.equals("*")) {
				myStack.push(myStack.pop()*myStack.pop());
			} else {
				myStack.push(Integer.valueOf(string));
			}
		}
		System.out.println("result is : " + myStack.pop());
	}
	
	public static void infix2postfix() throws Exception {
		String[] strings = new String[]{"a","+","b","*","c","+","(","d","*","e","+","f",")","*","g"};
		System.out.println("infix expression: " + String.join("", strings));
		String[] newStrings = new String[strings.length];
		int newIndex = 0;
		MyStack<String> operatorStack = new MyStack<>();
		for (String string : strings) {
			if (string.equals("+")) {
				while (operatorStack.peek() != null && !operatorStack.peek().equals("(")) {
					newStrings[newIndex++] = operatorStack.pop();
				}
				operatorStack.push(string);
			} else if (string.equals("*") || string.equals("(")) {
				operatorStack.push(string);
			} else if (string.equals(")")) {
				if (operatorStack.peek() == null) {
					throw new Exception("”“¿®∫≈»±…Ÿ∆•≈‰µƒ◊Û¿®∫≈");
				}
				while (!operatorStack.peek().equals("(")) {
					newStrings[newIndex++] = operatorStack.pop();
					if (operatorStack.peek() == null) {
						throw new Exception("”“¿®∫≈»±…Ÿ∆•≈‰µƒ◊Û¿®∫≈");
					}
				}
				operatorStack.pop();
			} else {
				newStrings[newIndex++] = string;
			}
		}
		while (operatorStack.peek() != null) {
			newStrings[newIndex++] = operatorStack.pop();
		}
		System.out.println("postfix expression :" + String.join("", newStrings));
	}
}
