package com.example.algorithm.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class DiskController {

    public static int solution(int[][] jobs) {
        List<Jobs> jl = new ArrayList<>();
        for (int i = 0; i <jobs.length; i++) {
            jl.add(new Jobs(jobs[i][0], jobs[i][1], false));
        }
        int count = jobs.length;
        int currentTime = 0;
        int costSum = 0;
        int reqSum = jl.stream()
            .mapToInt(Jobs::getReqTime)
            .sum();

        while (!isFinished(jl)) {
            final int ct = currentTime;
            List<Jobs> possible = jl.stream()
                .filter(it -> !it.isCompleted() && it.isRequested(ct))
                .collect(Collectors.toList());
            Jobs target;
            if (possible.isEmpty()) {
                PriorityQueue<Jobs> pq = jl.stream()
                    .filter(it -> !it.isCompleted()).collect(Collectors.toCollection(PriorityQueue::new));
                target = pq.poll();
                currentTime = target.getReqTime() + target.getCost();
            } else {
                PriorityQueue<Jobs> pq = new PriorityQueue<>(Comparator.comparingInt(Jobs::getCost));                   ;
                pq.addAll(possible);
                target = pq.poll();
                currentTime += target.getCost();
            }
            costSum += currentTime - target.getReqTime();
            System.out.println("target : " + target.getReqTime() + " "+ target.getCost() + " " + costSum);
            count--;
            target.complete();
        }

        return costSum / jobs.length;
    }

    public static boolean isFinished(List<Jobs> jobsList) {
        return jobsList.stream()
            .allMatch(Jobs::isCompleted);
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; // 9
        int[][] j = {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}}; // 13
        int[][] jobs2 = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; // 72
        System.out.println(solution(jobs2));
    }
}

class Jobs implements Comparable<Jobs>{
        private int reqTime;
        private int cost;
        private boolean completed;

    public Jobs(int reqTime, int cost, boolean completed) {
        this.reqTime = reqTime;
        this.cost = cost;
        this.completed = completed;
    }

    public void complete() {
        this.completed = true;
    }

    public boolean isRequested(int currentTime) {
        return this.reqTime <= currentTime;
    }

    public int getReqTime() {
        return reqTime;
    }

    public int getCost() {
        return cost;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public int compareTo(Jobs o) {
        if (this.reqTime == o.reqTime) {
            return this.cost - o.cost;
        } else {
            return this.reqTime - o.reqTime;
        }
    }
}
