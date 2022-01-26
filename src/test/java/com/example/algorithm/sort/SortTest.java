package com.example.algorithm.sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SortTest {

    @Test
    void kNumber() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        int[] expected = {5, 6, 3};
        assertThat(KNumber.solution(array, commands)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,100,1000:1101001000", "0,0,00,00,0,0,0,000,00,00,0:0", "3,30,34,5,9:9534330"}, delimiter = ':')
    void biggestNum(String input, String expected) {
        int[] integers = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(BiggestNum.solution(integers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0,6,1,5:3", "1,20,30,40:3", "4,4,4,4,4:4"}, delimiter = ':')
    void hIndex(String input, String expected) {
        int[] citation = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(HIndex.solution(citation)).isEqualTo(Integer.parseInt(expected));
    }
}