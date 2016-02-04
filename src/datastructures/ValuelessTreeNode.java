package datastructures;

/**
 * A tree node class that contains no value
 * 
 * @author Cameron Nicolle
 * @version 1.0
 * @since 2/4/2016
 */
public class ValuelessTreeNode implements TreeNode{
	private ValuelessTreeNode parent;
	private SinglyLinkedList<ValuelessTreeNode> children;
	
	/**
	 * Constructor for tree node
	 */
	public ValuelessTreeNode() {
		this.parent = null;
		this.children = new SinglyLinkedList<ValuelessTreeNode>();
	}
	
	/**
	 * Constructor for tree node
	 * 
	 * @param parent	The parent node
	 */
	public ValuelessTreeNode(ValuelessTreeNode parent){
		this.parent = parent;
		this.children = new SinglyLinkedList<ValuelessTreeNode>();
	}
	

	@Override
	public ValuelessTreeNode getParent() {
		return this.parent;
	}

	@Override
	public ValuelessTreeNode getChild(int index) {
		return this.children.getNodeValue(index);
	}
	
	/**
	 * Adds child node to tree node
	 * 
	 * @param index	Desired index of child
	 */
	public void addChild(int index){
		this.children.addNode(new ValuelessTreeNode(), index);
	}
	
	@Override
	public void removeChild(int index) {
		this.children.removeNode(index);
		
	}
	
	@Override
	public int getNumChildren() {
		return this.children.getSize();
	}

	@Override
	public boolean isRoot() {
		return this.parent == null;
	}

	@Override
	public boolean isLeaf() {
		return this.children.getSize() == 0;
	}

	@Override
	public int getDepth() {
		int depth = 0;
		ValuelessTreeNode node = this;
		
		while (!node.isRoot()){
			node = node.getParent();
			depth++;
		}
		return depth;
	}

}
