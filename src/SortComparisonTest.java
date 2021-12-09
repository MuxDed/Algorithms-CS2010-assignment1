import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//
//Insert 					insert	| Quick  | MergeI| MergeR|Selection | 
//							
//10 Random					5994	|532804  |23626	 | 23615 | 8815     | 7052
//
//100 Random			    197818	|868144  |119890 | 118558| 239780   | 176662
//
//1000 Random				5768819	|2226073 |797621 | 797629| 4275132  | 3575537
//
//1000 few unique			4680994 |1755681 |1008133|1005334| 7380632  | 5632355
//
//1000 nearly ordered       4566041 |2346315 |918920 | 903346| 7293888  | 5596389
//
//1000 reverse order		12870177|2381577 |855097 | 845092| 6612632  | 5709578
//
//1000 ascending order		5029380 |3244079 |811543 | 803485| 7359123  | 3135485
//
//-------------------------------------------------------------------------

@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] orig = new double[0];
		double[] testEmptyArr = orig.clone();
		SortComparison.quickSort(testEmptyArr);
		assertTrue(Arrays.equals(orig, testEmptyArr));
		SortComparison.insertionSort(testEmptyArr);
		assertTrue(Arrays.equals(orig, testEmptyArr));
		SortComparison.mergeSortIterative(testEmptyArr);
		assertTrue(Arrays.equals(orig, testEmptyArr));
		SortComparison.mergeSortRecursive(testEmptyArr);
		assertTrue(Arrays.equals(orig, testEmptyArr));
		SortComparison.selectionSort(testEmptyArr);
		assertTrue(Arrays.equals(orig, testEmptyArr));
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    @Test
	public void testInsertionSort() {
		// test usual
		double[] preSortedArr = { 1, 2, 3, 4, 5 };
		double[] array = { 3, 4, 5, 2, 1 };
		double[] sortedArr = SortComparison.insertionSort(array);
		for (int i = 0; i < array.length - 1; i++) {
			assertEquals(preSortedArr[i], sortedArr[i], 0);
		}
	}
    
    @Test
	public void testQuickSort() {

		// test three
		double[] expect = new double[] { 1, 2, 2 };
		double[] testThreeArr = new double[] { 2, 1, 2 };
		SortComparison.quickSort(testThreeArr);
		assertTrue(Arrays.equals(expect, testThreeArr));

		// Test usual

		double[] preSortedArr = { 1, 2, 3, 4, 5 };
		double[] array = { 3, 4, 5, 2, 1 };
		SortComparison.quickSort(array);
		assertTrue(Arrays.equals(preSortedArr, array));

	}	
    
    @Test
	public void testSelectionSort() {
		double[] preSortedArray = { 1, 2, 3 };
		double[] a = { 1, 3, 2 };
		a = SortComparison.selectionSort(a);
		assertTrue(Arrays.equals(a, preSortedArray));

	}
    @Test
	public void testMergeSortI() {
		double[] preSortedArray = { 1, 2, 3 };
		double[] a = { 1, 3, 2 };
		a = SortComparison.mergeSortIterative(a);
		for (int i = 0; i < a.length; i++) {
			assertEquals(preSortedArray[i], a[i], 0);
		}

	}
    @Test
   	public void testMergeSortR() {
   		double[] preSortedArray = { 1, 2, 3 };
   		double[] a = { 1, 3, 2 };
   		a = SortComparison.mergeSortRecursive(a);
   		for (int i = 0; i < a.length; i++) {
   			assertEquals(preSortedArray[i], a[i], 0);
   		}

   	}

}
