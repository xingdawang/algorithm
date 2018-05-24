package algorithm;

// Divide and Conquer
public class Maximum_subarray {
	
	public static void main(String[] args) {
		int[] array = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		Maximum_subarray algorithm = new Maximum_subarray();
		int result = algorithm.maximum_subarray(array, 0, array.length - 1);
		System.out.println(result);
	}
	
	int maximum_subarray(int[] a, int left, int right) {
		
		// Base case
		if(left == right) {
			// Make sure the minimum value is 0;
			return a[left] > 0 ? a[left] : 0;
		}
		
		int center = (left + right) / 2;
		int maxLeftSum = maximum_subarray(a, left, center); // Recursively find the left subarray maximum value.
		int maxRightSum = maximum_subarray(a, center + 1, right); // Recursively find the right subarray maximum value.
		
		int leftBorderSum = 0, maxLeftBorderSum = 0; // Define left border sequence sum value.
		for(int i = center; i >= left; i--) { // Find max sum value on left sub array (from right to left)
			leftBorderSum += a[i];
			if(leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}
		
		int rightBorderSum = 0, maxRightBorderSum = 0; // Define right border sequence sum value.
		for(int i = center + 1; i <= right; i++) { // Find max sum value on the right sub array (from left to right)
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}
		
		// Choose and return the max value from left border, right border and cross border
		int max = Math.max(maxLeftSum, maxRightSum);
		max = Math.max(max, (maxLeftBorderSum + maxRightBorderSum));
		return max;
	}
}
