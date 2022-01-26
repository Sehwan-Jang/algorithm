package com.example.algorithm.Recursion;

public class Queens {
	static int n = 8;
	static int[] cols = new int[n+1];
	
	static boolean promising(int level) { 
		for (int i = 1; i < level; i++) {
			if(cols[i]==cols[level]) // 일직선상 판단
				return false;
			else if(level-i == Math.abs(cols[i]-cols[level])) // 대각선상 판단
				return false;			
		}
		return true;
	}
	
	static boolean queens(int level) {
		if(!promising(level))  // 꽝인 트리 검색 하지 않게
			return false;
		else if(level==n) {
			for (int i = 1; i < 9; i++) {
				System.out.println("(" + i + ","+ cols[i] + ")");				
			}
			return true;
		}
		else { // 하위트리 검색
			for (int i = 1; i <= n; i++) {
				cols[level+1] = i;
				if(queens(level+1))
					return true;
			}			
		}		
		return false;
	}
	public static boolean ok (int a) {
		if (a >2) {
			return true;
		}return false;
	}
	
	public static void main(String[] args) {
		queens(0);
		
	}

}
