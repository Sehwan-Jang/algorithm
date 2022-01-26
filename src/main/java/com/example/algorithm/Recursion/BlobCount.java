package com.example.algorithm.Recursion;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlobCount {
	private static int N=8;
	private static int [][] blob = {
			{1,0,0,0,0,0,0,1},
			{0,1,1,0,0,1,0,0},
			{1,1,0,0,1,0,1,0},
			{0,0,0,0,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{1,0,0,0,1,0,0,1},
			{0,1,1,0,0,1,1,1}
	};
	
	@SuppressWarnings("unused")
	private static int BLANK_COLOR = 0;
	private static int IMAGE_COLOR = 1;
	private static int COUNTED_COLOR = 2;
	
	public static int blobCount(int x, int y) {
		if (x < 0 || y <0 || x>=N || y>=N) 
			return 0;
		else if(blob[x][y] != IMAGE_COLOR)
			return 0;
		else 
			blob[x][y] = COUNTED_COLOR;
			return 1+blobCount(x, y-1) +blobCount(x+1, y-1) +blobCount(x+1, y)+
					blobCount(x+1, y+1)+blobCount(x, y+1)+blobCount(x-1, y+1)+
					blobCount(x-1, y) +blobCount(x-1, y-1); 
		
	}
	
	public static void main(String[] args) {
		System.out.println(blobCount(5, 5));
		System.out.println();

		for (int i = 0; i < blob.length; i++) {
			for (int j = 0; j < blob.length; j++) {
				System.out.print(blob[i][j] + " ");
			}System.out.println();
		}

		String[][] hello = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(hello));
		List<Integer> integers = Collections.singletonList(1);
		System.out.println(integers.stream()
			.reduce((a, b) -> a * b)
			.orElse(100));
	}

	public static int solution(String[][] clothes) {
		int answer = clothes.length;
		Map<String, Integer> clothesCount = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			String clothType = clothes[i][1];
			clothesCount.put(clothType,
				clothesCount.getOrDefault(clothType, 0) + 1);
		}

		if (clothesCount.keySet().size() == 1) {
			return answer;
		}
		return clothesCount.values().stream()
			.map(count -> count + 1)
			.reduce((first, second) -> first * second)
			.orElse(0) - 1;
	}
}
