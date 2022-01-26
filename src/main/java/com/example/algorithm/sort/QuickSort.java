package com.example.algorithm.sort;


public class QuickSort {
	
	public static int partition(int[] array, int p, int r) {
		int tmp;
		int j = p;
		for (int i = p; i < r; i++) {
			if(array[i]<=array[r]) {
				tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				j++;
			}
		}
		tmp = array[r];
		array[r] = array[j];
		array[j] = tmp;
		return j;
	}
	
	public static void quickSort(int[] array, int p, int r) {
		if (p<r) {
			int q = partition(array, p, r);
			quickSort(array, p, q-1);
			quickSort(array, q+1, r);
		}else 
			return;
	}

	public static void main(String[] args) {

		int[] qs = {31,8,31,73,11,3,20,29,65,15};
		quickSort(qs, 0, 9);
		for (int i = 0; i < qs.length; i++) {
			System.out.print(qs[i] + " ");
		}
		
	}

}
