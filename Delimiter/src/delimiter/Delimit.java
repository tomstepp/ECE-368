package delimiter;
import java.util.Scanner;

public class Delimit {

	public static void main(String[] args) {
		Scanner input;
		String in;
		
		input = new Scanner(System.in);
		System.out.println("Enter an expression: ");
		in = input.nextLine();
		input.close();
		System.out.println("Checking for balance...");
		
		SStack check = new SStack();
		
		int i = 0;
		//for (i=0;i<in.length();i++){
		while (i<in.length()){	
			//check if opener
			//add to queue
			if (in.charAt(i) == '('){
				check.push(in.charAt(i));
				//System.out.println(in.charAt(i) + " pushed to stack.");
			}
			if (in.charAt(i) == '['){
				check.push(in.charAt(i));
				//System.out.println(in.charAt(i) + " pushed to stack.");
			}
			if (in.charAt(i) == '{'){
				check.push(in.charAt(i));
				//System.out.println(in.charAt(i) + " pushed to stack.");
			}
			
			//check if closer
			//check for match
			if (in.charAt(i) == ']' && !check.isEmpty()){
				if (check.top() == '['){
					check.pop();
					//System.out.println("Match - item popped from stack.");
				}else{
					//System.out.println("Unbalanced!");
					break;}
			}
			if (in.charAt(i) == ')' && !check.isEmpty()){
				if (check.top() == '('){
					check.pop();
					//System.out.println("Match - item popped from stack.");
				}else{
					//System.out.println("Unbalanced!");
					break;}
			}
			if (in.charAt(i) == '}' && !check.isEmpty()){
				if (check.top() == '{'){
					check.pop();
					//System.out.println("Match - item popped from stack.");
				} else{
					//System.out.println("Unbalanced!");
					break;}
			}

			i++;
		}
		
		if (check.isEmpty() == false){
			System.out.println("Expression is not well-balanced.");
		} else if (i < in.length()){
			System.out.println("Expression is not well-balanced.");
		} else {
			System.out.println("Expression is well-balanced.");
		}
		
	}

}
