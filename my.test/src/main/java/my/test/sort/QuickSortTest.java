package my.test.sort;

import java.util.Arrays;

public class QuickSortTest {
	public static void main(String[] args) {
		long[] array = new long[] { 5, 6, 7, 1, 2, 3, 3 };
		quickSort(array);
	}

	private static void quickSort(long[] array) {
		int start = 0;
		int finish = array.length - 1;
		sort(array, start, finish);
	}

	private static void sort(long[] array, int start, int finish) {
		
		if (start < finish) {
			
			System.out.println(String.format("sort(%s, %s, %s)", print(array), start, finish));
			
			int partition = partition(array, start, finish);
			sort(array, start, partition - 1);
			sort(array, partition + 1, finish);
		}
	}

	private static int partition(long[] array, int start, int finish) {
		
		long lastValue = array[finish];
		int newPartition = start;
		
		for (int j = start; j < finish; j++) {

			if (array[j] < lastValue) {
				
				long swapTemp = array[newPartition];
				array[newPartition] = array[j];
				array[j] = swapTemp;
				newPartition++;
			}
		}

		long swapTemp = array[newPartition];
		array[newPartition] = array[finish];
		array[finish] = swapTemp;
		//System.out.println(String.format("After partition: %s; return %s", print(array), array[pivotIndex]));
		return newPartition;
	}

	private static String print(long[] array) {
		return Arrays.toString(array);
	}
}
