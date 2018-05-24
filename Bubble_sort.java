package algorithm;

// Time complexity is O(n^2)
public class Bubble_sort {
	public static void main(String[] args) {
		int[] array = new int[] {31, 41, 59, 26, 41, 58};
		Bubble_sort algorithm = new Bubble_sort();
		algorithm.bubble_sort(array);
		
		// Print result
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	void bubble_sort(int[] a) {
		for(int i = 0; i < a.length; i ++)
			for(int j = i + 1; j < a.length; j ++) {
				if(a[j] < a[i]) {
					int temp = a[i];
					a[i]= a[j];
					a[j] = temp;
				}
			}
	}
}
