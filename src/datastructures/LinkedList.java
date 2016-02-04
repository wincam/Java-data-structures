package datastructures;

/**
 * An interface for linked lists
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/3/2016
 *
 * @param <T>	Type of nodes
 */
public interface LinkedList<T> {
	/**
	 * Getter for a node
	 * 
	 * @param index Index of the node
	 * @return		Reference to a node
	 */
	Node<T> getNode(int index);
	
	/**
	 * Getter for the value of a node in the linked list
	 * 
	 * @param index	Index of the node that contains the value of the node
	 * @return		Value
	 */
	T getNodeValue(int index);
	
	/**
	 * Adds node to linked list
	 * 
	 * @param value	The value of the new node
	 * @param index	The index of the new node
	 */
	void addNode(T value, int index);
	
	/**
	 * Adds node to the end of the linked list
	 * 
	 * @param value	The value of the new node
	 */
	void addToEnd(T value);
	
	/**
	 * Adds node to the front of the linked list
	 * 
	 * @param value	The value of the new node
	 */
	void addToFront(T value);
	
	/**
	 * Changes the value of the node
	 * 
	 * @param value	New value of node
	 * @param index	Index of node
	 */
	void setNodeValue(T value, int index);
	
	/**
	 * Deletes node
	 * 
	 * @param index	Index of node
	 */
	void removeNode(int index);
	
	/**
	 * Deletes end node
	 */
	void removeEndNode();
	
	/**
	 * Deletes front node
	 */
	void removeFrontNode();
	
	/**
	 * Adds two linked lists together by inserting one into another at a certain index
	 * 
	 * @param other						The inserted linked list
	 * @param index						The starting index of the inserted linked list
	 */
	void addList(LinkedList<T> other, int index);
	
	/**
	 * Adds two linked lists together by inserted one at the end of the other
	 * 
	 * @param other						The linked list that is inserted at the end
	 */
	void addList(LinkedList<T> other);
	
	/**
	 * Getter for size of linked list
	 * 
	 * @return	Size of list
	 */
	int getSize();
	
	/**
	 * Determines if the linked list is empty
	 * 
	 * @return	Whether the linked list is empty or not
	 */
	boolean isEmpty();
	
	/**
	 * Returns a new linked list that is a subsection of this linked list
	 * 
	 * @param startIndex	First element to be included
	 * @param endIndex		First element to be excluded
	 * @return				Subsection
	 */
	LinkedList<T> getSubSection(int startIndex, int endIndex);
}
