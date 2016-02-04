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
	}

}
