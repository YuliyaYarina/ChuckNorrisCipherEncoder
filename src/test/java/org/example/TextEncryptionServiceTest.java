package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextEncryptionServiceTest {

    @Test
    public void testConvertToBinary() {
        assertEquals("1100001", TextEncryptionService.convertToBinary("a"));
        assertEquals("1100010", TextEncryptionService.convertToBinary("b"));
        assertEquals("1100011", TextEncryptionService.convertToBinary("c"));
    }

    @Test
    public void testEncryptString() {
        assertEquals("0 0", TextEncryptionService.encryptString("1"));
        assertEquals("00 0", TextEncryptionService.encryptString("0"));
        assertEquals("0 0 00 0 0 0", TextEncryptionService.encryptString("101"));
    }

    @Test
    public void testGetRepeatedZeros() {
        assertEquals("0", TextEncryptionService.getRepeatedZeros(1));
        assertEquals("00", TextEncryptionService.getRepeatedZeros(2));
        assertEquals("000", TextEncryptionService.getRepeatedZeros(3));
    }

    @Test
    public void testEncryptText() {
        assertEquals("0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00", TextEncryptionService.encryptText("Hi <3"));
    }
}