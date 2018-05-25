package algorithm;

import java.util.Arrays;

// In each bucket, another sort algorithm is need to sort inside the bucket.
// Time Complexity O(n)
public class Bucket_sort {
	public static void main(String[] args) {
		//let's say: put 10 numbers into the bucket, positive number range 10 - 100;
		int[] a = {57,68,59,52,72,28,96,33,24,19};
		Bucket_sort algorithm = new Bucket_sort();
		algorithm.bucket_sort(a);
		// Print result
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public void bucket_sort(int[] a) {
		int[][] buckets = new int[10][10];
		
		// Empty initial buckets, in Java, default empty integer array is filled with 0.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < buckets[0].length; j++) {
				buckets[i][j] = 0;
			}
		}
		
		// Put the number inside bucket
		int in_bucket_index;
		for(int i = 0; i < a.length; i ++) {
			in_bucket_index = 0;
			while(buckets[a[i] / 10][in_bucket_index] != 0)
				in_bucket_index ++;
			buckets[a[i] / 10][in_bucket_index] = a[i];
		}
		
		// sort inside each bucket, java Arrays.sort use quick sort for int type and merge sort for object
		for(int i = 0; i < 10; i ++)
			Arrays.sort(buckets[i]);
		
		// Convert table to one  dimension array, not, we say range from 10 - 100
		int index = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(buckets[i][j] != 0) {
					a[index ++ ] = buckets[i][j];
				}
			}
		}
	}
}
