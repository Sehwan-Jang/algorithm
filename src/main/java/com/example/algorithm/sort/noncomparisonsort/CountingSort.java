package com.example.algorithm.sort.noncomparisonsort;


import com.example.algorithm.sort.Heap_PriorityQueueTest;

public class CountingSort {

	public static void countingSort(int[] arr, int[] arr2, int k) {
		int[] countarr = new int[k+1];
		for(int i=0; i<arr.length; i++) {
			countarr[arr[i]]++; 
		}
		for(int i=1; i<countarr.length; i++) {
			countarr[i] += countarr[i-1];
		}
		for(int i=arr.length-1; i>=0; i--) {
			arr2[countarr[arr[i]]-1] = arr[i];
			countarr[arr[i]]--;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,3,5,7,8,2,3,4,2,1,2,0,5,7,9};
		int[] arr2 = new int[arr.length];
		
		countingSort(arr, arr2, 9);
		Heap_PriorityQueueTest.printArray(arr2);
	}

}
