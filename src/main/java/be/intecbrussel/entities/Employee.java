package be.intecbrussel.entities;

import be.intecbrussel.enums.JobTitle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office officeCode;
    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;
    private JobTitle jobTitle;

        public Employee() {
    }

    public Employee(String lastName, String firstName, String extension, String email, Office officeCode, Employee reportsTo, JobTitle jobTitle) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getExtension() {
        return extension;
    }

    public String getEmail() {
        return email;
    }

    public Office getOfficeCode() {
        return officeCode;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOfficeCode(Office officeCode) {
        this.officeCode = officeCode;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employees = (Employee) o;
        return employeeNumber == employees.employeeNumber &&
                officeCode == employees.officeCode &&
                reportsTo == employees.reportsTo &&
                Objects.equals(lastName, employees.lastName) &&
                Objects.equals(firstName, employees.firstName) &&
                Objects.equals(extension, employees.extension) &&
                Objects.equals(email, employees.email) &&
                jobTitle == employees.jobTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", officeCode=" + officeCode +
                ", reportsTo=" + reportsTo +
                ", jobTitle=" + jobTitle +
                '}';
    }
}
