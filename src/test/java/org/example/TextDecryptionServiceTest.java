package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextDecryptionServiceTest {

    @ParameterizedTest
    @CsvSource({"1, 0 0", "0, 00 0", "101, 0 0 00 0 0 0"})
    void testConvertUnaryToBinary(String expected, String unarySequence) {
        assertEquals(expected, TextDecryptionService.convertUnaryToBinary(unarySequence));
    }

    @ParameterizedTest
    @CsvSource({"a, 1100001", "b, 1100010", "c, 1100011"})
    void testConvertToText(String expected, String binaryString) {
        assertEquals(expected, TextDecryptionService.convertToText(binaryString));
    }

    @Test
    void testDecryptText() {
        String unary = "0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00";
        String actual = "Hi <3";
        assertThat(actual).isEqualTo(TextDecryptionService.decryptText(unary));
    }
}