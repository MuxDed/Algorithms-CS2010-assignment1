
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.*;

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
		double value;
		int hole;

		for (int i = 1; i < a.length; i++) {
			value = a[i];
			hole = i;

			while (hole > 0 && a[hole - 1] > value) {
				a[hole] = a[hole - 1];
				hole--;
			}

			a[hole] = value;
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
	static double[] quickSort(double a[]) {

		// todo: implement the sort

	}// end quicksort

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

		// todo: implement the sort

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
	static double[] mergeSortRecursive(double a[]) {

		// todo: implement the sort

	}// end mergeSortRecursive

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

		// todo: implement the sort

	}// end selectionsort

	public static void main(String[] args) {
		double a[] = new double[1000];
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
		} catch (FileNotFoundException ex) 
		{
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) 
		{
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

}
