package be.intecbrussel.testapps;

import be.intecbrussel.data.EmployeeDaoImp;
import be.intecbrussel.entities.Employee;
import be.intecbrussel.entities.Office;
import be.intecbrussel.enums.JobTitle;

public class testEmployee {

    public static void main(String[] args) {

        Employee employee = null;
        Employee employee2 = null;
        EmployeeDaoImp employeeApp = new EmployeeDaoImp();
        employee = employeeApp.readEmployee(1002);
        employee2 = employeeApp.readEmployee("William");
        Employee employee3 = null;
                //new Employee("Bueno", "Ana","X30000","mymail@gamil.com", employee2.getOfficeCode(),null, JobTitle.SALES_REP);
        //employeeApp.createEmployee(employee3);
        employee3 = employeeApp.readEmployee(1703);
        //employee3.setFirstName("Another Name");
        //employeeApp.updateEmployee(employee3);

        employeeApp.deleteEmployee(employee3);
    }
}
