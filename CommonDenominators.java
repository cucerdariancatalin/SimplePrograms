public class CommonDenominators {
    public static void main(String[] args) {
        CommonDenominators cd = new CommonDenominators();
        long[][] listOfFractions = {{10, 20}, {200, 300}, {3, 4}, {1, 6}};

        listOfFractions = cd.reduceFractions(listOfFractions);

        long leastCommonMultiple = cd.findLeastCommonMultipleForDenominators(listOfFractions);
        System.out.println("Least common multiple for the denominators of fractions: " + leastCommonMultiple);

        String output = cd.getCommonDenominators(leastCommonMultiple, listOfFractions);
        System.out.println("Fractions with a common denominator: " + output);
    }

    public long[][] reduceFractions(long[][] listOfFractions) {
        for (long[] fraction : listOfFractions) {
            while (fraction[0] % 10 == 0 && fraction[1] % 10 == 0) {
                fraction[0] /= 10;
                fraction[1] /= 10;
            }
        }

        return listOfFractions;
    }

    public long findLeastCommonMultipleForDenominators(long[][] listOfFractions) {
        long oldLeastCommonMultiple = 1L, newLeastCommonMultiple = 1L, counter = 2L;

        for (long[] fraction : listOfFractions) {
            while (newLeastCommonMultiple % fraction[1] != 0) {
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

        for (long[] fraction : listOfFractions) {
            long numerator = fraction[0] * leastCommonMultipleForDenominators / fraction[1];
            long denominator = leastCommonMultipleForDenominators;
            formattedOutput += "(" + numerator + "," + denominator + ")";
        }

        return formattedOutput;
    }
}