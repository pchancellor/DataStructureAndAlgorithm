package px.structure.list;

public class MyDoubleLinkedListQueue<T> extends MyQueue<T> {
	
	private Node<T> front;
	private Node<T> rear;

	public MyDoubleLinkedListQueue() {
		front = new Node<T>(null, null, null);
		rear = new Node<T>(null, front, null);
		front.next = rear;
	}
	
	@Override
	public void enqueue(T elem) {
		Node<T> node = new Node<T>(elem, rear.prev, rear);
		rear.prev.next = node;
		rear.prev = node;
	}

	@Override
	public T dequeue() {
		Node<T> node = front.next;
		node.next.prev = front;
		front.next = node.next;
		return node.data;
	}
	
	private static class Node<T> {
		T data;
		Node<T> prev ;
		Node<T> next ;
		
		private Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

}
