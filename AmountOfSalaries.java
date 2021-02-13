/**
 * Class-example of interaction of two objects
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class AmountOfSalaries {

    /** Method that launches the program */
    public static void main(String[] args) {

        AmountOfSalaries aos = new AmountOfSalaries();

        // James
        AmountOfSalaries.Worker worker1 = aos.new Worker();
        worker1.setName("James");
        worker1.setSalary(200000);

        // Tom
        AmountOfSalaries.Worker worker2 = aos.new Worker();
        worker2.setName("Tom");
        worker2.setSalary(150000);

        System.out.println("Amount of salaries: " + CalculateTotalSalary(worker1.getSalary(), worker2.getSalary()));
    }

    /**
     * Static method summing the salaries of two workers
     * 
     * @param s1 {@link Worker#salary}
     * @param s2 {@link Worker#salary}
     */
    static int CalculateTotalSalary(int s1, int s2) {
        return s1 + s2;
    }

    /** Internal class describing workers */
    class Worker {

        /** Worker name */
        private String name;

        /** Worker salary */
        private int salary;

        /** Setter for worker name */
        public void setName(String name) {
            this.name = name;
        }

        /** Setter for worker salary */
        public void setSalary(int salary) {
            this.salary = salary;
        }

        /** Getter for worker salary */
        public int getSalary() {
            return salary;
        }
    }

}
