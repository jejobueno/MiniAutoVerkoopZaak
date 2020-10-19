package be.intecbrussel.data;

import be.intecbrussel.entities.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);
    Customer readCustomer(String customerName);
    Customer readCustomer(int customerNumber);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);

}
