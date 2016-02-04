package datastructures;
/**
 * A singly linked node for use in a linked list
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	Type of node
 */
public class SinglyNode<T> extends Node<T> {
	private SinglyNode<T> next;
	
	/**
	 * Constructor for SinglyNode
	 * 
	 * @param value	Value of node
	 */
	public SinglyNode(T value){
		super(value);
		this.next = null;
	}
	
	/**
	 * Constructor for SinglyNode
	 * 
	 * @param value	Value of node
	 * @param next	Reference to next node
	 */
	public SinglyNode(T value, SinglyNode<T> next){
		super(value);
		this.next = next;
	}
	
	@Override
	public SinglyNode<T> getNext(){
		return this.next;
	}
	
	/**
	 * Changes next node
	 * 
	 * @param next	New next node
	 */
	public void setNext(SinglyNode<T> next){
		this.next = next;
	}
	
	@Override
	public boolean isEnd(){
		return this.next == null;
	}

}
