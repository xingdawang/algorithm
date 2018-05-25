package algorithm;

// Raidx sort is NOT based on comparison
// Radix sort is a table.
// Time Complexity is O(n)
public class Radix_sort {
	public static void main(String[] args) {
		String[] a = {"COW", "DOG", "BIX", "SEA", "RUG", "ROW", "MOB", 
				"BOX", "BIG", "TAB", "BAR", "EAR", "TAR","DIG", "TAA",
				"TEA", "NOW", "FOX"};
		Radix_sort algorithm = new Radix_sort();
		algorithm.radix_sort(a);
	}
	
	public void radix_sort(String[] a) {
		// From right most to let most.
		for(int i = a[0].length() - 1; i >= 0 ; i--)
			sort_column(a, i);
		// Print table
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void sort_column(String[] a, int radix) {
		// Convert the original array into a 2D array list,
		// row used to store words begin with same letter, e.g. "RUG, ROW", let's say size 20
		// column marks the A-Z 26 letters. i.e.:
		/**
		 *  1|   |   |...
		 *  2|BOR|BAR|...
		 *  3|COW|   |...
		 */
		String[][] radix_matrix = new String[26][20]; // table
		// Initialize table to be ""
		for (int i = 0; i < radix_matrix.length; i++) {
			for (int j = 0; j < 20; j++) {
				radix_matrix[i][j] = "";
			}
		}
		
		// For each word, put it into the table. 
		for(int i = 0; i < a.length; i ++) {
			int row_index = 0;
			// find available row_index position
			String target_sort_letter = a[i].substring(radix, radix + 1);
			int number = (int) target_sort_letter.charAt(0) - 65;
			while(row_index < 20) {
				if(radix_matrix[number][row_index] == "") {
					radix_matrix[number][row_index] = a[i];
					break;
				}
				else
					row_index++;
			}
		}
		
		// Put 2D array back original array.
		int index = 0;
		for (int i1 = 0; i1 < 26; i1++) {
			for (int j = 0; j < 20; j++) {
				if(radix_matrix[i1][j] != "")
					a[index ++ ] = radix_matrix[i1][j];
			}
		}
	}
}
