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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the {@link Cinema}.
 *
 * @author VitasSalvantes
 * @version 1.0.0
 */
class CinemaTest {

    private Cinema cinema;
    private int[][] testSeats;
    private int ticketsNumber;

    @BeforeEach
    void setUp() {
        testSeats = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        cinema = new Cinema(testSeats);
        ticketsNumber = 2;
    }

    @Test
    @DisplayName("Seats getter")
    void getSeats() {
        for (int i = 0; i < testSeats.length; i++) {
            assertEquals(testSeats[i], cinema.getSeats()[i]);
        }
    }

    @Test
    @DisplayName("Find consecutive available seats")
    void findConsecutiveAvailableSeats() {
        assertEquals(2, cinema.findConsecutiveAvailableSeats(ticketsNumber));

        testSeats = new int[][]{
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        cinema = new Cinema(testSeats);
        assertEquals(1, cinema.findConsecutiveAvailableSeats(ticketsNumber));

        testSeats = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 0, 1}
        };
        cinema = new Cinema(testSeats);
        assertEquals(4, cinema.findConsecutiveAvailableSeats(ticketsNumber));

        testSeats = new int[][]{
                {1, 1, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 1}
        };
        cinema = new Cinema(testSeats);
        ticketsNumber = 3;
        assertEquals(4, cinema.findConsecutiveAvailableSeats(ticketsNumber));
    }

    @Test
    @DisplayName("Test null")
    void testNull() {
        assertThrows(IllegalArgumentException.class, () -> cinema = new Cinema(null));

        testSeats = new int[][]{null};
        assertThrows(IllegalArgumentException.class, () -> cinema = new Cinema(null));
    }

    @Test
    @DisplayName("Test the seats array contains not 0 and 1")
    void testWrongValues() {
        testSeats = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThrows(IllegalArgumentException.class, () -> cinema = new Cinema(testSeats));
    }

    @Test
    @DisplayName("Test \"bad\" arrays")
    void testBadArrays() {
        testSeats = new int[][]{
                {1, 1},
                {1, 1},
                {1, 0},
                {0, 1}
        };
        cinema = new Cinema(testSeats);
        assertEquals(0, cinema.findConsecutiveAvailableSeats(ticketsNumber));

        testSeats = new int[][]{
                {1},
                {1},
                {0},
                {0}
        };
        cinema = new Cinema(testSeats);
        assertEquals(0, cinema.findConsecutiveAvailableSeats(ticketsNumber));

        testSeats = new int[][]{
                {},
                {},
                {},
                {}
        };
        cinema = new Cinema(testSeats);
        assertEquals(0, cinema.findConsecutiveAvailableSeats(ticketsNumber));

        testSeats = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1, 1}
        };
        cinema = new Cinema(testSeats);
        assertEquals(2, cinema.findConsecutiveAvailableSeats(ticketsNumber));
    }
}