package com.simpleprograms;

/**
 * The program to compare two boxes.
 *
 * @author VitasSalvantes
 * @version 2.0
 */
public class BoxComparator {

    /**
     * The method checks the boxes can be nested within each other.
     *
     * @param box1 the box to be compared with box2. It must have 3 elements: width, length and height.
     * @param box2 the box to be compared with box1. It must have 3 elements: width, length and height.
     * @return the "Box 1 > Box 2" string if the second box can be nested within the box1;
     * the "Box 1 < Box 2" string if the box1 can be nested within the second box;
     * the "Incompatible" string if the boxes can not be nested within each other.
     */
    public String checkNestable(int[] box1,
                                int[] box2) {

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
     * The method launches the program.
     */
    public static void main(String[] args) {
        final var comparator = new BoxComparator();

        System.out.println(comparator.checkNestable(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        System.out.println(comparator.checkNestable(new int[]{1, 2, 3}, new int[]{4, 6, 5}));
        System.out.println(comparator.checkNestable(new int[]{4, 6, 5}, new int[]{1, 2, 3}));
        System.out.println(comparator.checkNestable(new int[]{3, 2, 1}, new int[]{4, 2, 8}));
        System.out.println(comparator.checkNestable(new int[]{8, 2, 4}, new int[]{2, 9, 1}));

    }
}
