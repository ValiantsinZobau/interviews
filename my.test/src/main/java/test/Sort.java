package test;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		long[] values = new long[] { 7, 6, 4, 6, 3, 2, 1, 9, 5 };
		print(values);
		quickSort(values);
		print(values);
	}

	private static void quickSort(long[] values) {
		int startIndex = 0;
		int finishIndex = values.length - 1;
		sort(values, startIndex, finishIndex);
	}

	private static void sort(long[] values, int startIndex, int finishIndex) {
		if (startIndex < finishIndex) {
			int partitionIndex = partition(values, startIndex, finishIndex);
			sort(values, startIndex, partitionIndex - 1);
			sort(values, partitionIndex + 1, finishIndex);
		}
	}

	private static int partition(long[] values, int startIndex, int finishIndex) {
		int newPartitionIndex = startIndex;
		long pivotValue = values[finishIndex];

		for (int i = startIndex; i < finishIndex; i++) {

			if (values[i] < pivotValue) {
				long temp = values[newPartitionIndex];
				values[newPartitionIndex] = values[i];
				values[i] = temp;
				newPartitionIndex++;
			}
		}

		long temp = values[newPartitionIndex];
		values[newPartitionIndex] = values[finishIndex];
		values[finishIndex] = temp;

		return newPartitionIndex;
	}

	private static void print(long[] values) {
		System.out.println(Arrays.toString(values));
	}
}
