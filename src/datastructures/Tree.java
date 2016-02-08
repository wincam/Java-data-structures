package datastructures;

/**
 * A interface for tree classes
 * 
 * @author Cameron
 * @version 1.0
 * @since 2/4/2016
 */
public interface Tree {
	
	/**
	 * Getter for a node at an index
	 * 
	 * @param index	An array of integers that represents the index of the node
	 * @return		The node at the index
	 */
	TreeNode getNode(int[] index);
	
	/**
	 * Gets the root node of the tree
	 * 
	 * @return	Root node
	 */
	TreeNode getRoot();
	
	/**
	 * Determines if a node exists at a given index
	 * 
	 * @param index	An array of integers that represents the index of the node
	 * @return		Whether the node exists or not
	 */
	boolean nodeExist(int[] index);
	
	/**
	 * Deletes node at a given index
	 * 
	 * @param index	An array of integers that represents the index of the node
	 */
	void prun(int[] index);
	
	/**
	 * Gets the number of children that a node has
	 * 
	 * @param index	An array of integers that represents the index of the node
	 * @return		The number of children that the node has
	 */
	int getNodeChildCount(int[] index);
	
}
