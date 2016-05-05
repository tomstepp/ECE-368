package lists;

public class SListInt implements IListInt{
public SNodeInt first; 
	
	
	public void addFirst(int newElem) {
		
		SNodeInt newNode = new SNodeInt(newElem);
		newNode.next = first;
		first = newNode;
	}

	
	
	public void addLast(int newElem) {
		
		
		if (isEmpty()) addFirst(newElem); 
		else {

			SNodeInt node = new SNodeInt(newElem);
			
			SNodeInt last = first;
			while (last.next!=null) {
				last = last.next;
			}
			
			last.next = node;
		}
	}
	
	
	
	

	
	@Override
	public void insertAt(int index, int newElem) {
		
		System.out.println("adding : " + newElem + " at position: " + index);
		
		SNodeInt newNode = new SNodeInt(newElem);
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			int i = 1;
			boolean inserted=false;
			for (SNodeInt nodeIt = first; nodeIt != null && inserted==false; nodeIt = nodeIt.next) {
				if (i == index) {
					newNode.next = nodeIt.next;
					nodeIt.next = newNode;
					inserted=true;
				}
				++i;
			}
			if (!inserted) System.out.println("SList: Insertion out of bounds");
		}
	}

	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public boolean contains(int elem) {
		boolean found=false;
		for (SNodeInt nodeIt = first; nodeIt != null && found==false; nodeIt = nodeIt.next) {
			if (nodeIt.elem==elem) {
				found= true;
			}
		}
		return found;
	}

	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
		}
	}

	public void removeLast() {
		SNodeInt lastNode = null;
		SNodeInt previousNode = null;
		for (SNodeInt nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			previousNode = lastNode;
			lastNode = nodeIt;
		}
		if (previousNode == null) first=null;
		else previousNode.next = null;
	}


	@Override
	public void removeAll(int elem) {
		System.out.println("removing all " + elem);
		SNodeInt previousNode = null;
		for (SNodeInt nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (nodeIt.elem==elem) {
				if (previousNode == null) {
					first = nodeIt.next;
				} else {
					previousNode.next = nodeIt.next;
				}
			} else {
				previousNode = nodeIt;
			}
		}
	}

	@Override
	public void removeAt(int index) {
		
		System.out.println("removing at position: " + index);
		
		int i = 0;
		SNodeInt previousNode = null;
		boolean removed=false;
		for (SNodeInt nodeIt = first; nodeIt != null && removed==false; nodeIt = nodeIt.next) {
			if (i == index) {
				if (previousNode == null) {
					first = nodeIt.next;
				} else {
					previousNode.next = nodeIt.next;
				}
				removed=true;
			}
			++i;
			previousNode = nodeIt;
		}
		if (!removed) System.out.println("SList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		int size = 0;
		for (SNodeInt node = first; node != null; node = node.next) {
			++size;
		}
		return size;
	}

	@Override
	public int getIndexOf(int elem) {
		System.out.println("index of " + elem);
		
		int index = -1;
		int pos=0;
		for (SNodeInt node = first; node != null && index==-1; node = node.next) {
			if (node.elem==elem) {
				index=pos;
			}
			++pos;
		}
		return index;
	}

	@Override
	public int getFirst() {
		int result=-1;
		if (first == null) {
			System.out.println("SList: List is empty");
		} else result=first.elem;
		return result;
	}

	@Override
	public int getLast() {
		SNodeInt lastNode = null;
		for (SNodeInt node = first; node != null; node = node.next) {
			lastNode = node;
		}
		int result=-1;
		if (lastNode == null) {
			System.out.println("SList: List is empty");
		} else result=lastNode.elem;
		return result;
	}

	@Override
	public int getAt(int index) {
		int i = 0;
		int result=-1;
		boolean found=false;
		for (SNodeInt nodeIt = first; nodeIt != null && !found; nodeIt = nodeIt.next) {
			if (i == index) {
				result= nodeIt.elem;
				found=true;
			}
			++i;
		}
		if (!found) System.out.println("SList: Get out of bounds");
		return result;
	}

	public String toString() {
		String result = null;
		for (SNodeInt nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (result == null) {
				result = String.valueOf(nodeIt.elem);
			} else {
				result += "," + String.valueOf(nodeIt.elem);
			}
		}
		return result == null ? "empty" : result;
	}

	

	public static void main(String[] args) {
		// incomplete test
		IListInt list = new SListInt();
		System.out.println(list.toString());
		System.out.println("isEmpty?" + list.isEmpty());

		list.addLast(1);
		System.out.println(list.toString());

		list.removeLast();
		System.out.println(list.toString());
		
		list.addLast(1);
		System.out.println(list.toString());

		list.removeFirst();
		System.out.println(list.toString());
		
		list.addLast(1);
		list.addLast(1);
		System.out.println(list.toString());
		
		list.addFirst(2);
		System.out.println(list.toString());
		
		list.addFirst(3);
		System.out.println(list.toString());
		
		list.addLast(4);
		System.out.println(list.toString());
		
		list.insertAt(2, 5);
		System.out.println(list.toString());
		
		list.removeAll(0);
		System.out.println(list.toString());
		
		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		list.removeFirst();
		list.removeLast();
		System.out.println(list.toString());

		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		
		
		System.out.println("Size: " + list.getSize());
		
		for (int i=0; i<list.getSize();i++) {
			System.out.println("Element at position " + i + ":"+ list.getAt(i));
		}
		

		
		list.insertAt(5, 6);
		System.out.println(list.toString());
		list.insertAt(0, 7);
		System.out.println(list.toString());
		
		list.insertAt(list.getSize()+5, 9);
		System.out.println(list.toString());
		
		
		list.removeAll(1);
		System.out.println(list.toString());
		
		System.out.println("contains 1?" + list.contains(1));
		System.out.println("contains 7?" + list.contains(7));

		System.out.println("isEmpty?" + list.isEmpty());

		System.out.println(list.getIndexOf(7));
		System.out.println(list.getIndexOf(1));
		System.out.println("Index of 6? " + list.getIndexOf(6));

		list.removeAt(5);
		System.out.println(list.toString());
		list.removeAt(2);

		System.out.println(list.toString());

		
	}
}
