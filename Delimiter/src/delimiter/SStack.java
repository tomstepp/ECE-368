package delimiter;

public class SStack implements IStack {
	//Attributes
	SNode peak;
	
	//Constructor
	public SStack(){
		peak = null;
	}
	
	public boolean isOpen(Character c){
		if (c==('[' | '(' |'{')){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isClose(Character c){
		if (c==(']' | ')' |'}')){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Reverse
	public String reverse(SStack word){
		String rev = "";
		
		int i;
		int size = this.getSize();
		
		for (i=0;i<size;i++){
			rev = rev + word.pop();
		}
		
		return rev;
	}
	
	//Methods
	
	public boolean isEmpty(){
		return (peak == null);
	}
	
	public void push(Character elem){
		SNode newNode = new SNode(elem);
		newNode.next = peak;
		peak = newNode;
	}
	
	public Character top(){
		if (isEmpty()){
			System.out.println("The stack is empty.");
			return null;
		}
		return peak.elem;
	}
	
	public Character pop(){
		if (isEmpty()){
			System.out.println("The stack is empty.");
			return null;
		}
		Character elem = peak.elem;
		peak = peak.next;
		return elem;
	}
	
	public int getSize(){
		int size = 0;
		SNode node = peak;
		while (node != null){
			size++;
			node = node.next;
		}
		return size;
	}
	
}
