package be.intecbrussel.data;

import be.intecbrussel.entities.Employee;

public interface EmployeeDao {

    void createEmployee(Employee employee);
    Employee readEmployee(String employeeName);
    Employee readEmployee(int employeeNumber);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
