package linkedlist;

public interface IList {
	public void addFirst(int newElem);
	public void addLast(int newElem);
	public void insertAt(int newElem, int index);
	
	public boolean isEmpty();
	public boolean contains(int elem);
	
	public int getSize();
	public int getIndexOf(int elem);
	
	public int getFirst();
	public int getLast();
	public int getAt(int index);
	
	public void removeFirst();
	public void removeLast();
	public void removeAll(int elem);
	public void removeAt(int index);
	
	public void display();
}
