package datastructures;

public class Tester{

	public static void main(String[] args) {
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<Integer>(300);
		for (int i = 0; i < 10; i++){
			linkedList.addToEnd(i * 10);
		}
		
		for (int i = 0; i < 20; i++){
			linkedList2.addToEnd(i * 10);
		}
		System.out.println(linkedList2.toString());
		System.out.println(linkedList.toString());
		linkedList.addToEnd(21);
		System.out.println(linkedList.toString());
		linkedList.removeNode(0);
		System.out.println(linkedList.toString());
		
		linkedList.addList(linkedList2, 2);
		System.out.println(linkedList.toString());
		System.out.println(linkedList.getSubSection(3, 10).toString());
		
		
		
		System.out.println("Trees");
		
		ValuedTree<Integer> testTree = new ValuedTree<Integer>(10);
		for (int i = 0; i < 7; i++){
			testTree.getRoot().addChild(i*20,i);
			for (int j = 0; j < 20; j++) {
				testTree.getRoot().getChild(i).addChild(j*30,j);
			}
		}
		
		System.out.println(testTree.nodeExist(new int[]{7}));
		
		System.out.println(testTree.toString());
		ValuedTreeNode<Integer> node = new ValuedTreeNode<>(300);
		node.addChild(40, 0);
		node.addChild(41, 0);
		testTree.graft(node, new int[]{0,0,0});
		System.out.println(testTree.toString());
		
		int[] index = testTree.search(120);
		for (int i = 0; i < index.length; i++){
			System.out.println(index[i]);
		}
		
	}

}
