package datastructures;

/**
 * An interface for the nodes of tree structures
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/4/2016
 * 
 * @param <T>	Type of stored value
 */
public interface TreeNode{
	
	/**
	 * Gets the parent node
	 * 
	 * @return	Parent node
	 */
	TreeNode getParent();
	
	/**
	 * Get the child node that corresponds to an index
	 * 
	 * @param index	Index of child node
	 * @return		Child node
	 */
	TreeNode getChild(int index);
	
	/**
	 * Get the number of children
	 * 
	 * @return	Number of children
	 */
	int getNumChildren();
	
	/**
	 * Checks if the node is the root of a tree
	 * 
	 * @return	Whether the node is a root or not
	 */
	boolean isRoot();
	
	/**
	 * Checks if the node is a leaf of a tree
	 * 
	 * @return	Whether the node is a leaf or not
	 */
	boolean isLeaf();
	
	
	/**
	 * Gets the depth of the node (the number of edges to the root)
	 * 
	 * @return	The depth
	 */
	int getDepth();

}
