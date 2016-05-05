package part1;
public class Test1 {
	public static void main(String[] args) {
		
		System.out.println("Test for package 1.\n");
		//Create word list
		WordList list = new WordList();		
		
		//Add words to list
		System.out.println("1. Add words to the list.\n");
		list.insertWord("zebra");
		list.insertWord("hawaii");
		list.insertWord("hawaii");
		list.insertWord("mountain");
		list.insertWord("apple");//first in list
		list.insertWord("hat");
		list.insertWord("phone");
		list.insertWord("potato");
		list.insertWord("joker");
		list.insertWord("lamp");
		list.insertWord("mouse");
		list.insertWord("house");
		
		//Print list
		System.out.println("2. Print list.\n");
		list.consultLetter(' ');
		
		//Remove a word from the list
		System.out.println("3. Remove a word from the list.\n");
		list.removeWord("moon"); //not in dictionary
		list.removeWord("hello"); //not in dictionary
		list.removeWord("phone");
		list.removeWord("apple");
		list.removeWord("zebra");
		
		//Print list
		System.out.println("4. Print list.\n");
		list.consultLetter(' ');
		
		//Consult Letter
		System.out.println("5. Consult letter.\n");
		list.consultLetter('h');
		list.consultLetter('y'); //no words start with 'y'
		
		//Print list
		System.out.println("6. Print list.\n");
		list.consultLetter(' ');
		
		//Find a word in the list and print the position
		System.out.println("7. Print the position of words.\n");
		list.searchWord("hat");
		list.searchWord("potato");
		list.searchWord("lamp");
		list.searchWord("moon"); //not in list
	}
}