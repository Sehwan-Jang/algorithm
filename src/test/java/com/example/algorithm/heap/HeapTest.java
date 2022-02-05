package com.example.algorithm.heap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HeapTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,9,10,12:7:2", "1,5,8,9:12:3"}, delimiter = ':')
    void spicier(String input, String k, String expected) {
        int[] scoville = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(Spicier.solution(scoville, Integer.parseInt(k)))
            .isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"I 16,D 1:0,0", "I 7,I 5,I -5,D -1:7,5"}, delimiter = ':')
    void doublePriorityQueue(String input1, String input2) {
        String[] operations = input1.split(",");
        int[] expected = Arrays.stream(input2.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(DoublePriorityQueue.solution(operations))
            .containsExactly(expected);
    }
}