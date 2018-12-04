
public class PriorityQueue <E extends Comparable<E>> {
	private Node<E> head;
	
	/**
	 * Determine if the priority queue is empty.
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return head == null;
	}
	/**
	 * Add object received to the priority queue taking into consideration the rules governing priority.
	 * @param data the data that you want enqueued into the priority queue
	 */
	public void enqueue(E data)
	{
		if(head == null)
		{
			head = new Node<E>(data, head);
			return;
		}
		Node<E> temp = head;
		boolean done = false;
		Node<E> prev = null;
		int i = 0; 
		while(temp != null)
		{
			if(data.compareTo(temp.data) == 0)
			{
				done = true;
				if(i == 0)
				{
					head = new Node<E>(data, head);
					return;
				}
				else
				{
					prev.next = new Node<E>(data, temp);
					return;
				}
			}
			i++;
			prev = temp;
			temp = temp.next;
		}
		if(done == false)
		{
			prev.next = new Node<E>(data);
		}
	}
	// 
	/**
	 * Remove the next object to be processed from the priority queue.
	 * @return the object that has been removed from the queue
	 */
	public E dequeue()
	{
		Node<E> temp = head;
		head = head.next;
		return temp.data;
	}
	/**
	 * Print the contents of the queue 
	 */
	public void Qprint()
	{	
		System.out.println("<<<<<<<<<<<< Beginning of Queue Contents >>>>>>>>>>>>>>>>>");
		if(head == null)
		{
			System.out.println("Queue is Empty ");
		}
		Node<E> temp = head;
		while(temp != null)
		{
			System.out.println("Request@" + Integer.toHexString(System.identityHashCode(temp.data))); //TODO: FIX ME
			temp = temp.next;
		}
		System.out.println("<<<<<<<<<<<< End of Queue Contents >>>>>>>>>>>>>>>>>");
	}

}
