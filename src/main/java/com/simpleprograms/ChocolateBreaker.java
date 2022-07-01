/**
 * MIT License
 * <p>
 * Copyright (c) 2021 VitasSalvantes
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.simpleprograms;

import java.util.Scanner;

/**
 * The program to find out whether it is possible to break off exactly the number of segments from the chocolate bar.
 *
 * @author VitasSalvantes
 * @version 2.0.0
 */
public class ChocolateBreaker {

    /**
     * The length of the chocolate bar. It must be greater than 0.
     */
    private int chocolateLength;

    /**
     * The width of the chocolate bar. It must be greater than 0.
     */
    private int chocolateWidth;

    /**
     * The constructor sets default values of the {@link #chocolateLength} and the {@link #chocolateWidth}.
     *
     * @param chocolateLength a new value of the {@link #chocolateLength}. It must be greater than 0.
     * @param chocolateWidth  a new value of the {@link #chocolateWidth}. It must be greater than 0.
     */
    public ChocolateBreaker(final int chocolateLength, final int chocolateWidth) {
        validateChocolateSize(chocolateLength, chocolateWidth);

        this.chocolateLength = chocolateLength;
        this.chocolateWidth = chocolateWidth;
    }

    /**
     * The getter for the {@link #chocolateLength}.
     *
     * @return the {@link #chocolateLength}.
     */
    public int getChocolateLength() {
        return this.chocolateLength;
    }

    /**
     * The setter for the {@link #chocolateLength}.
     *
     * @param chocolateLength a new value of the {@link #chocolateLength}. It must be greater than 0.
     */
    public void setChocolateLength(final int chocolateLength) {
        validateChocolateSize(chocolateLength, 1);

        this.chocolateLength = chocolateLength;
    }

    /**
     * The getter for the {@link #chocolateWidth}.
     *
     * @return the {@link #chocolateWidth}.
     */
    public int getChocolateWidth() {
        return this.chocolateWidth;
    }

    /**
     * The setter for the {@link #chocolateWidth}.
     *
     * @param chocolateWidth a new value of the {@link #chocolateWidth}. It must be greater than 0.
     */
    public void setChocolateWidth(final int chocolateWidth) {
        validateChocolateSize(1, chocolateWidth);

        this.chocolateWidth = chocolateWidth;
    }

    /**
     * Validates new values of the {@link #chocolateLength} and the {@link #chocolateWidth}.
     *
     * @param chocolateLength a new value of the {@link #chocolateLength} to be checked.
     * @param chocolateWidth  a new value of the {@link #chocolateWidth} to be checked.
     * @throws IllegalArgumentException if at least one of the values is less than 1.
     */
    private void validateChocolateSize(final int chocolateLength, final int chocolateWidth) throws IllegalArgumentException {
        if (chocolateLength < 1 || chocolateWidth < 1) {
            throw new IllegalArgumentException("The values must be greater than 0!");
        }
    }

    /**
     * Prints "YES" if it is possible to break off exactly the number of segments from the chocolate with
     * a single straight line: vertical or horizontal, and "NO" otherwise.
     *
     * @param segmentsNumber the number of the segments.
     */
    public void checkBreakPossibility(final int segmentsNumber) {
        validateChocolateSize(1, segmentsNumber);

        // The number of the segments is not greater than the number of the segments in the chocolate bar
        boolean hasSuitableSize = segmentsNumber <= this.chocolateLength * this.chocolateWidth;

        // It could be broken off as a single straight line
        boolean isDivider = segmentsNumber % this.chocolateLength == 0 || segmentsNumber % this.chocolateWidth == 0;

        if (hasSuitableSize && isDivider) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var breaker = new ChocolateBreaker(scanner.nextInt(), scanner.nextInt());
        System.out.printf("Length: %d%n", breaker.getChocolateLength());
        System.out.printf("Width: %d%n", breaker.getChocolateWidth());
        System.out.println();

        breaker.checkBreakPossibility(scanner.nextInt());

        System.out.println();
        breaker.setChocolateLength(12);
        breaker.setChocolateWidth(24);
        System.out.printf("Length: %d%n", breaker.getChocolateLength());
        System.out.printf("Width: %d%n", breaker.getChocolateWidth());
        System.out.println();

        breaker.checkBreakPossibility(6);
    }
}
