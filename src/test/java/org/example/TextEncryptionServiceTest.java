package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextEncryptionServiceTest {

    @ParameterizedTest
    @CsvSource({"1100001, a", "1100010, b", "1100011, c"})
    @DisplayName("Перевод символа в 7-bit")
    void testConvertToBinary(String expected, String inputString) {
        assertEquals(expected, TextEncryptionService.convertToBinary(inputString));
    }

    @ParameterizedTest
    @CsvSource({"0 0, 1", "00 0, 0", "0 0 00 0 0 0, 101"})
    public void testEncryptString(String expected, String binaryString) {
        assertEquals(expected, TextEncryptionService.encryptString(binaryString));
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "00, 2", "000, 3"})
    public void testGetRepeatedZeros(String expected, int count) {
        assertEquals(expected, TextEncryptionService.getRepeatedZeros(count));
    }

    @Test
    public void testEncryptText() {
        assertEquals("0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00", TextEncryptionService.encryptText("Hi <3"));
        assertThat(TextEncryptionService.encryptText("Hi <3")).isNotNull();

    }
}