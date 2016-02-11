package datastructures;

/**
 * A tree structure that does not hold any values
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/10/2016
 */
public class ValuelessTree implements Tree{
	private ValuelessTreeNode root;
	
	/**
	 * Constructor for valueless tree
	 */
	public ValuelessTree() {
		root = new ValuelessTreeNode();
	}
	
	
	@Override
	public ValuelessTreeNode getNode(int[] index) {
		ValuelessTreeNode currentNode = this.root;
		//Traverse tree
		for (int i = 0; i < index.length; i++){
			currentNode = currentNode.getChild(index[i]);
		}
		return currentNode;
	}

	@Override
	public ValuelessTreeNode getRoot() {
		return this.root;
	}

	@Override
	public boolean nodeExist(int[] index) {
		ValuelessTreeNode currentNode = root;
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
		ValuelessTreeNode prunNode = this.getNode(index);
		prunNode.getParent().removeChild(index[index.length - 1]);
	}

	@Override
	public int getNodeChildCount(int[] index) {
		return this.getNode(index).getNumChildren();
	}
	
	/**
	 * Add node and all it's children to the tree
	 * 
	 * @param node	The node to add
	 * @param index	An array of integers that represents the index where the node must be inserted
	 */
	public void graft(ValuelessTreeNode node, int[] index) {
		//create the index of the intended parent node
		int[] parentIndex = new int[index.length - 1];
		for (int i = 0; i < parentIndex.length; i++){
			parentIndex[i] = index[i];
		}
		
		ValuelessTreeNode parent = this.getNode(parentIndex);
		parent.addChildNode(index[index.length - 1], node);
	}

}
