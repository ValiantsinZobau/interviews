package my.test.sort;

import java.util.Arrays;

public class MergeSortTest {
	public static void main(String[] args) {
		int[] array = new int[] { 5, 6, 7, 1, 3, 2 };
		System.out.println("Before sort");
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println("After sort");
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int middle = (right - left) / 2;
		sort(array, left, middle);
		sort(array, middle + 1, right);
		merge(array, left, middle, right);
	}

	private static void merge(int[] array, int left, int middle, int right) {
		int[] leftAr = new int[middle - left + 1];
		int[] rightAr = new int[right - middle];
		System.arraycopy(array, left, leftAr, 0, leftAr.length);
		System.arraycopy(array, left + leftAr.length, rightAr, 0, rightAr.length);
		int l = 0;
		int r = 0;
		int a = left;
		while (l < leftAr.length && r < rightAr.length) {
			if (leftAr[l] < rightAr[r]) {
				array[a] = leftAr[l];
				l++;
			} else {
				array[a] = rightAr[r];
				r++;
			}
			a++;
		}
		// copy remaining elements from both halves - each half will have already sorted
		// elements
		while (l < leftAr.length) {
			array[a] = leftAr[l];
			a++;
			l++;
		}

		while (r < rightAr.length) {
			array[a] = rightAr[r];
			a++;
			r++;
		}
	}

	private static void sort(int[] array, int left, int right) {
		if (left < right) {
			int middle = (right + left) / 2;
			sort(array, left, middle);
			sort(array, middle + 1, right);
			merge(array, left, middle, right);
		}
	}

}
