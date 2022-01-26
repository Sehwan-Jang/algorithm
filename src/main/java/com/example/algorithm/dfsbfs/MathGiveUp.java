package com.example.algorithm.dfsbfs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class MathGiveUp {

    public static int[] solution(int[] answers) {
        int[] s1 = new int[answers.length];
        int[] s2 = new int[answers.length];
        int[] s3 = new int[answers.length];

        fill1(answers, s1);
        fill2(answers, s2);
        fill3(answers, s3);

        Map<Integer, Integer> correct = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (s1[i] == answers[i]) {
                correct.put(1, correct.getOrDefault(1, 0) + 1);
            }
            if (s2[i] == answers[i]) {
                correct.put(2, correct.getOrDefault(2, 0) + 1);
            }
            if (s3[i] == answers[i]) {
                correct.put(3, correct.getOrDefault(3, 0) + 1);
            }
        }
        int max = correct.values().stream()
            .max(Comparator.comparingInt(o -> o))
            .get();

        List<Integer> collect = correct.keySet().stream()
            .filter(s -> correct.get(s) == max)
            .collect(Collectors.toList());
        int[] answer = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            answer[i] = collect.get(i);
        }
        return answer;
    }

    private static void fill3(int[] answers, int[] s3) {
        for (int i = 0; i < answers.length; i ++) {
            switch ((i + 1) % 10) {
                case 1:
                case 2:
                    s3[i] = 3;
                    continue;
                case 3:
                case 4:
                    s3[i] = 1;
                    continue;
                case 5:
                case 6:
                    s3[i] = 2;
                    continue;
                case 7:
                case 8:
                    s3[i] = 4;
                    continue;
                case 9:
                case 0:
                    s3[i] = 5;
            }
        }
    }

    private static void fill2(int[] answers, int[] s2) {
        for (int i = 0; i < answers.length; i++) {
            if ((i + 1) % 2 == 1) {
                s2[i] = 2;
                continue;
            }
            switch ((i + 1) % 8) {
                case 2:
                    s2[i] = 1;
                    continue;
                case 4:
                    s2[i] = 3;
                    continue;
                case 6:
                    s2[i] = 4;
                    continue;
                case 0:
                    s2[i] = 5;
            }
        }
    }

    private static void fill1(int[] answers, int[] s1) {
        for (int i = 0; i < answers.length; i++) {
            switch ((i + 1) % 5) {
                case 1:
                    s1[i] = 1;
                    continue;
                case 2:
                    s1[i] = 2;
                    continue;
                case 3:
                    s1[i] = 3;
                    continue;
                case 4:
                    s1[i] = 4;
                    continue;
                case 0:
                    s1[i] = 5;
            }
        }
    }
}
