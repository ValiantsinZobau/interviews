package my.test;

import java.util.Arrays;

public class TestQuickSort {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 4, 3, 2, 5 };
		print(array);
		quickSort(array);
		print(array);
	}

	private static void print(int[] array) {
		System.out.println(Arrays.toString(array));

	}

	private static void quickSort(int[] array) {
		int start = 0;
		int finish = array.length - 1;
		sort(array, start, finish);
	}

	private static void sort(int[] array, int start, int finish) {
		if (start < finish) {
			int pivot = partition(array, start, finish);
			sort(array, start, pivot - 1);
			sort(array, pivot + 1, finish);
		}

	}

	private static int partition(int[] array, int start, int finish) {
		int pivot = array[finish];
		int newPartition = start;
		for (int j = start; j < finish; j++) {
			if (array[j] < pivot) {
				int temp = array[newPartition];
				array[newPartition] = array[j];
				array[j] = temp;
				newPartition++;
			}
		}
		int temp = array[newPartition];
		array[newPartition] = array[finish];
		array[finish] = temp;
		return newPartition;
	}
}
