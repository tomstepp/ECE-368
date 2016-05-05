package part2;
public class Test2 {
	public static void main(String[] args) {
		System.out.println("Test for package 2.\n");

		//Create instance of variations
		Variations vary = new Variations("abc");
				
		//Print list of variations
		vary.list.consultLetter(' ');
	}
}