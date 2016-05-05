package part4;
public class TNode {
	String elem; //original word
	VTree vtree; //tree of variations

	TNode parent;
	TNode left;
	TNode right;

	public TNode(String e) {
		elem = e;
		Variations vary = new Variations(e); // generate variations
		vtree = vary.vtree; // assign variations to node element
	}
}