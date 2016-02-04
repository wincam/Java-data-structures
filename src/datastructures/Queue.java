package datastructures;

/**
 * A queue class
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	Type of values stored in queue
 */
public class Queue<T> {
	private DoublyLinkedList<T> values;
	
	/**
	 * Constructor for Queue
	 */
	public Queue(){
		this.values = new DoublyLinkedList<T>();
	}
	
	/**
	 * Constructor for Queue
	 * 
	 * @param value	First enqueued value
	 */
	public Queue(T value){
		this.values = new DoublyLinkedList<T>(value);
	}
	
	/**
	 * Peek at top of queue
	 * 
	 * @return	Value of the top of the queue
	 */
	public T peek() {
		if (this.values.isEmpty()){
			return null;
		}
		return this.values.getNodeValue(values.getSize() - 1);
	}
	
	/**
	 * Dequeue the top of the queue
	 * 
	 * @return	the top of the queue
	 */
	public T dequeue() {
		if (this.values.isEmpty()){
			return null;
		}
		T dequeuedValue = values.getNodeValue(values.getSize() - 1);
		this.values.removeEndNode();
		return dequeuedValue;
	}
	
	/**
	 * Enqueue a value
	 * 
	 * @param value	Value to enqueue
	 */
	public void enqueue(T value) {
		this.values.addToFront(value);
	}
	
	/**
	 * Determines if the queue is empty
	 * 
	 * @return	Whether the queue is empty or not
	 */ 
	public boolean isEmpty() {
		return this.values.isEmpty();
	}
	
	public String toString() {
		return this.values.toString();
	}

}
