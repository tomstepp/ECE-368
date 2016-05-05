package palindrome;

public interface IListCharacter {
	public void addFirst(Character newElem);

	public void addLast(Character newElem);

	public void removeFirst();

	public void removeLast();
	
	
	public void insertAt(int index, Character newElem);
	
	public boolean isEmpty();

	public boolean contains(Character elem);

	public int getSize();

	public int getIndexOf(Character elem);

	public Character getFirst();

	public Character getLast();

	public Character getAt(int index);
	
	public String toString();

	public void removeAll(Character elem);

	public void removeAt(int index);
}
