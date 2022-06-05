package com.simpleprograms;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * The program to compare two boxes.
 *
 * @author VitasSalvantes
 * @version 2.5
 */
public class BoxComparator {

    /**
     * The method checks the boxes can be nested within each other.
     *
     * @param box1 the box to be compared with box2. It must have 3 elements: width, length and height.
     * @param box2 the box to be compared with box1. It must have 3 elements: width, length and height.
     * @return the "Box 1 > Box 2" string if the second box can be nested within the box1;<br>
     * the "Box 1 < Box 2" string if the box1 can be nested within the second box;<br>
     * the "Incompatible" string if the boxes can not be nested within each other.
     */
    public static @NotNull String checkNestable(final int @NotNull [] box1, final int @NotNull [] box2) {
        validateBox(box1);
        validateBox(box2);

        Arrays.sort(box1);
        Arrays.sort(box2);

        int counterBox2Bigger = 0;
        int counterEqualBoxes = 0;

        for (int i = 0; i < box1.length; i++) {
            if (box1[i] < box2[i]) {
                counterBox2Bigger++;
            }

            if (box1[i] == box2[i]) {
                counterEqualBoxes++;
            }
        }

        if (counterBox2Bigger == 0 && counterEqualBoxes == 0) {
            return "Box 1 > Box 2";
        } else if (counterBox2Bigger == 3) {
            return "Box 1 < Box 2";
        } else {
            return "Incompatible";
        }
    }

    /**
     * Validate a box.
     *
     * @param box the box to be validated.
     * @throws IllegalArgumentException if the box is null or unsuitable.
     */
    private static void validateBox(final int[] box) {
        if (box == null) {
            throw new IllegalArgumentException("The box must not be null.");
        }

        if (box.length != 3) {
            throw new IllegalArgumentException("The box must have 3 elements: width, length and height");
        }

        for (int dimension : box) {
            if (dimension < 1) {
                throw new IllegalArgumentException("Each dimension of the box must be greater than 0.");
            }
        }
    }


    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        System.out.println(BoxComparator.checkNestable(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
    }
}
