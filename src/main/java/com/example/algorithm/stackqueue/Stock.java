package com.example.algorithm.stackqueue;
/*
https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class Stock {


    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }
}
