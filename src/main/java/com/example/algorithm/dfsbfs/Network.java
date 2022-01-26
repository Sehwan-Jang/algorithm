package com.example.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Network {

    private static boolean[] visited;
    private static Queue<Integer> vq;

    public static int solution(int n, int[][] computers) {
        // 오답 풀이
//        Map<Integer, Integer> networks = new HashMap<>();
//
//        for (int i = 0; i < computers.length; i++) {
//            for (int j = i + 1; j < computers[i].length; j++) {
//                if (computers[i][j] == 1) {
//                    networks.put(i, networks.getOrDefault(i, 0) + 1);
//                }
//            }
//        }
//
//        int sum = networks.values().stream()
//            .reduce(Integer::sum)
//            .get();
//        return computers.length - sum;
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                answer ++;
                dfs(i, computers);
            }
        }
        return answer;
    }

    public static void bfs(int s, int[][] graph) {
        visited = new boolean[graph.length];
        vq = new LinkedList<>();
        int u;

        vq.add(s);
//        visited[s] = true;
        while (!vq.isEmpty()) {
            u = vq.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[u][i] == 1 && !visited[i]) {
                    System.out.print(i + " ");
                    visited[i] = true;
                    vq.add(i);
                }
            }
        }
    }

    public static void dfs(int s, int[][] graph) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i = 0; i < graph[s].length; i++) {
            if (graph[s][i] == 1 && !visited[i]) {
                dfs(i, graph);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,1,0,1}, {1,1,1,0}, {0,1,1,1}, {1,0,1,1}};
//        System.out.println(solution(4, graph));
        System.out.println("bfs");
        bfs(0, graph);
        visited = new boolean[graph.length];
        System.out.println("dfs");
        dfs(0, graph);
    }
}