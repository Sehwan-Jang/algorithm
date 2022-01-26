package com.example.algorithm.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/*
https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class WordChange {

    private static boolean[] visited;
    private static Queue<Integer> q = new LinkedList();
    private static int[] lengths;
    private static int[] previous;

    public static int solution(String begin, String target, String[] words) {
        int targetIdx = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                targetIdx = i + 1;
                break;
            }
        }
        if (targetIdx == -1) {
            return 0;
        }

        String[] targets = new String[words.length + 1];
        System.arraycopy(words, 0, targets, 1, words.length);
        targets[0] = begin;
        visited = new boolean[targets.length];
        lengths = new int[targets.length];
        previous = new int[targets.length];

        q.add(0);
        visited[0] = true;
        int u;
        while (!q.isEmpty()) {
            u = q.poll();
            for (int i = 0; i < targets.length; i++) {
                if (!visited[i] && isLinked(targets[u], targets[i])) {
                    q.add(i);
                    visited[i] = true;
                    previous[i] = u;
                    lengths[i] = lengths[u] + 1;
                }
            }
        }

        return lengths[targetIdx];
    }

    private static boolean isLinked(String s1, String s2) {
        List<String> split1 = Arrays.stream(s1.split(""))
            .collect(Collectors.toList());
        List<String> split2 = Arrays.stream(s2.split(""))
            .collect(Collectors.toList());

        int count = 0;
        for (int i = 0; i <split1.size(); i++) {
            if (split1.get(i).equals(split2.get(i))) {
                count++;
            }
        }
        return count == split1.size() - 1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5};
        int[] b = new int[a.length + 2];
        System.arraycopy(a, 0, b, 1, a.length);
        for (int c : b) {
            System.out.println(c);
        }
        System.out.println(isLinked("avb", "axb"));
    }

}
