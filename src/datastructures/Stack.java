package datastructures;

/**
 * A stack class
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	The type of values to store
 */
public class Stack<T> {
	private SinglyLinkedList<T> values;
	
	/**
	 * Constructor for Stack
	 */
	public Stack() {
		this.values = new SinglyLinkedList<T>();
	}
	
	/**
	 * Constructor for Stack
	 * 
	 * @param value	the first value of the stack
	 */
	public Stack(T value){
		this.values = new SinglyLinkedList<T>(value);
	}
	
	/**
	 * Performs the peek operation
	 * 
	 * @return	The top of the stack
	 */
	public T peek() {
		if (this.values.isEmpty()){
			return null;
		}
		return this.values.getNodeValue(0);
	}
	
	/**
	 * Performs the push operation
	 * 
	 * @param value	The value that is being pushed
	 */
	public void push(T value){
		this.values.addToEnd(value);
	}
	
	/**
	 * Performs the pop operation
	 * 
	 * @return	The top of the stack
	 */
	public T pop() {
		if (this.values.isEmpty()){
			return null;
		}
		T popedValue = this.values.getNodeValue(0);
		this.values.removeFrontNode();
		return popedValue;
	}
	
	/**
	 * Determines if the stack is empty
	 * 
	 * @return	Whether the stack is empty or not
	 */
	public boolean isEmpty() {
		return this.values.isEmpty();
	}
	
	public String toString() {
		return this.values.toString();
	}
}
