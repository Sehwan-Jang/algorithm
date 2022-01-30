package com.example.algorithm.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class FunctionDev {

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployCount = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            days.add((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }

        int criteria;
        int count = 0;
        while (!days.isEmpty()) {
            criteria = days.peek();
            while (!days.isEmpty() && days.peek() <= criteria) {
                days.poll();
                count++;
            }
            deployCount.add(count);
            count = 0;
        }

        return deployCount.stream()
            .mapToInt(it -> it)
            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil((double)10 / 7));
    }
}
