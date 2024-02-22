package my.test;

import java.util.Arrays;

public class TestMergeSort {
	public static void main(String[] args) {
		int[] array = new int[] { 5, 6, 7, 1, 2, 3, 4,3,2,5 };
		print(array);
		mergeSort(array);
		print(array);
	}

	private static void mergeSort(int[] array) {
		int start = 0;
		int finish = array.length - 1;
		sort(array, start, finish);
	}

	private static void sort(int[] array, int start, int finish) {
		if (start < finish) {
			int middle = middle(start, finish);
			sort(array, start, middle);
			sort(array, middle + 1, finish);
			merge(array, start, finish);
		}
	}

	private static void merge(int[] array, int start, int finish) {
		int middle = middle(start, finish);
		int left [] = new int [middle - start + 1];
		int right [] = new int [finish - middle];
		System.arraycopy(array, start, left, 0, left.length);
		System.arraycopy(array, start + left.length, right, 0, right.length);
		
		int l = 0;
		int r = 0;
		int a = start;
		while(l < left.length && r < right.length) {
			if(left[l] < right[r]) {
				array[a] = left[l];
				l++;
			} else {
				array[a] = right[r];
				r++;
			}
			a++;
		}
		
		while(l < left.length ) {
			array[a] = left[l];
			l++;
			a++;
		}
		
		while(r < right.length ) {
			array[a] = right[r];
			r++;
			a++;
		}
	}

	private static int middle(int start, int finish) {
		return start + (finish - start) / 2;
	}
	
	private static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

}
