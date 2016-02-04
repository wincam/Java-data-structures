package datastructures;

/**
 * Node contains an element of type T
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	Type of value contained by node
 */
public abstract class Node<T> {
	private T value;
	
	/**
	 * Constructor for Node
	 * 
	 * @param value	Value of the node
	 */
	public Node(T value){
		this.value = value;
	}
	
	/**
	 * Getter for value of node
	 * 
	 * @return	Value of node
	 */
	public T getValue() {
		return this.value;
	}
	
	/**
	 * Setter for element
	 * 
	 * @param value	New value of node
	 */
	public void setValue(T value){
		this.value = value;
	}
	
	/**
	 * Getter for next node
	 * 
	 * @return	Next node
	 */
	public abstract Node<T> getNext();
	
	/**
	 * Checks if there is not a next node
	 * 
	 * @return	Boolean value that shows if the node is the end or not
	 */
	public abstract boolean isEnd();
	
	public String toString(){
		return value.toString();
	}
}
