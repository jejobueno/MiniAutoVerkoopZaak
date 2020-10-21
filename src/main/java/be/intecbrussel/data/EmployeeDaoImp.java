package be.intecbrussel.data;

import be.intecbrussel.entities.Customer;
import be.intecbrussel.entities.Employee;

import javax.persistence.*;
import java.util.stream.Stream;

public class EmployeeDaoImp implements EmployeeDao {

    @Override
    public void createEmployee(Employee employee) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(employee);
            transaction.commit();

            System.out.println(employee + " saved");

        } catch (PersistenceException pex){
            pex.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
            if (emf != null){
                emf.close();
            }

        }
    }

    @Override
    public Employee readEmployee(String employeeName) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Employee employeeToRead = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            Query query = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE ?1");
            query.setParameter(1, employeeName);
            Stream<Employee> results = query.getResultStream();
            employeeToRead = results.findFirst().get();
            transaction.commit();

            System.out.println(employeeToRead + " readed");

        } catch (PersistenceException pex){
            pex.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
            if (emf != null){
                emf.close();
            }
        }
        return employeeToRead;
    }

    @Override
    public Employee readEmployee(int employeeNumber) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Employee employeeToRead = new Employee();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            employeeToRead = em.find(Employee.class,employeeNumber);
            transaction.commit();

            System.out.println(employeeToRead + " readed");

        } catch (PersistenceException pex){
            pex.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
            if (emf != null){
                emf.close();
            }
        }
        return employeeToRead;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Employee employeeToUpdate = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            employeeToUpdate = em.find(Employee.class,employee.getEmployeeNumber());
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setFirstName(employee.getFirstName());
            employeeToUpdate.setExtension(employee.getExtension());
            employeeToUpdate.setEmail(employee.getEmail());
            employeeToUpdate.setOfficeCode(employee.getOfficeCode());
            employeeToUpdate.setReportsTo(employee.getReportsTo());
            employeeToUpdate.setJobTitle(employee.getJobTitle());
            transaction.commit();

            System.out.println(employeeToUpdate + " updated");

        } catch (PersistenceException pex){
            pex.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
            if (emf != null){
                emf.close();
            }
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            Employee employeeToDelete = em.find(Employee.class,employee.getEmployeeNumber());
            em.remove(employeeToDelete);
            transaction.commit();

            System.out.println(employeeToDelete + " deleted");

        } catch (PersistenceException pex){
            pex.printStackTrace();
        } finally {
            if (em != null){
                em.close();
            }
            if (emf != null){
                emf.close();
            }
        }
    }
}
