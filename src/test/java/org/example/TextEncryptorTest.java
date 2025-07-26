package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextEncryptorTest {


    @Test
    public void testConvertStringToBinary() {
        assertEquals("1100001", TextEncryptionService.convertStringToBinary("a"));
        assertEquals("1100010", TextEncryptionService.convertStringToBinary("b"));
        assertEquals("1100011", TextEncryptionService.convertStringToBinary("c"));
    }

    @Test
    public void testConvertStringToBinary_EmptyString_ReturnsEmptyString() {
        assertEquals("", TextEncryptionService.convertStringToBinary(""));
    }

    @Test
    public void testEncodeStringUsingChuckNorrisMethod() {
        assertEquals("The result: 0 0", TextEncryptionService.encryptString("1"));
        assertEquals("The result: 00 0", TextEncryptionService.encryptString("0"));
        assertEquals("The result: 0 0 00 0 0 0", TextEncryptionService.encryptString("101"));
        assertEquals("The result: 00 00 0 0", TextEncryptionService.encryptString("001"));
    }

    @Test
    public void testGetRepeatedZeros() {
        assertEquals("0", TextEncryptionService.getRepeatedZeros(1));
        assertEquals("00", TextEncryptionService.getRepeatedZeros(2));
        assertEquals("000", TextEncryptionService.getRepeatedZeros(3));
    }

    @Test
    void testMain_ReturnsCorrectChuckNorrisCode() {
        assertEquals("The result: 0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00", TextEncryptionService.encryptString(TextEncryptionService.convertStringToBinary("Hi <3")));
    }
}