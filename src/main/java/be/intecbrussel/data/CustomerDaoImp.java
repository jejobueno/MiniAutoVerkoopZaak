package be.intecbrussel.data;

import be.intecbrussel.entities.Customer;

import javax.persistence.*;
import java.util.stream.Stream;

public class CustomerDaoImp implements CustomerDao{

    @Override
    public void createCustomer(Customer customer) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(customer);
            transaction.commit();

            System.out.println(customer + " saved");

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
    public Customer readCustomer(String customerName) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Customer customerToRead = new Customer();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.customerName LIKE ?1");
            query.setParameter(1, customerName);
            Stream<Customer> results = query.getResultStream();
            customerToRead = results.findFirst().get();
            transaction.commit();

            System.out.println(customerToRead + " readed");

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
        return customerToRead;
    }

    @Override
    public Customer readCustomer(int customerNumber) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Customer customerToRead = new Customer();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            customerToRead = em.find(Customer.class,customerNumber);
            transaction.commit();

            System.out.println(customerToRead + " readed");

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
        return customerToRead;
    }

    @Override
    public void updateCustomer(Customer customer) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Customer customerToUpdate = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            customerToUpdate = em.find(Customer.class,customer.getCustomerNumber());
            customerToUpdate.setCustomerName(customer.getCustomerName());
            customerToUpdate.setContactLastName(customer.getContactLastName());
            customerToUpdate.setContactFirstName(customer.getContactFirstName());
            customerToUpdate.setPhone(customer.getPhone());
            customerToUpdate.setAddressLine1(customer.getAddressLine1());
            customerToUpdate.setAddressLine2(customer.getAddressLine2());
            customerToUpdate.setCity(customer.getCity());
            customerToUpdate.setState(customer.getState());
            customerToUpdate.setPostalCode(customer.getPostalCode());
            customerToUpdate.setCountry(customer.getCountry());
            customerToUpdate.setSalesRepEmployeeNumber(customer.getSalesRepEmployeeNumber());
            customerToUpdate.setCreditLimit(customer.getCreditLimit());
            transaction.commit();

            System.out.println(customerToUpdate + " updated");

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
    public void deleteCustomer(Customer customer) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            Customer customerToDelete = em.find(Customer.class,customer.getCustomerNumber());
            em.remove(customerToDelete);
            transaction.commit();

            System.out.println(customerToDelete + " deleted");

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
