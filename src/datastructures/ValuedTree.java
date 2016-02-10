package datastructures;

/**
 * A tree class that stores values
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/5/2016
 *
 * @param <T>	The type that tree holds
 */
public class ValuedTree<T> implements Tree {
	private ValuedTreeNode<T> root;
	
	/**
	 * Constructor for ValuedTree
	 */
	public ValuedTree() {
		this.root = new ValuedTreeNode<>(null);
	}
	
	/**
	 * Constructor for ValuedTree
	 * 
	 * @param value	Value of the root node
	 */
	public ValuedTree(T value){
		this.root = new ValuedTreeNode<T>(value);
	}
	
	@Override
	public ValuedTreeNode<T> getNode(int[] index) {
		ValuedTreeNode<T> currentNode = this.root;
		//Traverse tree
		for (int i = 0; i < index.length; i++){
			currentNode = currentNode.getChild(index[i]);
		}
		return currentNode;
	}

	@Override
	public ValuedTreeNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean nodeExist(int[] index) {
		ValuedTreeNode<T> currentNode = root;
		//Traverse tree
		for (int i = 0; i < index.length; i++){
			//Check if child exists
			if (currentNode.getNumChildren() > index[i]){
				currentNode = currentNode.getChild(index[i]);
			}
			else {
				return false;
			}
		}
		return true;
	}

	@Override
	public void prun(int[] index) {
		ValuedTreeNode<T> prunNode = this.getNode(index);
		prunNode.getParent().removeChild(index[index.length - 1]);
	}

	@Override
	public int getNodeChildCount(int[] index) {
		return this.getNode(index).getNumChildren();
	}
	
	public String toString() {
		return root.toString();
	}
	
	/**
	 * Gets the value of a node
	 * 
	 * @param index	An array of integers that represents the index of the node
	 * @return		The value of the node
	 */
	public T getNodeValue(int[] index) {
		return this.getNode(index).getValue();
	}
	
	
	/**
	 * Set the value of a node
	 * 
	 * @param value	The new value of the node
	 * @param index	An array of integers that represents the index of the node
	 */
	public void setNodeValue(T value, int[] index) {
		this.getNode(index).setValue(value);
	}
	
	/**
	 * Add node and all it's children to the tree
	 * 
	 * @param node	The node to add
	 * @param index	An array of integers that represents the index where the node must be inserted
	 */
	public void graft(ValuedTreeNode<T> node, int[] index) {
		//create the index of the intended parent node
		int[] parentIndex = new int[index.length - 1];
		for (int i = 0; i < parentIndex.length; i++){
			parentIndex[i] = index[i];
		}
		
		ValuedTreeNode<T> parent = this.getNode(parentIndex);
		parent.addChildNode(index[index.length - 1], node);
		
		
	}
	
	/**
	 * Searches tree for a value and returns -1 if it is not found
	 * 
	 * @param value	Value to search for
	 * @return		Location of value if found other wise {-1}
	 */
	public int[] search(T value) {
		if (root.getValue().equals(value)){
			return new int[0];
		}
		return root.search(value);
	}

}
