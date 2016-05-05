package queues;

public class Squeue implements IQueue{
	private SNodeInt first;
	private SNodeInt last;

	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(Integer elem) {
		SNodeInt node = new SNodeInt(elem);
		if (isEmpty()) {
			first = node;
		} else {
			last.next = node;
		}
		last = node;
	}

	public Integer dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		} else {
			Integer firstElem = first.elem;
			first = first.next;
			if (first == null) {
				last = null;
			}
			return firstElem;
		}
	}

	public Integer front() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		return first.elem;
	}

	@Override
	public String toString() {
		String result = null;
		for (SNodeInt nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (result == null) {
				result = "[" + nodeIt.elem.toString() + "]";
			} else {
				result += "," + nodeIt.elem.toString();
			}
		}
		return result == null ? "empty" : result;
	}

	


	@Override
	public int getSize() {
		int size = 0;
		for (SNodeInt node = first; node != null; node = node.next) {
			++size;
		}
		return size;
	}
}
