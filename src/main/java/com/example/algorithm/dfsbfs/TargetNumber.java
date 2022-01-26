package com.example.algorithm.dfsbfs;

import java.util.Arrays;

public class TargetNumber {

    private static int n;
    private static int[] include;
    private static int answer = 0;

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        include = new int[n];
        Arrays.fill(include, 1);
        powerSet(numbers, target, 0);
        return answer;
    }

    public static void powerSet(int[] numbers, int target,  int k) {
        if(k==n) {           // 집합 S가 공집합인 경우 그냥 P 출력
            int tmp = 0;
            for (int i = 0; i < numbers.length; i++) {
                tmp += numbers[i] * include[i];
            }
            if (tmp == target) {
                answer++;
            }
            return;
        }
        include[k]= 1; // data K를 포함하지 않는 경우
        powerSet(numbers, target, k+1);
        include[k]= -1;  // data K를 포함하는 경우
        powerSet(numbers, target, k+1);
    }
}
