package datastructures;

public class ValuedTreeNode<T> implements TreeNode, Container<T> {
	private ValuedTreeNode<T> parent;
	private SinglyLinkedList<ValuedTreeNode<T>> children;
	private T value;
	
	/**
	 * Constructor for ValuedTreeNode
	 */
	public ValuedTreeNode() {
		this.parent = null;
		this.children = new SinglyLinkedList<ValuedTreeNode<T>>();
		this.value = null;
	}
	
	/**
	 * Constructor for ValuedTreeNode
	 * 
	 * @param parent	The parent node
	 */
	public ValuedTreeNode(ValuedTreeNode<T> parent){
		this.parent = parent;
		this.children = new SinglyLinkedList<ValuedTreeNode<T>>();
		this.value = null;
	}
	
	/**
	 * Constructor for ValuedTreeNode
	 * 
	 * @param parent	The parent node
	 * @param value		The value of the node
	 */
	public ValuedTreeNode(ValuedTreeNode<T> parent, T value){
		this.parent = parent;
		this.children = new SinglyLinkedList<ValuedTreeNode<T>>();
		this.value = value;
	}
	
	/**
	 * Constructor for ValuedTreeNode
	 * 
	 * @param value	The value of the node
	 */
	public ValuedTreeNode(T value){
		this.parent = null;
		this.children = new SinglyLinkedList<ValuedTreeNode<T>>();
		this.value = value;
	}
	
	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
		
	}

	@Override
	public ValuedTreeNode<T> getParent() {
		return this.parent;
	}
	
	/**
	 * Setter for the parent node
	 * 
	 * @param parent	New parent node
	 */
	public void setParent(ValuedTreeNode<T> parent) {
		this.parent = parent;
	}

	@Override
	public ValuedTreeNode<T> getChild(int index) {
		return this.children.getNodeValue(index);
	}
	
	/**
	 * Adds child node to tree node
	 * 
	 * @param value	Desired index of child
	 * @param index	Value of the child
	 */
	public void addChild(T value,int index){
		this.children.addNode(new ValuedTreeNode<T>(this, value), index);
	}
	
	/**
	 * Adds child node to tree node
	 * 
	 * @param index	Desired index of child
	 * @param child child
	 */
	public void addChildNode(int index, ValuedTreeNode<T> child) {
		this.children.addNode(child, index);
		this.children.getNode(index).getValue().setParent(this);
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
		ValuedTreeNode<T> node = this;
		
		while (!node.isRoot()){
			node = node.getParent();
			depth++;
		}
		return depth;
	}
	
	public String toString() {
		String str = "";
		str += this.value.toString() + ": ";
		str += this.children.toString();
		return str;
	}

}
