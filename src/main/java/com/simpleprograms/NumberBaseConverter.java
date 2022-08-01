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

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * The program converts a number from one base to another.
 *
 * @author Ivan Bobrov
 * @version 1.4.4
 */
public class NumberBaseConverter {

    /**
     * The number base to convert the number from. It must be greater than 1 and less than 37.
     */
    private int sourceBase;

    /**
     * The number base to convert the number to. It must be greater than 1 and less than 37.
     */
    private int targetBase;

    /**
     * The length of the fractional part of the converted number. For example, <b>3</b> is the scale of the number <b>1.234</b>.<br>
     * It must be a positive integer.
     */
    private int scale;

    /**
     * The constructor sets the {@link #sourceBase} and {@link #targetBase}.
     *
     * @param sourceBase a default value of the {@link #sourceBase}.
     * @param targetBase a default value of the {@link #targetBase}.
     * @param scale      a default value of the {@link #scale}.
     * @see #validateBase(int)
     * @see #validateScale(int)
     */
    public NumberBaseConverter(final int sourceBase, final int targetBase, final int scale) {
        validateBase(sourceBase);
        validateBase(targetBase);
        validateScale(scale);

        this.sourceBase = sourceBase;
        this.targetBase = targetBase;
        this.scale = scale;
    }

    /**
     * The getter for the {@link #sourceBase}.
     *
     * @return {@link #sourceBase}.
     */
    public int getSourceBase() {
        return this.sourceBase;
    }

    /**
     * The setter for the {@link #sourceBase}.
     *
     * @param sourceBase a new value of the {@link #sourceBase}.
     * @see #validateBase(int)
     */
    public void setSourceBase(final int sourceBase) {
        validateBase(sourceBase);

        this.sourceBase = sourceBase;
    }

    /**
     * The getter for the {@link #targetBase}.
     *
     * @return the {@link #targetBase}.
     */
    public int getTargetBase() {
        return this.targetBase;
    }

    /**
     * The setter for the {@link #targetBase}.
     *
     * @param targetBase a new value of the {@link #targetBase}.
     * @see #validateBase(int)
     */
    public void setTargetBase(final int targetBase) {
        validateBase(targetBase);

        this.targetBase = targetBase;
    }

    /**
     * The getter for the {@link #sourceBase}.
     *
     * @return the {@link #sourceBase}.
     */
    public int getScale() {
        return this.scale;
    }

    /**
     * The setter for the {@link #scale}.
     *
     * @param scale a new value of the {@link #scale}.
     * @see #validateScale(int)
     */
    public void setScale(final int scale) {
        validateScale(scale);

        this.scale = scale;
    }

    /**
     * Validates a base. The value must be greater than 1 and less than 36.
     *
     * @param base the value to be validated.
     */
    private void validateBase(final int base) {
        if (base < Character.MIN_RADIX || base > Character.MAX_RADIX) {
            throw new IllegalArgumentException("The base must be greater than 1 and less than 37");
        }
    }

