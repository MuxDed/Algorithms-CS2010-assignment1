
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Mikhail Dyuldin
 * @version HT 2019
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		double temp = a.length;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}

	// end insertionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	public static double[] quickSort(double a[]) {
		// Base case!
		if (a.length <= 1) {
			return a;
		}

		// pick random pivot
		int pivotIndex = (int) (Math.random() * a.length);
		double pivot = a[pivotIndex];
		// get number of doubles that are less than the pivot
		int lessThanCount = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < pivot)
				lessThanCount++;
		}

		// count up the number of elements that are greater than the pivot
		int greaterThanCount = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > pivot)
				greaterThanCount++;
		}

		// numbers < pivot get put into a new array
		double[] lesser = new double[lessThanCount];
		int indexToPut = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < pivot) {
				lesser[indexToPut] = a[i];
				indexToPut++;
			}
		}

		// numbers > pivot get put in a new array
		double[] greater = new double[greaterThanCount];
		indexToPut = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > pivot) {
				greater[indexToPut] = a[i];
				indexToPut++;
			}
		}

		// quicksort the new arrays using recursion
		quickSort(lesser);
		quickSort(greater);

		// prepare arrays for printing
		int i;
		for (i = 0; i < lesser.length; i++) {
			a[i] = lesser[i];
		}
		int j = greater.length - 1;
		int k;
		for (k = a.length - 1; j >= 0; k--) {
			a[k] = greater[j];
			j--;
		}

		// put in pivot @ appropriate location
		for (int h = i; h <= k; h++) {
			a[h] = pivot;
		}
		return a;

	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {

		int width;
		double[] tmp = new double[a.length];
		for (width = 1; width < a.length; width = 2 * width) {
			// Combine sections of array a of width "width"
			int i;

			for (i = 0; i < a.length; i = i + 2 * width) {
				int left, middle, right;

				left = i;
				middle = i + width;
				right = i + 2 * width;

				merge1(a, left, middle, right, tmp);

			}
			for (i = 0; i < a.length; i++)
				a[i] = tmp[i];
		}
		return a;

	}

	public static void merge1(double[] a, int iLeft, int iMiddle, int iRight, double[] tmp) {
		int i, j, k;

		i = iLeft;
		j = iMiddle;
		k = iLeft;

		while (i < iMiddle || j < iRight) {
			if (i < iMiddle && j < iRight) { // Both array have elements
				if (a[i] < a[j])
					tmp[k++] = a[i++];
				else
					tmp[k++] = a[j++];
			} else if (i == iMiddle)
				tmp[k++] = a[j++]; // a is empty
			else if (j == iRight)
				tmp[k++] = a[i++]; // b is empty
		}

	}// end mergesortIterative

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) { // used notes for this
		int length = a.length;
		if (length <= 1) {
			return a;
		}
		double[] temp1 = new double[length / 2];
		double[] temp2 = new double[length - (length / 2)];
		for (int i = 0; i < temp1.length; i++)
			temp1[i] = a[i];
		for (int i = 0; i < temp2.length; i++)
			temp2[i] = a[i + length / 2];
		return merge(mergeSortRecursive(temp1), mergeSortRecursive(temp2));
	}// end mergesort

	static double[] merge(double[] temp1, double[] temp2) {
		double[] merged = new double[temp1.length + temp2.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < merged.length; k++) {
			if (i >= temp1.length) {
				merged[k] = temp2[j++];
			} else if (j >= temp2.length) {
				merged[k] = temp1[i++];
			} else if (temp1[i] <= temp2[j]) {
				merged[k] = temp1[i++];
			} else {
				merged[k] = temp2[j++];
			}
		}
		return merged;
	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {
		int first;
		double tmp;
		int count = 1;
		for (int i = a.length - 1; i > 0; i--, count++) {
			first = 0;
			for (int j = 1; j <= i; j++) {
				if (a[j] > a[first])
					first = j;
			}
			tmp = a[first];
			a[first] = a[i];
			a[i] = tmp;

		}
		return a;
	}

	public static void main(String[] args) {
		double a[] = new double[1000];

		double[] tmp = new double[a.length];
		int count = 0;
		String fileName = "numbers10.txt";
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				double number = Double.parseDouble(line);
				a[count] = number;
				System.out.println(a[count]);
				System.out.println(number);
				count++;
			}
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

}
