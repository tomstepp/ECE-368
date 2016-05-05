package part4;
public class Tree implements iTree{
	//Attributes
	TNode root;
	
	//Constructor
	public Tree(){
		root = null;
	}
	
	//Methods
	//Insert a word into the dictionary tree
	public void insertWord(String p){
		TNode newNode = new TNode(p);
		if (root == null){
			root = newNode;
			System.out.println("Word was successfully inserted.");
			return;
		}
		TNode search = root;
		
		while(search != null){
			if (search.elem.compareTo(newNode.elem) == 0){
				System.out.println("The word is already in the dictionary");
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
					System.out.println("Word was successfully inserted.");
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
					System.out.println("Word was successfully inserted.");
					return;
				}
			}
		}
		//return;
	}
	
	//Remove word
	public void removeWord(String p){
		//make sure there is a root
		if (root == null){
			System.out.println("Cannot remove: " + p + " - tree is empty.");
			return;
		}
		//if the element is found, remove it
		if (root.elem.compareTo(p) == 0) {
			if (root.left==null && root.right==null) {
				root=null; //remove root
			}
			else if (root.left==null || root.left==null)  {
				if (root.left==null) {
					root=root.right;
				}
				if (root.right==null) {
					root=root.left;
				}
				root.parent=null;
			} 
			else {
				removeWord(p,root);
			}
		}
		else {
			removeWord(p,root);
		}
		System.out.println(p + " was successfully removed.\n");
		return;
	}
	
	public void removeWord(String p, TNode node){
		//Check null
		if (node == null) {
			System.out.println("Cannot remove: " + p + " from the dictionary.");
			return;
		}
		 
		//Go Left
		if (node.elem.compareTo(p) > 0 ) { // node.elem - p = value
			removeWord(p,node.left);
			return;
		}
		
		//Go Right
		if (node.elem.compareTo(p) < 0 ) { // node.elem - p = value
			removeWord(p,node.right);
			return;
		}
		
		//First case: the node is a leaf.
		if (node.left==null && node.right==null) {
			TNode parent=node.parent;
					
			//we must break the references between the node and its parent. 
			//We have to find out if node is the left 
			//or right child of its parent.
			if (parent.left==node) {
				parent.left=null;
			}
			else {
				parent.right=null; 
			}
			return;
		}

		//Second case: the node only has one child
		else if (node.left==null || node.right==null){
			//its only child is its right child
			TNode grandChild=null;
			if (node.left==null) {
				grandChild=node.right;
			}
			else {
				grandChild=node.left;
			}
			
			TNode grandParent=node.parent;
			
			if (grandParent.left==node) {
				grandParent.left=grandChild;
			}
			else {
				grandParent.right=grandChild;
			}
			//the grand child must point its grand parent.
			grandChild.parent=grandParent;
			return;
		}
	
		//Third case: node has two children.
		//We can replace its value by 
		//the minimum value from its right child
		else{
			TNode successorNode = findMin(node.right);
			
			//reassign elem and tree to node you are 'removing'
			node.elem=successorNode.elem;
			node.vtree = successorNode.vtree;
		
			//Finally, we must remove the succesorNode
			removeWord(successorNode.elem,node.right);
			return;
		}
		
	}	
	
	//Find the min node (used for the remove function)
	private TNode findMin(TNode node) {
		if (node==null) {
			return null;
		}
		TNode minNode=node;
		while (minNode.left!=null) {
			minNode=minNode.left;
		}
		return minNode;
	}
	
	//Find a word, and print the variations
	public void searchWord(String p){
		searchWord(root, p);
		return;
	}
	
	public void searchWord(TNode findNode, String word){
		if (findNode == null){
			System.out.println("Cannot find: " + word + " in the dicitonary.");
			return;
		}
		String visitWord = findNode.elem;
		if(visitWord == word){
			findNode.vtree.vprint(); // Found it -> print all variations
		}
		else if (findNode.elem.compareTo(word) > 0){
			searchWord(findNode.left,word);
		}
		else{
			searchWord(findNode.right, word);
		}
		return;
	}
	
	//Print the dictionary tree
	public void print(){
		TNode print = root;
		if (root==null){
			System.out.println("The tree is empty!");
			return;
		}
		InOrder(print);
	}
	
	//Print the tree in order (alphabetically)
	private void InOrder(TNode print){
		if (print == null){return;}
		InOrder(print.left);
		System.out.println(print.elem);
		InOrder(print.right);
	}
}