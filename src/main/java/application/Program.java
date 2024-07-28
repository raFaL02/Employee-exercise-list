package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        int numberOfEmployes;

        System.out.print("How many employees will be registered? ");
        numberOfEmployes = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < numberOfEmployes; i++) {
            System.out.println("Employee #" + (i + 1) + ":");

            System.out.print("Id: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee employee = findEmployeeById(employees, id);
        if (employee != null) {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            employee.increaseSalary(percentage);
        } else {
            System.out.println("This id does not exist!");
        }

        System.out.println("List of employees:");
        for (Employee emp : employees){
            System.out.println(emp);
        }

        sc.close();
    }

    private static Employee findEmployeeById(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }
}
