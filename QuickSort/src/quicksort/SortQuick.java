package quicksort;
public class SortQuick {
	public static void quicksort(int vector[],int left, int right){
		// Step 1: select the pivot.
		int pivot = vector[left];
		int i = left;
		int j = right;
		int temp;
		
		// Step 2: search process + interchange.
		while(i<j){
			while (vector[i] <= pivot && i<j){ i++;}
			while (vector[j] > pivot){ j--;}
			if (i<j){
				temp = vector[i];
				vector[i] = vector[j];
				vector[j] = temp;
			}
		}
		
		// Step 3: interchange pivot with 'j' element.
		vector[left] = vector[j];
		vector[j] = pivot;
		
		// Step 4: Recursively solve each side.
		if (left < i-1){
			quicksort(vector, left, j-1);
		}
		if (i+1 < right){
			quicksort(vector, j+1, right);
		}
	}
	
	public static void main(String[] args){
		//int[] vector = {9,8,7,777,45,9,12,6,5,4,3,2,1,-5};
		int[] vector = {5,7,2,1,0,12};
		//int[] vector = {9,8,7,0,4,999,-666,5,1,0,100};
		//Print initial
		System.out.print("\nOriginal vector: ");
		for (int i=0 ; i<vector.length ; i++){
			System.out.print(vector[i] + " ");
		}
		
		//Quick sort!
		quicksort(vector,0,vector.length-1);
		
		//Print sorted
		System.out.print("\nSorted vector  : ");
		for (int i=0 ; i<vector.length ; i++){
			System.out.print(vector[i] + " ");
		}
	}
}
