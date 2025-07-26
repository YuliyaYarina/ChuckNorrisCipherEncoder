package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextDecryptorTest {

    @Test
    void testDecryptText() {

    }
    @Test
    void testConvertUnaryToBinary() {
        assertEquals("1", TextDecryptionService.convertUnaryToBinary("0 0"));
        assertEquals("0", TextDecryptionService.convertUnaryToBinary("00 0"));
        assertEquals("101", TextDecryptionService.convertUnaryToBinary("0 0 00 0 0 0"));
        assertEquals("001", TextDecryptionService.convertUnaryToBinary("00 00 0 0"));
    }
}