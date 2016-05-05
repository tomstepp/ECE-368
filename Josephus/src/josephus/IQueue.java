package josephus;
public interface IQueue {
	public boolean isEmpty();
	public void enqueue(int elem);
	public void dequeue();
	public int getSize();
}