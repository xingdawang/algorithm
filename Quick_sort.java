package algorithm;

// Divide and Conquer
// Average time complexity O(nlgn), worst-case O(n^2)
public class Quick_sort {
	
	public static void main(String[] args) {
		Quick_sort algorithm = new Quick_sort();
		int[] input = {16,7,3,2,20,4,1,1,17,8};
		algorithm.quickSort(input, 0, input.length - 1);
		for(int i = 0; i < input.length; i++)
			System.out.print(input[i] + " ");
	}

	public void quickSort(int[] a, int left, int right) {
		if(left < right) {
			// select first element to be the pivot
			int pivot = a[left];
			int first = left;
			int last = right;
			while(first < last) {
				// from right to left, loop to find a index which all right sequence is bigger than pivot.
				while(first < last && a[last] > pivot)
					last --;
				// place this value to left
				a[first] = a[last];
				// from left to right, loop to find a index which all left sequence is smaller than pivot.
				while(first < last && a[first] <= pivot)
					first ++;
				// place this value to right.
				a[last] = a[first];
			}
			// put the pivot in the middle, so that all left is smaller than pivot, and all right is bigger than pivot.
			a[first] = pivot;
			quickSort(a, left, first - 1);
			quickSort(a, first + 1, right);
		}
	}
}
