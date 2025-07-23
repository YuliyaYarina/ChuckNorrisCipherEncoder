    package org.example;

    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.*;
    class MainTest {

        @Test
        public void testConvertStringToBinary() {
            assertEquals("1100001", Main.convertStringToBinary("a"));
            assertEquals("1100010", Main.convertStringToBinary("b"));
            assertEquals("1100011", Main.convertStringToBinary("c"));
        }

        @Test
        public void testConvertStringToBinary_EmptyString_ReturnsEmptyString() {
            assertEquals("", Main.convertStringToBinary(""));
        }

        @Test
        public void testEncodeStringUsingChuckNorrisMethod() {
            assertEquals("The result: 0 0", Main.encodeStringUsingChuckNorrisMethod("1"));
            assertEquals("The result: 00 0", Main.encodeStringUsingChuckNorrisMethod("0"));
            assertEquals("The result: 0 0 00 0 0 0", Main.encodeStringUsingChuckNorrisMethod("101"));
            assertEquals("The result: 00 00 0 0", Main.encodeStringUsingChuckNorrisMethod("001"));
        }

        @Test
        public void testGetRepeatedZeros() {
            assertEquals("0", Main.getRepeatedZeros(1));
            assertEquals("00", Main.getRepeatedZeros(2));
            assertEquals("000", Main.getRepeatedZeros(3));
        }

        @Test
        void testMain_ReturnsCorrectChuckNorrisCode() {
            assertEquals("The result: 0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00", Main.encodeStringUsingChuckNorrisMethod(Main.convertStringToBinary("Hi <3")));
        }
}
