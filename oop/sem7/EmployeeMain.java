package oop.sem7;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Black", "HR", 6000);
        Employee e2 = new Employee("Alex", "Fox", "Finance", 9000);
        Employee e3 = new Employee("Rick", "Roll", "Sales", 7000);

        System.out.println("e1: " + e1 + "\ne2: " + e2 + "\ncomparison result:" + e1.equals(e2) + "\n");
        System.out.println("e2: " + e2 + "\ne3: " + e3 + "\ncomparison result:" + e2.equals(e3) + "\n");

        System.out.println(e1.hashCode() == e2.hashCode());
        System.out.println(e2.hashCode() == e3.hashCode());
    }
}