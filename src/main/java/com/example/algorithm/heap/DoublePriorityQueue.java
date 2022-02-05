package com.example.algorithm.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublePriorityQueue {

    public static int[] solution(String[] operations) {
        List<Integer> elements = new ArrayList<>();

        for (String command : operations) {
            Queue<Integer> eq;
            if (command.startsWith("I")) {
                elements.add(Integer.parseInt(command.split(" ")[1]));
                continue;
            } else if (command.startsWith("D") && command.endsWith(" 1") && !elements.isEmpty()) {
                eq = new PriorityQueue<>(Comparator.reverseOrder());
                eq.addAll(elements);
                eq.poll();
            } else if (command.startsWith("D") && command.endsWith(" -1") && !elements.isEmpty()) {
                eq = new PriorityQueue<>(elements);
                eq.poll();
            } else {
                continue;
            }
            elements.clear();
            elements.addAll(eq);
        }

        if (elements.isEmpty()) {
            return new int[]{0, 0};
        }
        int min = elements.stream()
            .mapToInt(it -> it)
            .min()
            .orElse(0);
        int max = elements.stream()
            .mapToInt(it -> it)
            .max()
            .orElse(0);

        return new int[]{max, min};
    }

}
