package datastructures;
/**
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	Type of node
 */
public class DoublyNode<T> extends Node<T>{
	private DoublyNode<T> last;
	private DoublyNode<T> next;
	
	/**
	 * Constructor for DoublyNode
	 * 
	 * @param value	The value of the node
	 */
	public DoublyNode(T value) {
		super(value);
		this.last = null;
		this.next = null;
	}
	
	/**
	 * Constructor for DoublyNode
	 * 
	 * @param value	The value of the node
	 * @param last	The last node
	 * @param next	The next node
	 */
	public DoublyNode(T value, DoublyNode<T> last, DoublyNode<T> next){
		super(value);
		this.last = last;
		this.next = next;
	}
	
	/**
	 * Getter for last node
	 * 
	 * @return	Last node
	 */
	public DoublyNode<T> getLast() {
		return this.last;
	}
	
	/**
	 * Setter for last node
	 * 
	 * @param last	New last node
	 */
	public void setLast(DoublyNode<T> last) {
		this.last = last;
	}
	
	@Override
	public DoublyNode<T> getNext(){
		return this.next;
	}
	
	/**
	 * Setter for next node
	 * 
	 * @param next	New next node
	 */
	public void setNext(DoublyNode<T> next){
		this.next = next;
	}
	
	@Override
	public boolean isEnd(){
		return this.next == null;
	}
	
	/**
	 * Checks if there is not a last node
	 * 
	 * @return	Boolean value that shows if the node is the beginning or not
	 */
	public boolean isFrist(){
		return this.last == null;
	}

}
