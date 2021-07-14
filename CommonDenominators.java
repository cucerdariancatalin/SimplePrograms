public class CommonDenominators {
    public static void main(String[] args) {
        long[][] listOfFractions = {{1, 2}, {2, 3}, {3, 4}, {1, 6}};

        CommonDenominators cd = new CommonDenominators();
        long leastCommonMultiple = cd.findLeastCommonMultipleForDenominators(listOfFractions);
        System.out.println("Least common multiple for the denominators of fractions: " + leastCommonMultiple);

        String output = cd.getCommonDenominators(leastCommonMultiple, listOfFractions);
        System.out.println("Fractions with a common denominator: " + output);
    }

    public long[][] reduceFractions(long[][] listOfFracts) { //TODO


        return listOfFracts;
    }

    public long findLeastCommonMultipleForDenominators(long[][] listOfFractions) {
        long oldLeastCommonMultiple = 1L, newLeastCommonMultiple = 1L, counter = 2L;

        for (long[] array : listOfFractions) {
            while (newLeastCommonMultiple % array[1] != 0) {
                newLeastCommonMultiple = oldLeastCommonMultiple;
                newLeastCommonMultiple *= counter;
                counter++;
            }
            oldLeastCommonMultiple = newLeastCommonMultiple;
            counter = 2L;
        }

        return oldLeastCommonMultiple;
    }

    public String getCommonDenominators(long leastCommonMultipleForDenominators,
                                        long[][] listOfFractions) {
        String formattedOutput = "";

        for (long[] array : listOfFractions) {
            long numerator = array[0] * leastCommonMultipleForDenominators / array[1];
            long denominator = leastCommonMultipleForDenominators;
            formattedOutput += "(" + numerator + "," + denominator + ")";
        }

        return formattedOutput;
    }
}