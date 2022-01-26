package com.example.algorithm.dfsbfs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SearchTest {

    private final TargetNumber targetNumber = new TargetNumber();

    @ParameterizedTest
    @CsvSource(value = {"1,1,1,1,1:3:5"}, delimiter = ':')
    void solve(String input, int target, int expected) {
        int[] numbers = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int actual = targetNumber.solution(numbers, target);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5:1", "1,3,2,4,2:1,2,3"}, delimiter = ':')
    void mathGiveUp(String input, String input2) {
        int[] answers = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] expected = Arrays.stream(input2.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(MathGiveUp.solution(answers)).containsExactly(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:2:4,3", "8:1:3,3", "24:24:8,6"}, delimiter = ':')
    void carpet(String brown, String yellow, String input) {
        int[] expected = Arrays.stream(input.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        assertThat(Carpet.solution(Integer.parseInt(brown), Integer.parseInt(yellow)))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"hit:cog:hot,dot,dog,lot,log,cog:4", "hit:cog:hot,dot,dog,lot,log:0"}, delimiter = ':')
    void wordChange(String begin, String target, String chunk, String expected) {
        String[] words = Arrays.stream(chunk.split(","))
            .toArray(String[]::new);

        assertThat(WordChange.solution(begin, target, words))
            .isEqualTo(Integer.parseInt(expected));
    }

}