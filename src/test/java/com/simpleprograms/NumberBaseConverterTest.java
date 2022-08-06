/*
 * MIT License
 *
 * Copyright (c) 2022 Ivan Bobrov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
 * whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.simpleprograms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link NumberBaseConverter}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class NumberBaseConverterTest {

    private NumberBaseConverter numberBaseConverter;



    @BeforeEach
    void setUp() {
        numberBaseConverter = new NumberBaseConverter(16, 10, 5);
    }



    @Test
    @DisplayName("Get source base")
    void getSourceBase() {
        assertEquals(16, numberBaseConverter.getSourceBase());
    }

    @Test
    @DisplayName("Set source base")
    void setSourceBase() {
        for (int i = 2; i < 37; i++) {
            numberBaseConverter.setSourceBase(i);
            assertEquals(i, numberBaseConverter.getSourceBase());
        }
    }

    @Test
    @DisplayName("Set invalid source base")
    void setInvalidSourceBase() {
        for (int i = -10; i < 2; i++) {
            final int finalI = i;
            assertThrows(
                    IllegalArgumentException.class,
                    () -> numberBaseConverter.setSourceBase(finalI)
            );
        }

        assertThrows(IllegalArgumentException.class, () -> numberBaseConverter.setSourceBase(37));
    }

    @Test
    @DisplayName("Get target base")
    void getTargetBase() {
        assertEquals(10, numberBaseConverter.getTargetBase());
    }

    @Test
    @DisplayName("Set target base")
    void setTargetBase() {
        for (int i = 2; i < 37; i++) {
            numberBaseConverter.setTargetBase(i);
            assertEquals(i, numberBaseConverter.getTargetBase());
        }
    }

    @Test
    @DisplayName("Set invalid target base")
    void setInvalidTargetBase() {
        for (int i = -10; i < 2; i++) {
            final int finalI = i;
            assertThrows(
                    IllegalArgumentException.class,
                    () -> numberBaseConverter.setTargetBase(finalI)
            );
        }

        assertThrows(IllegalArgumentException.class, () -> numberBaseConverter.setTargetBase(37));
    }

    @Test
    @DisplayName("Get scale")
    void getScale() {
        assertEquals(5, numberBaseConverter.getScale());
    }

    @Test
    @DisplayName("Set scale")
    void setScale() {
        for (int i = 0; i < 100; i++) {
            numberBaseConverter.setScale(i);
            assertEquals(i, numberBaseConverter.getScale());
        }
    }

    @Test
    @DisplayName("Set invalid scale")
    void setInvalidScale() {
        for (int i = -100; i < 0; i++) {
            final int finalI = i;
            assertThrows(
                    IllegalArgumentException.class,
                    () -> numberBaseConverter.setScale(finalI)
            );
        }
    }

    @Test
    @DisplayName("Convert number")
    void convertNumber() {
        assertEquals("123", numberBaseConverter.convertNumber("7b"));
        assertEquals("123", numberBaseConverter.convertNumber("+7b"));
        assertEquals("123", numberBaseConverter.convertNumber("07b"));
        assertEquals("123", numberBaseConverter.convertNumber("7b."));
        assertEquals("123.00000", numberBaseConverter.convertNumber("7b.000"));
        assertEquals("123.75000", numberBaseConverter.convertNumber("7b.c"));
        assertEquals("123.75000", numberBaseConverter.convertNumber("7b.c0"));
        assertEquals("123.12298", numberBaseConverter.convertNumber("7b.1f7c"));
        assertEquals("123.12298", numberBaseConverter.convertNumber("7B.1F7C"));
        assertEquals("123.12298", numberBaseConverter.convertNumber("7B.1f7C"));
        assertEquals("-123.12298", numberBaseConverter.convertNumber("-7b.1f7c"));

        numberBaseConverter.setSourceBase(10);
        numberBaseConverter.setTargetBase(16);
        assertEquals("7b.c0000", numberBaseConverter.convertNumber("123.75"));
        assertEquals("7b.1f7b9", numberBaseConverter.convertNumber("123.12298"));

        numberBaseConverter.setSourceBase(35);
        numberBaseConverter.setTargetBase(17);
        assertEquals("148.g88a8", numberBaseConverter.convertNumber("af.xy"));
        //noinspection SpellCheckingInspection
        assertEquals("54e36.00000", numberBaseConverter.convertNumber("aaaa.0"));

        numberBaseConverter.setSourceBase(10);
        numberBaseConverter.setTargetBase(10);
        assertEquals("123.12345", numberBaseConverter.convertNumber("123.123456"));
        assertEquals("123.12345", numberBaseConverter.convertNumber("123.123455"));
        assertEquals("123.12345", numberBaseConverter.convertNumber("123.123454"));

        numberBaseConverter.setTargetBase(2);
        numberBaseConverter.setScale(10);
        assertEquals("1111011.0001100110", numberBaseConverter.convertNumber("123.1"));
        assertEquals("-1111011.0001100110", numberBaseConverter.convertNumber("-123.1"));

        numberBaseConverter.setScale(20);
        assertEquals(
                "110110110100110110100101111100000010100101111101010110001.00011111100110101101",
                numberBaseConverter.convertNumber("123456789987654321.123456789987654321")
        );
    }

    @Test
    @DisplayName("Convert invalid number")
    void convertInvalidNumber() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> numberBaseConverter.convertNumber(null));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber(""));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("1,2"));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("."));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("1?"));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber(".1"));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("--1"));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("1.2.3"));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("-1.-2"));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("1..2"));
        assertThrows(NumberFormatException.class, () -> numberBaseConverter.convertNumber("x.y"));
    }

    @Test
    @DisplayName("Run dialog")
    void runDialog() {
        final Scanner scanner = new Scanner("10 10\n1.23\n/back\n10 2\n5\n/back\n/exit");
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String expectedOutput = String.format(
                "Enter two numbers in format: {source base} {target base} (To quit type /exit)%n" +
                "Enter number in base 10 to convert to base 10 (To go back type /back)%n" +
                "Conversion result: 1.23000%n" +
                "Enter number in base 10 to convert to base 10 (To go back type /back)%n" +
                "Enter two numbers in format: {source base} {target base} (To quit type /exit)%n" +
                "Enter number in base 10 to convert to base 2 (To go back type /back)%n" +
                "Conversion result: 101%n" +
                "Enter number in base 10 to convert to base 2 (To go back type /back)%n" +
                "Enter two numbers in format: {source base} {target base} (To quit type /exit)%n"
        );

        numberBaseConverter.runDialog(scanner);
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("Run invalid dialog")
    void runInvalidDialog() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> numberBaseConverter.runDialog(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> numberBaseConverter.runDialog(new Scanner("10 a"))
        );
        assertThrows(
                NumberFormatException.class,
                () -> numberBaseConverter.runDialog(new Scanner("10 10\na"))
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> numberBaseConverter.runDialog(new Scanner("10 10\n1.23\n/exit"))
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> numberBaseConverter.runDialog(new Scanner("10 a\n1.23\n/back\n/back"))
        );
    }

}
