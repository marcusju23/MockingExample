package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {

    private BankService bankService;
    private EmployeeRepository employeeRepository;
    private Employees employees;

    @BeforeEach
    void setUp(){
        bankService = new BankServiceStub();
        employeeRepository = new EmployeeRepositoryStub();
        employees = new Employees(employeeRepository, bankService);
    }

    @Test
    @DisplayName("should return successful when correct amount of payments")
    void shouldReturnSuccessfulWhenCorrectAmountOfPayments() {
        int payment = employees.payEmployees();
        assertEquals(3, payment);
    }
}
