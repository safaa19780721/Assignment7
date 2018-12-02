
public class PriorityQueue <E extends Comparable<E>> {
	private Node<E> head;
	
	// Determine if the priority queue is empty.
	public boolean isEmpty()
	{
		return head == null;
	}
	// Add object received to the priority queue taking into consideration the rules governing priority.
	public void enqueue(E data)
	{
		//TODO: FIX ME
	}
	// Remove the next object to be processed from the priority queue.
	public E dequeue()
	{
		Node<E> temp = head;
		head = head.next;
		return temp.data;
	}
	// Print the contents of the queue 
	public void Qprint()
	{	
		Node<E> temp = head;
		while(temp != null)
		{
			System.out.println(temp.data); //TODO: FIX ME
			temp = temp.next;
		}
	}

}
