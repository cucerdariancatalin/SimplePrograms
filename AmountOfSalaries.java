public class AmountOfSalaries {

    public static void main(String[] args) {
        // James
        Worker worker1 = new Worker();
        worker1.setName("James");
        worker1.setSalary(200000);

        // Tom
        Worker worker2 = new Worker();
        worker2.setName("Tom");
        worker2.setSalary(150000);

        System.out.println("Amount of salaries: " + CalculateTotalSalary(worker1.getSalary(), worker2.getSalary()));
    }

    static int CalculateTotalSalary(int s1, int s2) {
        return s1 + s2;
    }

}

class Worker {
    private String name;
    private int salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}