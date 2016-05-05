package mergesort;
public class SortMerge {
	public static int[] mergesort(int vector[]){
		// End condition
		if (vector.length <= 1){
			return vector;
		}
		
		// Step 1: Divide the set into two parts.
		int mid = vector.length / 2;
		int lower[] = new int[mid];
		for (int i = 0 ; i<lower.length ; i++){
			lower[i] = vector[i];
		}
		int upper[] = new int[vector.length - mid];;
		for (int i = 0 ; i<upper.length ; i++){
			upper[i] = vector[mid+i];
		}
		
		// Step 2: Recursively sort each part.
		lower = mergesort(lower);
		upper = mergesort(upper);		
		
		// Step 3: Combine the sorted parts.
		int i=0, j=0, k=0;
		while(lower.length!=j && upper.length!=k){
			if(lower[j]<upper[k]){
				vector[i++] = lower[j++];
			} else{
				vector[i++] = upper[k++];
			}
		}
		while(lower.length != j){
			vector[i++] = lower[j++];
		}
		while(upper.length != k){
			vector[i++] = upper[k++];
		}
		return vector;
	}
	
	public static void main(String[] args) {
		int[] vector = {1,2,1,2,4,3,0,5,10,999,-666};
		//Print initial
		System.out.print("\nOriginal vector: ");
		for (int i=0 ; i<vector.length ; i++){
			System.out.print(vector[i] + " ");
		}
		System.out.println("");
		//Quick sort!
		int[] result = mergesort(vector);
		
		//Print sorted
		System.out.print("\nSorted vector  : ");
		for (int i=0 ; i<result.length ; i++){
			System.out.print(result[i] + " ");
		}	
	}
}