    /**
     * Validates a new value of the {@link #scale}. It must be a positive integer.
     *
     * @param scale the value to be validated.
     */
    private void validateScale(final int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be positive");
        }
    }

    /**
     * Converts a number from the {@link #sourceBase} to the {@link #targetBase}.
     *
     * @param number a string representation of the number to be converted.
     * @return a string representation of the converted number. The form is "1.00" (in this case, the scale is 2).
     */
    public @NotNull String convertNumber(final @NotNull String number) {
        validateNumber(number);

        final String[] numberParts = number.split("\\.");
        final String convertedIntegerPart = convertIntegerPartToTargetBase(numberParts[0]);

        if (scale == 0 || numberParts.length == 1) {
            return convertedIntegerPart;
        } else {
            final String convertedFractionalPart = numberParts[1].matches("0+")
                    ? "0".repeat(scale)
                    : convertFractionalPartToTargetBase(numberParts[1]);

            return convertedIntegerPart + "." + convertedFractionalPart;
        }
    }

    /**
     * Validates an input string representation of the number.
     *
     * @param number the string representation of the number to be validated.
     */
    private void validateNumber(final String number) {
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null");
        }

        if (number.isEmpty()) {
            throw new IllegalArgumentException("The number must not be an empty string");
        }

        if (number.contains(",")) {
            throw new IllegalArgumentException("Please use \".\" instead of \",\"");
        }

        if (!number.matches("[-+]?[0-9a-zA-Z]+[.]?[0-9a-zA-Z]*")) {
            throw new IllegalArgumentException("The format of the number is wrong");
        }
    }

    /**
     * Converts the integer part of the number from the {@link #sourceBase} to the {@link #targetBase}.<br>
     * The integer part of the number is all the digits until the point. For example, <b>1</b> is the integer part of the number <b>1.234</b>.<br>
     * The algorithm is:
     * <ol>
     *     <li>Convert the integer part of the number from the {@link #sourceBase} to the decimal.</li>
     *     <li>Convert the integer part of the number from the decimal to the {@link #targetBase}.</li>
     * </ol>
     *
     * @param integerPart the integer part of the number.
     * @return a string that represents the converted integer part of the number.
     * @see #convertIntegerPartToDecimal(String)
     */
    private @NotNull String convertIntegerPartToTargetBase(final @NotNull String integerPart) {
        return convertIntegerPartToDecimal(integerPart).toString(targetBase);
    }

    /**
     * Converts the integer part of the number from the {@link #sourceBase} to the decimal.
     *
     * @param integerPart the integer part of the number to be converted.
     * @return the converted integer part of the number.
     */
    private @NotNull BigInteger convertIntegerPartToDecimal(final @NotNull String integerPart) {
        return new BigInteger(integerPart, sourceBase);
    }

    /**
     * Converts the fractional part of the number from the {@link #sourceBase} to the {@link #targetBase}.<br>
     * The fractional part of the number is all the digits after the point. For example, <b>234</b> is the fractional part of the number <b>1.234</b>.<br>
     * The algorithm is:
     *  <ol>
     *      <li>Convert the fractional part of the number from the {@link #sourceBase} to the decimal.</li>
     *      <li>Convert the fractional part of the number from the decimal to the {@link #targetBase}.</li>
     * </ol>
     * It rounds down the converted fractional part using the {@link #scale}.
     *
     * @param fractionalPart the fractional part of the number to be converted.
     * @return a string that represents the converted fractional part of the number.
     * @see #convertFractionalPartToDecimal(String)
     */
    private @NotNull String convertFractionalPartToTargetBase(final @NotNull String fractionalPart) {
        BigDecimal fractionalPartInDecimal = (sourceBase == 10)
                ? new BigDecimal("0." + fractionalPart)
                : convertFractionalPartToDecimal(fractionalPart);

        final StringBuilder convertedFractionalPart = new StringBuilder();
        final BigDecimal targetBase = BigDecimal.valueOf(this.targetBase);
        BigDecimal product;

        for (int i = 0; i < this.scale; i++) {
            product = fractionalPartInDecimal.multiply(targetBase);
            convertedFractionalPart.append(product.toBigInteger().toString(this.targetBase));
            fractionalPartInDecimal = product.remainder(BigDecimal.ONE);
        }

        return convertedFractionalPart.toString();
    }

    /**
     * Converts the fractional part of the number from the {@link #sourceBase} to the decimal.
     *
     * @param fractionalPart the fractional part of the number to be converted.
     * @return a BigDecimal representation of the converted fractional part of the number.
     */
    private @NotNull BigDecimal convertFractionalPartToDecimal(final @NotNull String fractionalPart) {
        BigDecimal fractionalPartInDecimal = BigDecimal.ZERO;

        for (int i = 0; i < fractionalPart.length(); i++) {
            final BigDecimal positionPower = BigDecimal.valueOf(Math.pow(sourceBase, -(i + 1)));
            final char digitInSourceBase = fractionalPart.charAt(i);
            final BigDecimal digitInDecimal = new BigDecimal(new BigInteger(String.valueOf(digitInSourceBase), sourceBase));

            fractionalPartInDecimal = fractionalPartInDecimal.add(digitInDecimal.multiply(positionPower));
        }

        return fractionalPartInDecimal;
    }

    /**
     * Runs the interaction with the user.
     *
     * @param scanner the {@link java.util.Scanner} object to get the input data from the user.
     */
    public void runDialog(final @NotNull Scanner scanner) {
        validateScanner(scanner);

        while (true) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            final String inputBases = scanner.nextLine().toLowerCase();

            if ("/exit".equals(inputBases)) {
                break;
            }

            validateInputBases(inputBases);

            final String[] bases = inputBases.split(" ");
            setSourceBase(Integer.parseInt(bases[0]));
            setTargetBase(Integer.parseInt(bases[1]));

            while (true) {
                System.out.printf("Enter number in base %d to convert to base %d (To go back type /back)%n", sourceBase, targetBase);
                final String inputNumber = scanner.nextLine().toLowerCase();

                if ("/back".equals(inputNumber)) {
                    break;
                } else {
                    System.out.printf("Conversion result: %s%n", convertNumber(inputNumber));
                }
            }
        }
    }

    /**
     * Validates a scanner object.
     *
     * @param scanner the scanner object to be validated.
     */
    private void validateScanner(final Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("The scanner must not be null");
        }
    }

    /**
     * Validates a string representation of the input bases.
     *
     * @param inputBases the string representation of the input bases to be validated.
     */
    private void validateInputBases(final String inputBases) {
        if (inputBases == null) {
            throw new IllegalArgumentException("The input bases must not be null");
        }

        if (!inputBases.matches("\\d\\d? \\d\\d?")) {
            throw new IllegalArgumentException("Wrong input bases format");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final NumberBaseConverter converter = new NumberBaseConverter(10, 10, 5);

        converter.runDialog(new Scanner(System.in));
    }
}
