package part4;
public class Test4 {
	public static void main(String[] args) {
		System.out.println("Test for package 4.\n");
		
		//Create Tree
		Tree t = new Tree();
		
		//Insert Words
		t.insertWord("mail");
		t.insertWord("great");
		t.insertWord("tea");
		t.insertWord("apple");
		t.insertWord("hello");
		t.insertWord("summer");
		t.insertWord("uniform");
		
		//---Tree diagram---------------------------------------------
		//							mail
		//				great					tea
		//		  apple		  hello		  summer	uniform
		//------------------------------------------------------------
		
		//Print dictionary
		System.out.println("-----Dictionary tree-----");
		t.print();
		
		//Find variations
		System.out.println("");
		System.out.println("-----Find 'tea' (print variations)-----");
		t.searchWord("tea");
			
		//delete words
		System.out.println();
		t.removeWord("apple"); 		//Case 1: leaf
		t.print();
		System.out.println();
		
		t.removeWord("great"); 		//Case 2: one child
		t.print();
		System.out.println();
		
		t.removeWord("tea"); 		//Case 3: two children
		t.print();
		System.out.println();
		
		t.removeWord("mail"); 		//Case 4: root
		t.print();
		System.out.println();
		
		//remove rest of tree
		t.removeWord("summer");
		t.removeWord("hello");
		t.removeWord("uniform");
		
		//Print dictionary
		System.out.println("\n-----Dictionary tree-----");
		t.print();
	}
}