package part3;
import part1.WordList;
public class DNode {
	
	public String elem;
	public WordList list;
	public DNode next;
	
	public DNode(String w){
		elem = w;
		list = null;	
		next = null;
	}
}