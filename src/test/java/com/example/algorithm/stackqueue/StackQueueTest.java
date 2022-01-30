package com.example.algorithm.stackqueue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StackQueueTest {

    @ParameterizedTest
    @CsvSource(value = {"93,30,55:1,30,5:2,1", "95,90,99,99,80,99:1,1,1,1,1,1:1,3,2"}, delimiter = ':')
    void functionDev(String input1, String input2, String input3) {
        int[] progresses = Arrays.stream(input1.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] speeds = Arrays.stream(input2.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] expected = Arrays.stream(input3.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(FunctionDev.solution(progresses, speeds)).containsExactly(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1,3,2:2:1", "1,1,9,1,1,1:0:5"}, delimiter = ':')
    void printer(String input, String location, String expected) {
        int[] priorities = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(Printer.solution(priorities, Integer.parseInt(location)))
            .isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:10:7,4,5,6:8", "100:100:10:101", "100:100:10,10,10,10,10,10,10,10,10,10:110"}, delimiter = ':')
    void truck(String length, String weight, String input, String expected) {
        int[] weights = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(Truck.solution(Integer.parseInt(length), Integer.parseInt(weight), weights))
            .isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,2,3:4,3,1,1,0"}, delimiter = ':')
    void stock(String input1, String input2) {
        int[] prices = Arrays.stream(input1.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] expected = Arrays.stream(input2.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(Stock.solution(prices)).containsExactly(expected);
    }
}