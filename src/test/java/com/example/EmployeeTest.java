package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp(){
        employee = new Employee("142",35000);
    }

    @Test
    @DisplayName("true if id matches Employee id")
    void trueIfIdMatchesEmployeeId() {
        String id = employee.getId();
        assertEquals("142", id);
    }

    @Test
    @DisplayName("true if salary matches Employee salary")
    void trueIfSalaryMatchesEmployeeSalary() {
        double salary = employee.getSalary();
        assertEquals(35000, salary);
    }

    @Test
    @DisplayName("true if new id does not match with old id value")
    void trueIfNewIdDoesNotMatchWithOldIdValue() {
        String oldId = employee.getId();
        employee.setId("105");
        String newId = employee.getId();
        assertNotEquals(newId, oldId);
    }

    @Test
    @DisplayName("true if new salary does not match with old salary")
    void trueIfNewSalaryDoesNotMatchWithOldSalary() {
        double oldSalary = employee.getSalary();
        employee.setSalary(36000);
        double newSalary = employee.getSalary();
        assertNotEquals(newSalary, oldSalary);
    }

    @Test
    @DisplayName("true if employee has been paid")
    void trueIfEmployeeHasBeenPaid() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    @DisplayName("true if employee has not been paid")
    void trueIfEmployeeHasNotBeenPaid() {
        employee.setPaid(false);
        assertFalse(employee.isPaid());
    }

    @Test
    @DisplayName("true if string matches employee")
    void trueIfStringMatchesEmployee() {
        Employee employee1 = new Employee("192", 33000);
        String expectedString = "Employee [id=192, salary=33000.0]";
        assertEquals(expectedString, employee1.toString());
    }
}