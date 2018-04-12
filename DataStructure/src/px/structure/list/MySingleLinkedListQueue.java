package px.structure.list;

public class MySingleLinkedListQueue<T> extends MyQueue<T> {

	private Node<T> front;
	private Node<T> rear;

	public MySingleLinkedListQueue() {
		front = new Node<T>(null, null);
		rear = new Node<T>(null, front);
		front.reference = rear;
	}
	
	@Override
	public void enqueue(T elem) {
		Node<T> node = new Node<T>(elem, rear);
		rear.reference.reference = node;
		rear.reference = node;
	}

	@Override
	public T dequeue() {
		Node<T> node = front.reference;
		front.reference = node.reference;
		return node.data;
	}
	
	private static class Node<T> {
		T data;
		Node<T> reference ;
		
		private Node(T data, Node<T> reference) {
			this.data = data;
			this.reference = reference;
		}
	}

}
