package com.example.algorithm.sort;


import java.util.Arrays;

/*
https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i > 0; i--) {
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i && citations.length - j >= i) {
                    return i;
                }
                if (citations.length - j < i) {
                    break;
                }
            }
        }
        return 0;
    }

}
