package com.example;

import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {

    @Override
    public List<Employee> findAll() {
        Employee employee1 = new Employee("222", 29500);
        Employee employee2 = new Employee("157", 33000);
        Employee employee3 = new Employee("105", 35000);

        return Arrays.asList(employee1, employee2, employee3);
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}