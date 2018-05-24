package algorithm;

// Time complexity is O(nlgn)

// Create heap
// Get and remove root for the biggest number
// adjust heap
public class Heap_sort {
	public static void main(String[] args) {
		Heap_sort algorithm = new Heap_sort();
		int[] input = {16,7,3,2,20,4,1,17,8};
		algorithm.heapSort(input);
		for(int i = 0; i < input.length; i++)
			System.out.print(input[i] + " ");
	}
	
public void heapSort(int[] a) {
		
		// Build heap
		// last non-leaf node is a.length / 2 - 1
		for(int i = a.length / 2 - 1; i >= 0; i--)
			Heapify(a, i, a.length);
		
		// Move the biggest node (node 0) to the end of the array, and adjust heap.
		int size = a.length;
		for(int i = a.length - 1; i >= 0; i--) {
			// Move current root to end.
			swap(a, 0, i);
			size --;
			Heapify(a, 0, size);
		}
	}
	
	// Maintain the heap property and build a max heap.
	//	index is the root index
	//	size is the array size
	public void Heapify(int[] a, int index, int size) {
		int left = 2 * index + 1; // left child index
		int right = 2 * index + 2; // right child index
		int max = index; // max is  the largest node index, default to be parent
		
		// check whether left child is bigger than parent.
		if(left < size && a[left] > a[max])
			max = left;
		
		// check whether right child is bigger than parent.
		if(right < size && a[right] > a[max])
			max = right;
		
		// if any child is bigger than parent,
		// swap value and recursively adjust heap.
		if(max != index) {
			swap(a, index, max);
			Heapify(a, max, size);
		}
	}
	
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
