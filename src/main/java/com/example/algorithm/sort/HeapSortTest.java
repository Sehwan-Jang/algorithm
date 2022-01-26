package com.example.algorithm.sort;

public class HeapSortTest {

	public static boolean hasChild(int[] arr, int index, int length) {
		if (length - 1 >= 2 * index + 1) {
			return true;
		}
		return false;
	}

	public static void max_Heapify(int[] arr, int root, int length) {
		while (hasChild(arr, root, length)) {
			int k;
			if (length - 1 >= root * 2 + 2) {
				k = (arr[2 * root + 1] > arr[2 * root + 2]) ? 2 * root + 1 : 2 * root + 2;
			} else {
				k = root * 2 + 1;
			}

			if (arr[root] >= arr[k]) {
				return;
			}
			int tmp = arr[root];
			arr[root] = arr[k];
			arr[k] = tmp;
			root = k;
		}
	}

	public static void buildMaxHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			max_Heapify(arr, i, arr.length);
		}
	}

	public static void heapSort(int[] arr) {
		buildMaxHeap(arr);

		for (int i = arr.length - 1; i > 0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;

			max_Heapify(arr, 0, i);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 230, 10, 60, 70, 13};
		heapSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

}
