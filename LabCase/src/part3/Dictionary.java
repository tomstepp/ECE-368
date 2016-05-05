package part3;
import part2.Variations;

public class Dictionary implements iDictionary{
	//Attributes
	public DNode first;
	
	//Constructor
	public Dictionary(){
		first = null;
	}
	
	//METHODS
	//Insert word to dictionary
	public void insertWord(String p){
		DNode newNode = new DNode(p); // node for new string
		
		Variations vary = new Variations(p); //create variations
		newNode.list = vary.list;			//assign variations to node

		//Check if list is empty
		if (first==null){
			first = newNode;
			System.out.println("Word was successfully inserted.");
			return;
		}
		
		DNode curr = first;
		DNode prev = null;
		
		//Iterate through list until at correct place in alphabet
		while ((curr != null) && (curr.elem.compareTo(newNode.elem)<=0 ) ){
			if (curr.elem.compareTo(newNode.elem)==0){
				System.out.println("This word already exists in the dictionary.");
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		if (prev == null){
			newNode.next = first;
			first = newNode;
			System.out.println("Word was successfully inserted.");
			return;
		}
		prev.next = newNode;
		newNode.next = curr;
		System.out.println("Word was successfully inserted.");
		return;
	}
	
	//Remove word from dictionary
	public void removeWord(String p){
		DNode curr = first;
		DNode prev = null;
		
		while(curr != null){
			if (curr.elem.compareTo(p) == 0){
				if (prev == null){
					first = first.next;
					System.out.println("Word was successfully removed.");
					return;
				}
				prev.next = curr.next;
				System.out.println("Word was successfully removed.");
				return;				
			}
			prev = curr;
			curr = curr.next;
		}
		System.out.println("'" + p + "'" + " was not found in dictionary.");
		return;	
	}
	
	//Return position of word in dictionary
	public int searchWord(String p){
		DNode curr = first;
		int index = 0;
		while(curr != null){
			if (curr.elem.compareTo(p) == 0){
				System.out.println("Word was successfully found at: " + index);
				return index;
			}
			index++;
			curr = curr.next;
		}
		System.out.println("Word was not found. (index = -1)");
		return -1;
	}
	
	//Print variations
	public void printVariations(String p){
		DNode curr = first;
		while(curr != null){
			if (curr.elem.compareTo(p) == 0){
				curr.list.consultLetter(' '); //print variations list
				return;
			}
			curr = curr.next;
		}
		System.out.println("'" + p + "'" + " was not found in dictionary.");
		return;
	}
}

