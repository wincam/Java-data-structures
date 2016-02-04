package datastructures;

/**
 * A class that represents a doubly-linked list
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	Type of nodes
 */
public class DoublyLinkedList<T> implements LinkedList<T> {
	private DoublyNode<T> head;
	private DoublyNode<T> tail;
	private int size;
	
	/**
	 * Constructor for DoublyList
	 */
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}	
	
	/**
	 * Constructor for DoublyList
	 * 
	 * @param fristValue	The value of the first node
	 */
	public DoublyLinkedList(T fristValue){
		this.head = new DoublyNode<T>(fristValue);
		this.tail = this.head;
		this.size = 1;
	}

	@Override
	public DoublyNode<T> getNode(int index) {
		if ((index >= this.size)||(index < 0)){
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		DoublyNode<T> current = this.head;
		for(int i = 0; i < index; i++){
			if (current.isEnd()){
				return null;
			}
			current = current.getNext();
		}
		return current;
	}

	@Override
	public T getNodeValue(int index) {
		return this.getNode(index).getValue();
	}

	@Override
	public void addNode(T value, int index) {
		//adding to front
		if (index == 0){
			//size is zero
			if (this.size == 0){
				this.head = new DoublyNode<T>(value);
				this.tail = this.head;
			}
			
			else{
				DoublyNode<T> newNode = new DoublyNode<T>(value, null, this.head);
				newNode.getNext().setLast(newNode);
				this.head = newNode;
			}
		}
		//adding to the back
		else if (index == this.size){
			DoublyNode<T> beforeNode = this.getNode(this.size - 1);
			DoublyNode<T> newNode = new DoublyNode<T>(value, beforeNode, null);
			beforeNode.setNext(newNode);
			this.tail = newNode;
		}
		//adding outside the bounds of the list
		else if ((index > this.size)||(index < 0)){
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		//adding to the middle
		else {
			DoublyNode<T> beforeNode = this.getNode(index - 1);
			DoublyNode<T> afterNode = this.getNode(index);
			DoublyNode<T> newNode = new DoublyNode<T>(value, beforeNode, afterNode);
			beforeNode.setNext(newNode);
			afterNode.setLast(newNode);
		}
		this.size++;
	}

	@Override
	public void addToEnd(T value) {
		this.addNode(value, this.size);
	}

	@Override
	public void addToFront(T value) {
		this.addNode(value, 0);	
	}

	@Override
	public void setNodeValue(T value, int index) {
		this.getNode(index).setValue(value);
		
	}

	@Override
	public void removeNode(int index) {
		//removing outside the bounds of the list
		if ((index >= this.size)||(index < 0)){
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		//removing first
		else if (index == 0){
			this.head = this.head.getNext();
			this.head.setLast(null);
		}
		//removing last
		else if (index == this.size - 1) {
			this.tail = this.tail.getLast();
			this.tail.setLast(null);
		}
		//removing from middle
		else {
			DoublyNode<T> beforeNode = this.getNode(index - 1);
			DoublyNode<T> afterNode = this.getNode(index + 1);
			beforeNode.setLast(afterNode);
			afterNode.setLast(beforeNode);
		}
		this.size--;
		
	}
	
	@Override
	public void removeEndNode() {
		this.removeNode(this.size - 1);
	}

	@Override
	public void removeFrontNode() {
		this.removeNode(0);
	}
	
	@Override
	public void addList(LinkedList<T> other, int index) {
		if ((index > this.size)||(index < 0)) {
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		
		for (int i = 0; i < other.getSize(); i++){
			this.addNode(other.getNodeValue(i), index + i);
		}
		
	}

	@Override
	public void addList(LinkedList<T> other) {
		this.addList(other, this.size);
		
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public DoublyLinkedList<T> getSubSection(int startIndex, int endIndex) {
		//Using indexes out of the bounds of the list
		if ((startIndex >= this.size)||(startIndex < 0)){
			throw new IndexOutOfBoundsException("Index " + startIndex + " not in list");
		}
		else if ((endIndex >= this.size)||(endIndex < 0)) {
			throw new IndexOutOfBoundsException("Index " + endIndex + " not in list");
		}
		//Using a start index that is higher than the end index
		if (startIndex > endIndex){
			throw new IllegalArgumentException("Start index: " + startIndex + "is higher than end index: " + endIndex);
		}
		
		DoublyLinkedList<T> subsection = new DoublyLinkedList<T>();
		for (int i = 0; i < (endIndex - startIndex); i++){
			subsection.addNode(getNodeValue(startIndex + i), i);
		}
		return subsection;
	}
	
	public String toString() {
		DoublyNode<T> elementNode = this.head;
		String str = "{";
		for (int i = 0; i < size; i++){
			str += elementNode.toString();
			if (i != size - 1){
				str += ", ";
			}
			elementNode = elementNode.getNext();
		}
		str += "}";
		return str;
	}
	
}
