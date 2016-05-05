package linkedlist;

public class Test {

	public static void main(String[] args) {

		//----------create list----------
		SListLast list1 = new SListLast();
		list1.display();
		//is empty?
		list1.isEmpty();
		//add first
		list1.addFirst(1);
		list1.display();
		System.out.println("");
		//add last2
		list1.addLast(99);
		list1.display();
		
		//----------insert at----------
		list1.insertAt(50, 1);
		list1.insertAt(66, 2);
		list1.insertAt(81, 3);
		list1.insertAt(0,0);
		list1.display();
		System.out.println("");
		
		//contains
		list1.contains(50);
		list1.contains(-111);
		
		//----------get----------
		//get size
		list1.getSize();
		
		//get index of
		list1.getIndexOf(50);
		list1.getIndexOf(-111);
		
		//get first
		list1.getFirst();
		
		//get last
		list1.getLast();
		
		//get at
		list1.getAt(1);
		list1.getAt(999);
		System.out.println("");
		
		//----------remove----------
		//remove first
		list1.removeFirst();
		list1.display();
		
		//remove last
		list1.removeLast();
		list1.display();
		
		//remove all
		list1.addFirst(66);
		//list1.addFirst(7);
		list1.addFirst(66);
		list1.addLast(66);
		System.out.println("");
		list1.display();
		System.out.println("");
		list1.removeAll(66);
		System.out.println("");
		list1.display();
		
		//remove at
		list1.removeAt(10);
		list1.display();
		list1.removeFirst();
		list1.isEmpty();
		list1.display();
		
	}

}
