package com.example.algorithm.sort;

/*
https://programmers.co.kr/learn/courses/30/lessons/42748
 */

import java.util.Arrays;

public class KNumber {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            sort(tmp, 0, tmp.length - 1);
            answer[i] = tmp[commands[i][2] - 1];
        }
        return answer;
    }

    private static void sort(int[] tmp, int p, int r) {
        if (p < r) {
            int q = partition(tmp, p, r);
            sort(tmp, p, q-1);
            sort(tmp, q + 1, r);
        }
    }

    private static int partition(int[] array, int l, int r) {
        int pivot = array[l];
        int i = l;
        int j = r;
        int tmp;
        while (i < j) {
            while (array[j] > pivot) {
                j--;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        tmp = array[l];
        array[l] = array[i];
        array[i] = tmp;
        return i;
    }
}
