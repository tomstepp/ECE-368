package sack;

public class Knapsack {
	//Is an optimization problem: Given a set of items, each with a weight and a value, determine the items 
	//to include in a collection so that the total weight is less than or equal to a given limit and the total value is 
	//as large as possible. This algorithm resolves the one-dimensional problem, ie. for each item decide include or not.
	
	int n; //number of different items
	int totalWeight; 
	Item[] items;
	int[] currentSolution,bestSolution;
			
	public 	Knapsack(int num,int max,Item[] obj) {
		n=num;
		totalWeight=max;		
		items=obj;		
		currentSolution=new int[n];
		bestSolution=new int[n];
		for (int i=0;i<n;i++) { 
			currentSolution[i]=-1;
			bestSolution[i]=-1;
		}
		KnapsackRec (currentSolution,0);
	}
		
		
	public void KnapsackRec (int[] solution, int step){
		if (step>n-1) return;   //step=deep
		for (int i=0;solution[step]<=1;i++) {
			System.out.println("Step " + step);
			solution[step]=i;
			if (isCorrect(solution)) {
				System.out.println("It's OK, but is it complete?");
				if (step==n-1)  {
					System.out.println("It's complete but is it better?");
					if (isBetter(solution)) {
						System.out.println("It's better");
						System.arraycopy(solution,0,bestSolution,0,solution.length);
					}
				}
				else {
					System.out.println("Recursive call " + step);
					KnapsackRec (solution,step+1);
					}
			}
		}
		solution[step]=-1;
	}
		
	public boolean isCorrect (int[] solution) {
		int total=0;
		for (int i=0;i<solution.length;i++) {
			if (solution[i]==1) total=total+solution[i]*items[i].weight;			
		}
		return (total<=totalWeight);
	}
	
	public boolean isBetter(int[] solution) {
		int current=0;
		for (int i=0;i<solution.length;i++)
			if (bestSolution[i]==1) current=current+bestSolution[i]*items[i].value;
				
		int total=0;
		for (int i=0;i<solution.length;i++)
			if (solution[i]==1) total=total+solution[i]*items[i].value;
		return (total>current);
	}
	
	public static void main(String[] args) {
		int n=5;
		int max=15;
		Item[] items=new Item[n];
		Item it=new Item (4,12); // $4 and 12Kg
		items[0]=it;
		it=new Item (2,2); 
		items[1]=it;
		it=new Item (1,1); 
		items[2]=it;
		it=new Item (2,1); 
		items[3]=it;
		it=new Item (10,4); 
		items[4]=it;						
		
		Knapsack problem=new Knapsack(n,max,items);
		System.out.println("\nBest solution: ");
		int total=0;
		int profit=0;
		for (int i=0; i<n;i++) {
			if (problem.bestSolution[i]==1) {
				System.out.println("   Item "+i+":" + problem.items[i].value + "$ " +problem.items[i].weight + "Kg "   );
				total=total+ problem.items[i].weight;
				profit = profit + problem.items[i].value;
			}
			else System.out.println("   No item "+i+":" + problem.items[i].value + "$ " +problem.items[i].weight + "Kg "   );
		}
		System.out.println("\nTotal weight: "+total +"Kg");
		System.out.println("Total profit: "+profit + "$");		
	}
}