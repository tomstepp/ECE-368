package part1;

public class WordList implements iWordList{
	//Attributes
	public SNode first;
	
	//Constructor
	public WordList(){
		first = null;
	}
	
	//Methods
	//Insert a string into the list
	public void insertWord(String p){
		// node for new string
		SNode newNode = new SNode(p); // 1
				
		//Check if list is empty
		if (first==null){ 		// 1
			first = newNode;	// 1
			System.out.println(p + " was added as the first word in the dictionary.\n"); 
			return;				// 1
		}
		
		SNode curr = first;		// 1
		SNode prev = null;		// 1
		
		//Iterate through list until at correct place in alphabet
		while ((curr != null) && (curr.elem.compareTo(newNode.elem)<=0 ) ){		//3n + 1
			//Check if the word exists in the dictionary
			if (curr.elem.compareTo(newNode.elem)==0){							//2n
				System.out.println(p + " already exists in the dictionary.\n"); //1 (uncomment for part 1)
				return;															//1
			}
			prev = curr;														//n
			curr = curr.next;													//n
		}
		
		//Special case: if before all words, then update first
		if (prev == null){														//1
			newNode.next = first;												//1
			first = newNode;													//1
			System.out.println(p + " was added as the first word in the dictionary.\n"); 
			return;																//1
		}
		
		//Update nodes so word is in correct position
		prev.next = newNode;													//1
		newNode.next = curr;													//1
		
		System.out.println(p + " was added to the dictionary.\n"); 
		return;																	//1
		
		//Temporal Complexity:
		//NOTE: Print statements are not included in the calculated complexity
		//Case 1: empty list = 4 (always)
		//Case 2: insert at beginning = 10 (always)
		//Case 3: insert elsewhere = 7n + 10 (worst case)
	}
	
	//Remove a word from the list
	public void removeWord(String p){
		SNode curr = first;		//1
		SNode prev = null;		//1
		
		//Iterate through entire list
		while(curr != null){							//n (+1)
			//If the entry is found, remove from list
			if (curr.elem.compareTo(p) == 0){			//2n
				//Special case: first in list
				if (prev == null){						//1
					first = first.next;					//1
					System.out.println(p + " was found and removed from dictionary.\n"); //1
					return; //1
				}
				//Remove word
				prev.next = curr.next;		//1
				System.out.println(p + " was found and removed from dictionary.\n"); //1
				return;				//1
			}
			//Update nodes
			prev = curr;		//n
			curr = curr.next; 	//n
		}
		System.out.println(p + " was not found in dictionary.\n"); //1
		return; //1
		
		//Temporal Complexity:
		//NOTE: Print statements are included in the calculated complexity
		//Case 1: first in list = 9 (always)
		//Case 2: not first = 5n + 6 (worst case)
		//Case 3: not in list = 5n + 5 (always)
	}
	
	//Find a word in the list
	public int searchWord(String p){
		SNode curr = first;		//1
		//Start index at zero
		int index = 0;			//1
		
		//Iterate through entire list
		while(curr != null){	//n (+1)
			//If the word is found, then return the index value
			if (curr.elem.compareTo(p) == 0){	//2n
				System.out.println(p + " was found in the dictionary at: " + index);
				return index;					//1
			}
			//update index and current node
			index++;			//n
			curr = curr.next;	//n
		}
		//Return '-1' if the word is not in list
		System.out.println(p + " was not found in the dictionary. (index = -1)");
		return -1;	//1
		
		//Temporal Complexity:
		//NOTE: print statements not included in the calculated complexity
		//Case 1: in list = 5n + 3
		//Case 2: not in list = 5n + 4
	}
	
	//Print all words with a specific letter from list
	public void consultLetter(char c){
		SNode curr = first;						//1
		
		//Special case: print entire list
		if (c == ' '){							//1
			while(curr != null){				//n + 1
				System.out.println(curr.elem); 	//n
				curr = curr.next;				//n
			}
			System.out.println("");				//1
			return;								//1
		}
		
		//Otherwise, search for all words that start with c
		//boolean to check if at least one word was found
		boolean contains = false; 				//1
		while(curr != null){ 					//n + 1
			//use charAt(0) to obtain the first letter of the word
			if (curr.elem.charAt(0) == c){		//2n
				System.out.println(curr.elem);	//n
				contains = true;				//n
			}
			curr = curr.next;					//n
		}

		if (contains == false){					//1
			System.out.println("There are no words that start with: " + c + ".\n");	//1
		}
		else {
			System.out.println("");	//1
		}
		return;	//1
		
		//Temporal Complexity:
		//NOTE: print statements are included in the calculated complexity
		//Case 1: space = 3n + 5 (always)
		//Case 2: letter found = 6n + 6 (worst case -> all words start with c)
		//Case 3: letter not found = 4n + 6 (always)
	}
}