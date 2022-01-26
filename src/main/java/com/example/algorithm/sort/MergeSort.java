package com.example.algorithm.sort;

public class MergeSort {

	public static void mergeSort(int[] data, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(data, p, q);
			mergeSort(data, q+1, r);
			merge(data, p, q, r);
		}
	}

	public static void merge(int[] data, int p, int q, int r) {
		int i = p, j = q + 1, k = p;
		int[] tmp = new int[data.length];

		while (i <= q && j <= r) {
			if (data[i] <= data[j]) {
				tmp[k++] = data[i++];
			} else {
				tmp[k++] = data[j++];
			}
		}

		while (i <= q) {
			tmp[k++] = data[i++];
		}
		while (j <= r) {
			tmp[k++] = data[j++];
		}
		for (int g = p; g <= r; g++) {
			data[g] = tmp[g];
		}
	}

	public static void main(String[] args) {
		int[] data = { 5, 84, 95, 87, 19, 51, 46, 81, 4, 83, 951, 651, 357, 9, 27, 24 };

		mergeSort(data, 0, 15);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

}
