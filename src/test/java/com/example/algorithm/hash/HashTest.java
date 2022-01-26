package com.example.algorithm.hash;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class HashTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "leo, kiki, eden:eden, kiki:leo",
        "marina, josipa, nikola, vinko, filipa:josipa, filipa, marina, nikola:vinko",
        "mislav, stanko, mislav, ana:stanko, ana, mislav:mislav"
    })
    void marathon(String input) {
        String[] inputs = input.split(":");
        String[] participants = inputs[0].replace(" ", "").split(",");
        String[] completes = inputs[1].replace(" ", "").split(",");
        String expected = inputs[2];

        assertThat(Marathon.solution(participants, completes)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"119,97674223,1195524421:false", "123,456,789:true", "12,123,1235,567,88:false"}, delimiter = ':')
    void phoneNumber(String input, boolean expected) {
        String[] inputs = input.split(",");

        assertThat(PhoneNumbers.solution(inputs)).isEqualTo(expected);
    }
}