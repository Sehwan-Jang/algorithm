package com.example.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/*
https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class BiggestNum {

    public static String solution(int[] numbers) {
//        sort(numbers, 0, numbers.length - 1);
//        StringBuilder stringBuilder = new StringBuilder();
//        boolean b = true;
//        for (int i : numbers) {
//            if (b && i == 0) {
//                continue;
//            }
//            b = false;
//            stringBuilder.append(i);
//        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numList.add(numbers[i]);
        }

        numList.sort((o1, o2) -> {
            String s1 = String.valueOf(o1) + o2;
            String s2 = String.valueOf(o2) + o1;
            return -Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2));
        });

        StringBuilder sb = new StringBuilder();
        for (int i : numList) {
            sb.append(i);
        }
        String answer = sb.toString();
        while (answer.startsWith("0") && answer.length() != 1) {
            answer = answer.substring(1);
        }

        return answer;
    }

    private static void sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            sort(arr, p, q-1);
            sort(arr, q + 1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {
        int i = p;
        int j = r;
        int tmp;

        while (i < j) {
            while(isPrior(arr[p], arr[j])) {
                j--;
            }
            while (i < j && isPrior(arr[i], arr[p])) {
                i++;
            }
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        tmp = arr[p];
        arr[p] = arr[i];
        arr[i] = tmp;

        return i;
    }

    private static boolean isPrior(int x, int y) {
        String first = x + String.valueOf(y);
        String second = y + String.valueOf(x);

        return Integer.parseInt(first) > Integer.parseInt(second);
    }

}
