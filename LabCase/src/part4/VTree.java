package part4;
public class VTree {
	//Attributes
	VTNode root;
	
	//Constructor
	public VTree(){
		root = null;
	}
	
	public void insertVWord(String p){
		VTNode newNode = new VTNode(p);
		
		if (root == null){
			root = newNode;
			return;
		}
		VTNode search = root;
		
		while(search != null){
			if (search.elem.compareTo(newNode.elem) == 0){
				//System.out.println("The word is already in the dictionary");
				return;
			}
			
			//If the word is later in the alphabet, then advance right
			else if(search.elem.compareTo(newNode.elem) < 0 ){
				//Continue to advance until we are at a null branch
				if (search.right != null){
					search = search.right;
				}
				//Otherwise, add the newNode as the right child
				else{
					newNode.parent = search;
					search.right = newNode;
					return;
				}
			} 
			//If the word is earlier in the alphabet, then advance left
			else{
				//Continue to advance until we are at a null branch
				if (search.left != null){
					search = search.left;
				}
				//Otherwise, add the newNode as the left child
				else{
					newNode.parent = search;
					search.left = newNode;
					return;
				}
			}
		}
		return;
	}
	public void vprint(){
		VTNode print = root;
		if (root==null){
			return;
		}
		VInOrder(print);
	}
	private void VInOrder(VTNode print){
		if (print == null){
			return;
		}
		VInOrder(print.left);
		System.out.println(print.elem);
		VInOrder(print.right);
	}
}