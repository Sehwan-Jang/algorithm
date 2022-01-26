package com.example.algorithm.Recursion;

public class Powerset {
	private static char data[] = {'a','b','c','d','e','f'};
	private static int n = data.length;
	private static boolean[] include = new boolean [n]; //P 집합을 나타내기 위해 boolean 배열 사용
	
	public static void powerSet(int k) {   // data[]는 첫번째 원소부터 k-1번째 까지의 원소와
		if(k==n) {                         // k번째 원소부터 마지막 n번째 까지의 원소로 이루어진 집합                        
			for (int i = 0; i < n; i++) {
				if(include[i]) System.out.print(data[i]+" ");
			}System.out.println();
			return;
		}
		include[k] = false;
		powerSet(k+1);
		include[k] = true;
		powerSet(k+1);
	}
	
	public static void main(String[] args) {
		powerSet(0);
	}
}
