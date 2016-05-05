package part4;
public class Variations {
	//Attributes
	public VTree vtree = new VTree();
	String word;
	
	//Constructor
	public Variations(String w){
		word = w;
		variation();
	}
	
	//Methods
	public void variation(){
		int length = word.length();
		int i,j;
		String x;
		
		for(i=0 ; i<length; i++){ 
			for (j=0 ; j<26 ; j++){ 
				x = word.substring(0,i) + (char)(j+'a') + word.substring(i+1);
				vtree.insertVWord(x);
			}
		}
		
		//REMOVE
		for(i=0 ; i<length; i++){
			x = word.substring(0,i) + word.substring(i+1);
			vtree.insertVWord(x);	
		}
		
		//INSERT
		//Before word
		for (j=0 ; j<26 ; j++){ 
			x = (char)(j+'a') + word.substring(0);
			vtree.insertVWord(x);
		}
		//Middle of word
		for(i=0 ; i<length; i++){ 
			for (j=0 ; j<26 ; j++){ 
				x = word.substring(0,i+1) + (char)(j+'a') + word.substring(i+1);
				vtree.insertVWord(x);
			}
		}		
		//After word
		for (j=0 ; j<26 ; j++){ 
			x = word.substring(0,length) + (char)(j+'a');
			vtree.insertVWord(x);
		}
	}
}