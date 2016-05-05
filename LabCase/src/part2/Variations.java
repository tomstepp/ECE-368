package part2;
import part1.WordList;
public class Variations {
	//Attributes
	public WordList list = new WordList(); //list to store words
	String word;
	
	//Constructor
	public Variations(String w){
		word = w;
		variation();  //call method to generate words
		System.out.println("Variations were generated successfully!");
	}
	
	//Methods
	public void variation(){
		int length = word.length();
		int i,j;
		String x;
		
		//UPDATE - change one letter of word at a time
		//Iterate through each letter
		for(i=0 ; i<length; i++){ 
			//Iterate through the alphabet
			for (j=0 ; j<26 ; j++){ 
				//create new word
				//substring(int beginIndex)
				//substring(int beginIndex, int endIndex)
				//beginIndex is inclusive
				//endIndex is exclusive
				//word.substring(0,0) = '' (aka nothing)
				//word.substring(0,length) = word
				x = word.substring(0,i) + (char)(j+'a') + word.substring(i+1);
				list.insertWord(x); // add word to dictionary (insertWord wont add duplicates)
			}
		}
		
		//REMOVE - remove one letter from the word
		//Iterate through word
		for(i=0 ; i<length; i++){
			x = word.substring(0,i) + word.substring(i+1);
			list.insertWord(x);			
		}
		
		//INSERT - add each letter of alphabet before, in between, and after
		
		//Before word
		for (j=0 ; j<26 ; j++){ 
			x = (char)(j+'a') + word.substring(0);
			list.insertWord(x);
		}
		
		//Middle of word
		for(i=0 ; i<length-1; i++){ 
			for (j=0 ; j<26 ; j++){ 
				x = word.substring(0,i+1) + (char)(j+'a') + word.substring(i+1);
				list.insertWord(x);
			}
		}		
		
		//After word
		for (j=0 ; j<26 ; j++){ 
			x = word.substring(0,length) + (char)(j+'a');
			list.insertWord(x);
		}
	}
}