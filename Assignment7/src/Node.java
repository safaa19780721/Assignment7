public class Node<E> implements INode<E>{
	
	E data;
	Node<E> next;

	public Node(){
		data = null;
		next = null;
	}

	public Node( E input ) {
		this.data = input;
		next = null;
	}
	
	public Node( E input, Node<E> succ ){
		this.data = input;
		this.next = succ;
	}
	
	public E getData() {
		
		return this.data;
	}

	public Node<E> getNext() {
		
		return this.next;
	}

	public void setNext(Node<E> next) {
		
		this.next = next;
		
	}

}