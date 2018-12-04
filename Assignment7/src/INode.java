public interface INode<E> {
	/**
	 * @return the data stored in this node
	 */
	E getData();
	
	/**
	 * @return the node next to this node.
	 */
	Node<E> getNext();
	
	/**
	 * Sets node received as the next node to this node.
	 * @param next the node to be set as next
	 */
	void setNext(Node<E> next);
}