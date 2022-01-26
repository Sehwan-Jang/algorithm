package com.example.algorithm.hash;

import java.util.*;
import java.util.Map.Entry;

public class Marathon {

    private String url = "https://programmers.co.kr/learn/courses/30/lessons/42576";

    public static String solution(String[] participants, String[] completions) {
        Map<String, Integer> count = new HashMap<>();
        for (String participant : participants) {
            count.put(participant, count.getOrDefault(participant, 0) + 1);
        }
        for (String completion : completions) {
            count.put(completion, count.getOrDefault(completion, 0) - 1);
        }

        String answer = "";
        for (Entry<String, Integer> countSet : count.entrySet()) {
            if (countSet.getValue() != 0) {
                answer = countSet.getKey();
            }
        }

        return answer;
    }

}
