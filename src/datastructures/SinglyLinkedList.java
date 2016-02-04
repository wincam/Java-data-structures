package datastructures;
/**
 * A class that represents a singly-linked list
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	Type of nodes
 */
public class SinglyLinkedList<T> implements LinkedList<T> {
	private SinglyNode<T> head;
	int size;
	
	/**
	 * Constructor for SinglyLinkedList
	 * 
	 * @param fristValue	The value of the first node
	 */
	public SinglyLinkedList(T fristValue){
		this.head = new SinglyNode<T>(fristValue);
		this.size = 1;
	}
	
	/**
	 * Constructor for SinglyLinkedList
	 */
	public SinglyLinkedList(){
		this.head = null;
		this.size = 0;
	}
	
	@Override
	public SinglyNode<T> getNode(int index){
		if ((index >= this.size)||(index < 0)){
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		//Iterates through list until node is found
		SinglyNode<T> current = this.head;
		for(int i = 0; i < index; i++){
			if (current.isEnd()){
				return null;
			}
			current = current.getNext();
		}
		return current;
	}
	
	@Override
	public T getNodeValue(int index){
		SinglyNode<T> elementNode = getNode(index);
		if(elementNode != null){
			return elementNode.getValue();
		}
		return null;
	}
	
	@Override
	public void addNode(T value, int index){
		//adding to front
		if (index == 0){
			SinglyNode<T> newNode = new SinglyNode<T>(value, this.head);
			this.head = newNode;
		}
		//adding to back
		else if (index == this.size){
			SinglyNode<T> newNode = new SinglyNode<T>(value);
			SinglyNode<T> lastNode = getNode(this.size - 1);
			lastNode.setNext(newNode);
		}
		//adding outside the bounds of the list
		else if ((index > this.size)||(index < 0)) {
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		//adding to the middle
		else{
			SinglyNode<T> beforeNode = getNode(index - 1);
			SinglyNode<T> afterNode = getNode(index);
			SinglyNode<T> newNode = new SinglyNode<T>(value, afterNode);
			beforeNode.setNext(newNode);
		}
		this.size++;
	}
	
	@Override
	public void addToEnd(T value){
		addNode(value, this.size);
	}
	
	@Override
	public void addToFront(T value) {
		addNode(value, 0);
		
	}
	
	@Override
	public void setNodeValue(T value, int index) {
		getNode(index).setValue(value);
	}
	
	@Override
	public void removeNode(int index){
		//removing outside the bounds of the list
		if ((index >= this.size)||(index < 0)) {
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		//removing from the front
		else if (index == 0){
			this.head = getNode(1);
		}
		//removing from the end
		else if (index == this.size - 1){
			getNode(index - 1).setNext(null);
		}
		//adding to the middle of the list
		else{
			getNode(index - 1).setNext(getNode(index + 1));
		}
		this.size--;
	}
	
	@Override
	public void removeEndNode() {
		removeNode(this.size - 1);
		
	}

	@Override
	public void removeFrontNode() {
		removeNode(0);
		
	}
	
	@Override
	public void addList(LinkedList<T> other, int index) {
		if ((index > this.size)||(index < 0)) {
			throw new IndexOutOfBoundsException("Index " + index + " not in list");
		}
		
		for (int i = 0; i < other.getSize(); i++){
			 addNode(other.getNodeValue(i), index + i);
		}
	}

	@Override
	public void addList(LinkedList<T> other){
		addList(other, this.size);
		
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public SinglyLinkedList<T> getSubSection(int startIndex, int endIndex) {
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
		
		SinglyLinkedList<T> subsection = new SinglyLinkedList<T>();
		for (int i = 0; i < (endIndex - startIndex); i++){
			subsection.addNode(getNodeValue(startIndex + i), i);
		}
		return subsection;
	}
	
	public String toString(){
		SinglyNode<T> elementNode = this.head;
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
