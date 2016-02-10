package datastructures;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNodeChildCount(int[] index) {
		// TODO Auto-generated method stub
		return 0;
	}

}
