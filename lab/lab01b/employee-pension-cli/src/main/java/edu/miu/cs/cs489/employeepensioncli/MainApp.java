package edu.miu.cs.cs489.employeepensioncli;

import edu.miu.cs.cs489.employeepensioncli.model.*;
import edu.miu.cs.cs489.employeepensioncli.service.EmployeeService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeService.loadEmployees();

        System.out.println("\n--- All Employees (JSON) ---");
        System.out.println(EmployeeService.printAllEmployees(employees));

        System.out.println("\n--- Quarterly Upcoming Enrollees (JSON) ---");
        System.out.println(EmployeeService.printUpcomingEnrollees(employees));
    }
}