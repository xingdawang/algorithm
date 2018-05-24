package algorithm;

// Insertion sort time complexity O(n^2).
public class Insertion_sort {
	
	public static void main(String[] args) {
		
		int[] array = new int[] {31, 41, 59, 26, 41, 58};
		Insertion_sort algorithm = new Insertion_sort();
		algorithm.insertion_sort_increase(array);
		// algorithm.insertion_sort_decrease(array);
		
		// Print result
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	void insertion_sort_increase(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int j = i - 1;
			int temp = array[i];
			
			// Moving each item one slot forward.
			while(j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j --;
			}
			
			// Put the smallest number at the first slot in the increasing sequence.
			array[j + 1] = temp;
		}
	}
	
	void insertion_sort_decrease(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int index = i - 1;
			int temp = array[i];
			
			// Moving each item one slot forward.
			while(index >= 0 && temp > array[index]) {
				array[index + 1] = array[index];
				index --;
			}
			
			// Put the largest number at the first slot in the decreasing sequence.
			array[index + 1] = temp;
		}
	}
}
