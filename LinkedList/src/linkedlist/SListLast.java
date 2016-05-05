package linkedlist;

public class SListLast implements IList{
	//Attributes
	SNode first;
	SNode last;
	
	//Constructor
	public SListLast(int...args){
		first = null;
		last = null;
		
		int i;
		for (i = 0; i < args.length; i++){
			this.addLast(args[i]);
		}
		
	}
	
	//-----Methods-----
	
	//determine if the list is empty
	public boolean isEmpty(){
		if (first == null){
			System.out.println("This list is empty.");
			return true;
		}else{
			System.out.println("This list is not empty.");
			return false;
		}
	}
	
	//add an element to the beginning of the list
	public void addFirst(int newElem){
		SNode newNode = new SNode(newElem);
		newNode.next = first;
		first = newNode;
		System.out.println("Added " + newElem + " to list.");
	}
	
	//add an element to the end of the list
	/*public void addLast(Object newElem){
		SNode newNode = new SNode(newElem);
		
		SNode find = first;
		while(find.next != null){
			find = find.next;
		}
		
		find.next = newNode;
		last = newNode;
		System.out.println("\nAdded " + newElem + " to list.");
	}*/
	
	//take 2
	public void addLast(int newElem){
		
		if (isEmpty()) addFirst(newElem);
		else{
			SNode newNode = new SNode(newElem);
			
			SNode find = first;
			while(find.next != null){
				find = find.next;
			}
			
			find.next = newNode;
			last = newNode;
			System.out.println("Added " + newElem + " to list.");
		}
	}
	
	//insert an element to an index of the list
	public void insertAt(int newElem, int index){
		if (index == 0){
			addFirst(newElem);
			return;
		}
		SNode newNode = new SNode(newElem);
		SNode find = first;
		
		int i;
		for(i=0;i<(index-1);i++){
			find = find.next;
		}
		
		newNode.next = find.next;
		find.next = newNode;
		System.out.println("Added " + newElem + " to list.");
		
	}
	
	//determine if the list contains an element
	public boolean contains(int elem){
		SNode find = first;
		
		while (find != null){
			if (find.elem == elem){
				System.out.println("The list contains " + elem + ".");
				return true;
			}			
			find = find.next;
		}
		System.out.println("The list does not contain " + elem + ".");
		return false;
	}
	
	//get the size of the list
	public int getSize(){
		int size = 0;
		SNode find = first;
		
		while (find != null){
			size++;
			find = find.next;
		}
		System.out.println("The list has " + size + " elements.");
		return size;
	}
	
	//get the index of an element
	public int getIndexOf(int elem){
		SNode find = first;
		int index = 0;
		while (find.next != null){
			if (find.elem == elem){
				System.out.println("Elem " + elem + " is at index: " + index);
				return index;
			}
			index++;
			find = find.next;
		}
		System.out.println("The element is not in the list.");
		return -1;
	}
	
	//return the first object of the list
	public int getFirst(){
		System.out.println("First element: " + first.elem + " at " + first);
		return first.elem;
	}
	
	//return the last object of the list
	public int getLast(){
		System.out.println("Last element: " + last.elem + " at " + last);
		return last.elem;
	}
	
	//return an object at an index from the list
	public int getAt(int index){
		if (index >= getSize()){
			System.out.println("Index is out of bounds.");
			return -1;
		}
		SNode find = first;
		int i;
		for(i=0;i<index;i++){
			find = find.next;
		}
		System.out.println("Index #" + index + " contains: " + find.elem);
		return find.elem;
	}
	
	//remove the first element from the list
	public void removeFirst(){
		if (!isEmpty()){
			first = first.next;
		}
		System.out.println("Removed first from list.");
	}
	
	//remove the last element from the list
	public void removeLast(){
		SNode lastNode = null;
		SNode prev = null;
		SNode nodeIt = null;
		
		for (nodeIt = first; nodeIt != null; nodeIt = nodeIt.next){
			prev = lastNode;
			lastNode = nodeIt;
		}
		
		if (prev == null){
			first = null;
		} else {
			prev.next = null;
		}
		System.out.println("Removed last from list.");
	}
	
	//remove all of an element from the list
	public void removeAll(int elem){
		SNode curr = first;
		SNode prev = null;
		
		while(curr != null){
			if (curr.elem == elem && prev!= null){
				prev.next = curr.next;
			}else if (prev == null && curr.elem == elem){
				first = curr.next;
			}else{
				prev = curr;
			}
			curr = curr.next;
		}
		System.out.println("Removed all " + elem + " from list.");
	}
	
	//remove an element at an index from the list
	public void removeAt(int index){
		if (index >= getSize()){
			System.out.println("Index is out of bounds.");
			return;
		}
		SNode find = first;
		int i;
		for(i=0;i<(index-1);i++){
			find = find.next;
		}
		
		find.next = find.next.next;
		System.out.println("Removed index " + index + " from list.");
		return;
	}
	
	public void display(){
		System.out.print("List = ");
		SNode find = first;
		while(find != null){
			System.out.print(find.elem + " ");
			find = find.next;
		}
		System.out.println("");
		return;
	}

}