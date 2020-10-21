package be.intecbrussel.testapps;

import be.intecbrussel.entities.Customer;
import be.intecbrussel.data.CustomerDaoImp;
import be.intecbrussel.entities.Employee;

public class testCustomer {

    public static void main(String[] args) {

        Customer customer = null;
        Customer customer2 = null;
        Customer customer3 = null;
                //new Customer("Alpha Cognac30000","Roulet","Annette","61.77.6555","1 rue Alsace-Lorraine",null,"Lion",null,"France","31000",1370.00);
        CustomerDaoImp customerApp = new CustomerDaoImp();
        customer = customerApp.readCustomer(242);
        customer2 = customerApp.readCustomer("American Souvenirs Inc");
        //customerApp.createCustomer(customer3);
        //customer3 = customerApp.readCustomer(497);
        //customer3.setCustomerName("Another Name");
        //customerApp.updateCustomer(customer3);
        //customerApp.deleteCustomer(customer3);
    }


}
