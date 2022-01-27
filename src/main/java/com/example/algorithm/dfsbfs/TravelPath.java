package com.example.algorithm.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class TravelPath {

    private static boolean[] visited;

    public static String[] solution(String[][] tickets) {
        List<String> path = new ArrayList<>();
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else {
                return o1[0].compareTo(o2[0]);
            }
        });
        visited = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                path.add(tickets[i][0]);
                path.add(tickets[i][1]);
                visited[i] = true;
                dfs(tickets, i, path);

                if (path.size() == tickets.length + 1) {
                    break;
                }
            }
        }

        return path.toArray(String[]::new);
    }

    private static void dfs(String[][] tickets, int n, List<String> path) {
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && isLinked(tickets, n, i)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets, i, path);
                if (path.size() != tickets.length + 1) {
                    visited[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private static boolean isLinked(String[][] tickets, int n, int i) {
        return tickets[n][1].equals(tickets[i][0]);
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] b = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] c = {{"ICN", "BBB"}, {"ICN", "CCC"}, {"BBB", "CCC"}, {"CCC", "BBB"},
            {"CCC", "ICN"}}; // ["ICN", "BBB", "CCC", "ICN", "CCC", "BBB"]
        String[] solution = solution(c);
        for (String s : solution) {
            System.out.println(s);
        }
    }

}
