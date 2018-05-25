package algorithm;
// Counting sort is NOT based on comparison.
// Counting sort can only deal with positive integer (as use array index)
// Time Complexity is O(n)

public class Counting_sort {

	public static void main(String[] args) {
		Counting_sort algorithm = new Counting_sort();
		int[] a = {5,8,2,1,1,3,1,4,6,9,7};
		algorithm.counting_sort(a, 9); // 9 is the max number in a
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " " );
	}
	
	public void counting_sort(int[] a, int max_number) {
		
		// Create an auxiliary array to store value based on index number.
		int[] auxiliary = new int[max_number + 1];
		
		// Initial auxiliary array to be 0
		for (int i = 0; i < auxiliary.length; i++)
			auxiliary[i] = 0;

		// count the occurrence number, and add it to the according position in auxiliary array.
		for(int i = 0; i < a.length; i++)
			auxiliary[a[i]] ++;

		// organize number back to original array.
		int a_array_index = 0;
		for(int i = 0; i < auxiliary.length; i++) {
			while(auxiliary[i] > 0) {
				a[a_array_index ++] = i;
				auxiliary[i] --;
			}
		}
	}
}