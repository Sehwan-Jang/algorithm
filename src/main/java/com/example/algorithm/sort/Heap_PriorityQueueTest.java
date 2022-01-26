package com.example.algorithm.sort;


public class Heap_PriorityQueueTest {  // 코드는 구현 했지만 메서드로 복사한
									//배열 값이 메서드 밖으로 나오면 적용이 안됨
									// 스태틱 변수로 해결함
	public static int[] arr = {3,4,6,21,1,5,23,8,234,25};
	
	public static void exchange(int[] arr, int id1, int id2) {
		int tmp = arr[id1];
		arr[id1] = arr[id2];
		arr[id2] = tmp;
	}

	public static void insert(int[] arr, int key) {
		int[] tmp = new int[arr.length + 1];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		int i = tmp.length - 1;
		tmp[i] = key;
		
		while (i > 0 && tmp[i] > tmp[(i - 1) / 2]) {
			exchange(tmp, i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
		Heap_PriorityQueueTest.arr = tmp;
	}
	
	public static int extract(int[] arr) {
		if(arr.length <1) {
			System.out.println("heap underflow");			
		}
		int max = arr[arr.length-1];
		
		exchange(arr, 0, arr.length-1);
		int[] tmp = new int[arr.length-1];
		System.arraycopy(arr, 0, tmp, 0, tmp.length);
		HeapSortTest.max_Heapify(tmp, 0	, tmp.length);
		
		Heap_PriorityQueueTest.arr = tmp;
		return max;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {	
		
		HeapSortTest.buildMaxHeap(arr);;
		printArray(arr);
		insert(arr, 50);
		printArray(arr);
		extract(arr);
		printArray(arr);
	
	}

}
