package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {

    @Mock
    private EmployeeRepository employeeRepositoryMock;
    @Mock
    private BankService bankServiceMock;

    private BankService bankService;
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        bankService = new BankServiceStub();
        employeeRepository = new EmployeeRepositoryStub();
    }

    @Test
    @DisplayName("should return successful when correct amount of payments")
    void shouldReturnSuccessfulWhenCorrectAmountOfPayments() {
        Employees employees = new Employees(employeeRepository, bankService);
        int payment = employees.payEmployees();
        assertEquals(3, payment);
    }

    @Test
    @DisplayName("should return unsuccessful when there are Zero employees")
    void shouldReturnUnsuccessfulWhenThereAreZeroEmployees() {
        MockitoAnnotations.openMocks(this);
        Employees employees = new Employees(employeeRepositoryMock, bankServiceMock);
        Mockito.when(employeeRepositoryMock.findAll()).thenReturn(Collections.emptyList());
        int payment = employees.payEmployees();
        assertEquals(0, payment);
    }
}
