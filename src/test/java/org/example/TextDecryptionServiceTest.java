package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextDecryptionServiceTest {

    @Test
    public void testConvertUnaryToBinary() {
        assertEquals("1", TextDecryptionService.convertUnaryToBinary("0 0"));
        assertEquals("0", TextDecryptionService.convertUnaryToBinary("00 0"));
        assertEquals("101", TextDecryptionService.convertUnaryToBinary("0 0 00 0 0 0"));
    }

    @Test
    public void testConvertToText() {
        assertEquals("a", TextDecryptionService.convertToText("1100001"));
        assertEquals("b", TextDecryptionService.convertToText("1100010"));
        assertEquals("c", TextDecryptionService.convertToText("1100011"));
    }

    @Test
    public void testDecryptText() {
        assertEquals("Hi <3", TextDecryptionService.decryptText("0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00"));
    }
}