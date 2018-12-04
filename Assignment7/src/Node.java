public class Node<E> implements INode<E>{
	
	E data;
	Node<E> next;

	/**
	 *  Creates an empty node
	 */
	public Node(){
		data = null;
		next = null;
	}

	/**
	 * a node with the next field set to null
	 * @param input the data for a new node
	 */
	public Node( E input ) {
		this.data = input;
		next = null;
	}
	
	/**
	 * a node with the next field set
	 * @param input the data for a new node
	 * @param succ the node that comes after this node
	 */
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