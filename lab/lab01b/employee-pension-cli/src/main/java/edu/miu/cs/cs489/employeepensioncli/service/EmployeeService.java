package edu.miu.cs.cs489.employeepensioncli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.miu.cs.cs489.employeepensioncli.model.Employee;
import edu.miu.cs.cs489.employeepensioncli.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    public static List<Employee> loadEmployees() {
        List<Employee> list = new ArrayList<>();

        Employee e1 = new Employee(1, "Daniel", "Agar", LocalDate.parse("2018-01-17"), 105945.50);
        e1.setPensionPlan(new PensionPlan("EX1089", LocalDate.parse("2023-01-17"), 100.00));

        Employee e2 = new Employee(2, "Benard", "Shaw", LocalDate.parse("2022-09-03"), 197750.00);
        Employee e3 = new Employee(3, "Carly", "Agar", LocalDate.parse("2014-05-16"), 842000.75);
        e3.setPensionPlan(new PensionPlan("SM2307", LocalDate.parse("2019-11-04"), 1555.50));

        Employee e4 = new Employee(4, "Wesley", "Schneider", LocalDate.parse("2022-07-21"), 74500.00);
        Employee e5 = new Employee(5, "Anna", "Wiltord", LocalDate.parse("2022-06-15"), 85750.00);
        Employee e6 = new Employee(6, "Yosef", "Tesfalem", LocalDate.parse("2022-10-31"), 100000.00);

        list.add(e1); list.add(e2); list.add(e3); list.add(e4); list.add(e5); list.add(e6);
        return list;
    }

    public static String printAllEmployees(List<Employee> employees) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            return writer.writeValueAsString(
                    employees.stream()
                            .sorted(Comparator.comparing(Employee::getYearlySalary).reversed()
                                    .thenComparing(Employee::getLastName))
                            .collect(Collectors.toList())
            );
        } catch (Exception e) {
            return "Error generating JSON: " + e.getMessage();
        }
    }

    public static String printUpcomingEnrollees(List<Employee> employees) {
        try {
            LocalDate today = LocalDate.now();
            int nextQuarterStartMonth = ((today.getMonthValue() - 1) / 3 + 1) * 3 + 1;
            int year = today.getYear() + (nextQuarterStartMonth > 12 ? 1 : 0);
            nextQuarterStartMonth = nextQuarterStartMonth > 12 ? 1 : nextQuarterStartMonth;

            LocalDate quarterStart = LocalDate.of(year, nextQuarterStartMonth, 1);
            LocalDate quarterEnd = quarterStart.plusMonths(2).withDayOfMonth(
                    quarterStart.plusMonths(2).lengthOfMonth());

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            List<Employee> filtered = employees.stream()
                    .filter(e -> e.getPensionPlan() == null)
                    .filter(e -> {
                        LocalDate eligibleDate = e.getEmploymentDate().plusYears(3);
                        return !eligibleDate.isBefore(quarterStart) && !eligibleDate.isAfter(quarterEnd);
                    })
                    .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                    .collect(Collectors.toList());

            return writer.writeValueAsString(filtered);

        } catch (Exception e) {
            return "Error generating JSON: " + e.getMessage();
        }
    }

}
