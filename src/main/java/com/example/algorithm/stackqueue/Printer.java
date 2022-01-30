package com.example.algorithm.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/*
https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Printer {

    public static int solution(int[] priorities, int location) {
        Queue<Integer> sequence = new LinkedList<>();
        Queue<Boolean> target = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            sequence.add(priorities[i]);
            if (i == location) {
                target.add(true);
                continue;
            }
            target.add(false);
        }
        int count = 0;
        int value;
        boolean isTarget = false;

        while (!isTarget) {
            value = sequence.poll();
            isTarget = target.poll();
            if (isPrior(sequence, value)) {
                count++;
                continue;
            }

            sequence.add(value);
            target.add(isTarget);
            isTarget = false;
        }
        return count;
    }

    private static boolean isPrior(Queue<Integer> sequence, int value) {
        for (int p : sequence) {
            if (value < p) {
                return false;
            }
        }
        return true;
    }
}
