package com.example.algorithm.stackqueue;

import java.util.HashMap;
import java.util.Map;

/*
https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class Truck {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int nextIndex = 0;
        int firstIndex = 0;
        int time = 0;
        Map<Integer, Integer> progresses = new HashMap<>();
        progresses.put(nextIndex++, 0);
        while (firstIndex < truck_weights.length) {
            if (progresses.get(firstIndex) == bridge_length) {
                progresses.remove(firstIndex);
                firstIndex++;
            }

            int weightSum = progresses.keySet().stream()
                .mapToInt(it -> truck_weights[it])
                .sum();
            if (time != 0 && nextIndex < truck_weights.length && weightSum + truck_weights[nextIndex] <= weight) {
                progresses.put(nextIndex, 0);
                nextIndex++;
            }
            progresses.replaceAll((i, v) -> progresses.get(i) + 1);

            time++;
        }

        return time;
    }
}
