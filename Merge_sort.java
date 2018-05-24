package algorithm;

// Divide and conquer
// Merge sort time complexity is O(nlgn).
public class Merge_sort {
	
	public static void main(String[] args) {
		int[] array = new int[] {8, 5, 2, 8, 6, 4, 3, 1, 7};
		Merge_sort algorithm = new Merge_sort();
		algorithm.merge_sort(array, 0, array.length);
		// algorithm.merge_sort(array, array.length);
		
		// Print result.
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	// Top down merge sort
	void merge_sort(int[] a, int start, int end) {
		if(start + 1< end) {
			int middle = (start + end) / 2;
			merge_sort(a, start, middle);
			merge_sort(a, middle, end);
			merge(a, middle, start, end);
		}
	}
	
	// Bottom up merge sort, scale 1, 2, 4, 8 etc.
	void merge_sort(int[] a, int size) {
		int length = 1;
		while(length < size) {
			int i;
			for(i = 0; i + 2 * length < size; i += 2 * length) // Merge scale 1, 2, 4, 8
				merge(a, i + length, i, i + 2 * length);
			if(i + length < size) // If it is not full, merge itself.
				merge(a, i + length, i, size);
			length *= 2;
		}
	}
	
	// Merge 2 granular array.
	void merge(int[] a, int middle, int start, int end) {
		int[] sequence = new int[end - start];
		int i = start;
		int j = middle;
		int index = 0;
		
		// first part & second part all have values.
		while(i < middle && j < end) {
			sequence[index++] = a[i] < a[j] ? a[i++]: a[j++];  
		}
		
		// first part contains no value.
		while(j < end) {
			sequence[index++] = a[j++];
		}
		
		// second part contains no value.
		while(i < middle) {
			sequence[index++] = a[i++];
		}
		
		// Assign back the sorted values
		index = 0;
		for(i = start; i < end; i ++ ) {
			a[i] = sequence[index++];
		}
	}
}
