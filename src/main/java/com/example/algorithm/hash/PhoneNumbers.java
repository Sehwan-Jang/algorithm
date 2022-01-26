package com.example.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumbers {

    private String url = "https://programmers.co.kr/learn/courses/30/lessons/42577";

    public static boolean solution(String[] phone_book) {
        Map<String, Integer> numberSet = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            numberSet.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (numberSet.containsKey(phone_book[i].substring(0,j))) {
                    return false;
                }
            }
        }

        return true;
    }

}
