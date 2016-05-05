package part1;
public interface iWordList {
	
	//Insert a word into the list alphabetically
	public void insertWord(String p);
	
	//Remove a word from the list
	public void removeWord(String p);
	
	//Return the position of a word
	//Index starts at zero
	public int searchWord(String p);
	
	//Print all words that start with 'c'
	//Print entire list if c = ' '
	public void consultLetter(char c);
}