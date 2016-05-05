package part3;
public class Test3 {
	public static void main(String[] args) {
		System.out.println("Test for package 3.\n");

		//Create dictionary
		System.out.println("1. Create a dictionary.\n");
		Dictionary d = new Dictionary();
		
		//Insert words
		System.out.println("2. Add words to dictionary.\n");
		d.insertWord("zebra");
		d.insertWord("hawaii");
		d.insertWord("hawaii");
		d.insertWord("mountain");
		d.insertWord("apple");//first in d
		d.insertWord("hat");
		d.insertWord("phone");
		d.insertWord("potato");
		d.insertWord("joker");
		d.insertWord("lamp");
		d.insertWord("mouse");
		d.insertWord("house");
		
		//Print dictionary
		System.out.println("3. Print the dictionary.\n");
		DNode find = d.first;
		while(find != null){
			System.out.println(find.elem);
			find = find.next;
		}

		//Find words
		System.out.println("\n4. Find words in dictionary.\n");
		d.searchWord("apple");
		d.searchWord("hats");
		d.searchWord("mountain");
		d.searchWord("zebra");
		
		//Remove words
		System.out.println("\n5. Remove words from dictionary.\n");
		d.removeWord("apple");
		d.removeWord("zebra");
		d.removeWord("banana");
		d.removeWord("potato");
		
		//Print dictionary
		System.out.println("\n6. Print the dictionary.\n");
		find = d.first;
		while(find != null){
			System.out.println(find.elem);
			find = find.next;
		}
		
		//Print variations of a word
		System.out.println("\n7. Print variations of 'hat'.");
		d.printVariations("hat");
	}
}