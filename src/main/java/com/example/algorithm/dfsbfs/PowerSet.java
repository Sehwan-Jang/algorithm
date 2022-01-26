package com.example.algorithm.dfsbfs;

public class PowerSet {

    private static char data[] = {'a','b','c','d','e','f'};
    private static int n = data.length;
    private static boolean[] include = new boolean [n]; //P 집합을 나타내기 위해 boolean 배열 사용

    public static void powerSet(int k) {
        if(k==n) {           // 집합 S가 공집합인 경우 그냥 P 출력
            for (int i = 0; i < n; i++) {
//                if(include[i]) System.out.print(data[i] + " ");
                System.out.print(include[i] + " ");
            }System.out.println();
            return;
        }
        include[k]=false; // data K를 포함하지 않는 경우
        powerSet(k+1);
        include[k]=true;  // data K를 포함하는 경우
        powerSet(k+1);
    }

    public static void main(String[] args) {
        PowerSet.powerSet(0);
    }

}
