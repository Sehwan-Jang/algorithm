package com.example.algorithm.heap;

import java.util.ArrayList;
import java.util.List;

/*
https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Spicier {

    public static int solution(int[] scoville, int K) {
        List<Integer> remain = new ArrayList<>();
        for (int i : scoville) {
            remain.add(i);
        }
        buildHeap(remain);
        int weakest = 0;
        int count = 0;

        while (weakest < K) {
            if (remain.size() <= 1) {
                if (remain.get(0) >= K) {
                    return count;
                } else {
                    return -1;
                }
            }
            weakest = poll(remain) + poll(remain) * 2;
            remain.add(weakest);
            weakest = remain.get(0);
            count++;
        }
        return count;
    }

    private static int poll(List<Integer> arr) {
        int tmp = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, tmp);
        tmp = arr.remove(arr.size() - 1);
        minHeapify(arr, 0);
        return tmp;
    }

    private static boolean hasChild(List<Integer> arr, int index) {
        return arr.size() - 1 >= index * 2 + 1;
    }

    private static void minHeapify(List<Integer> arr, int index) {
        int k;

        while (hasChild(arr, index)) {
            if (arr.size() - 1 >= (index + 1) * 2) {
                k = arr.get(index * 2 + 1) <= arr.get((index + 1) * 2) ? index * 2 + 1 : (index + 1) * 2;
            } else {
                k = index * 2 + 1;
            }

            if (arr.get(index) <= arr.get(k)) {
                return;
            }

            int tmp;
            tmp = arr.get(index);
            arr.set(index, arr.get(k));
            arr.set(k, tmp);
            index = k;
        }
    }

    private static void buildHeap(List<Integer> arr) {
        for (int i = (arr.size() - 1) / 2; i >= 0; i--) {
            minHeapify(arr, i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        System.out.println(objects.get(0));
        objects.remove(0);
        System.out.println(objects.get(0));
    }

//    public int solution(int[] scoville, int K) {
//        int answer = 0;
//        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
//        for(int i : scoville) {
//            que.add(i);
//        }
//
//        while(que.peek()<K) {
//            if(que.size()<=1) {
//                answer = -1;
//                break;
//            }
//            que.add(que.poll()+que.poll()*2);
//            answer++;
//        }
//        return answer;
//    }
}
