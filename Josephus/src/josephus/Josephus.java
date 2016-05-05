package josephus;
import java.util.Scanner;
public class Josephus implements IQueue{
	//Attributes
	SNode first;
	SNode last;
	//Constructor
	public Josephus(){
		first = null;
		last = null;
	}
	//Queue Methods
	public boolean isEmpty(){
		return first == null;
	}
	public void enqueue(int elem){
		SNode node = new SNode(elem);
		if (this.isEmpty()){
			first = node;
		} else {
			last.next = node;
			node.next = first;
		}
		last = node;
	}
	public void dequeue(){
		if (isEmpty()){
			System.out.println("Queue is empty!");
			return;
		} else{
			first = first.next;
			if (first == null){last = null;}
			return;
		}
	}
	public int getSize(){
		int size = 1;
		for (SNode nodeIt = first; nodeIt != last; nodeIt = nodeIt.next) {
			++size;
		}
		return size;
	}
	public void display(){
		int i;
		SNode find = first.next;
		System.out.print(first.elem);
		for(i=1 ; i<this.getSize() ; i++){
			System.out.print("->" + find.elem);
			find = find.next;
		}
		System.out.println("");
	}
	public void suicide(Josephus list, int people, int inc){
		int i;
		for (i=1 ; i<=people ; i++){
			list.enqueue(i);
		}
		//list.display();
		SNode temp;
		i = 1;
		int size = list.getSize();
		while (size>2){
			if (i%inc == 0){
				System.out.println("Person " + first.elem + " was killed.");
				list.dequeue();
				//list.display();
				i = 1;
				size--;
			}
			else{
				temp = first;
				first = first.next;
				last.next = temp;
				last = temp;
				i++;
			}
		}
		list.display();
	}
	public static void main(String[] args) {
		Scanner input;
		int people;
		int inc;
		input = new Scanner(System.in);
		System.out.println("Enter # of victims: ");
		people = input.nextInt();
		System.out.println("Enter the increment: ");
		inc = input.nextInt();
		input.close();
		System.out.println("Suicide...");
		Josephus list = new Josephus();	
		long start = System.currentTimeMillis();
		list.suicide(list,people,inc);
		long stop = System.currentTimeMillis();
		long time = stop - start;
		System.out.println("Time: " + time/1000 + "." + time%1000 + " seconds.");
	}
}