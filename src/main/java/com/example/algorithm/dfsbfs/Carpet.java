package com.example.algorithm.dfsbfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
https://programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Carpet {

    public static int[] solution(int brown, int yellow) {
        Map<Integer, Integer> possibleYellow = new HashMap<>();
        for (int i = yellow; i >= 1; i--) {
            if (yellow % i == 0 && yellow / i <= i) {
                possibleYellow.put(i, yellow / i);
            }
        }
        Entry<Integer, Integer> answerEntry = possibleYellow.entrySet().stream()
            .filter(it -> (it.getKey() + it.getValue()) * 2 == brown - 4)
            .findAny()
            .get();

        return new int[]{answerEntry.getKey() + 2, answerEntry.getValue() + 2};
    }
}
