package be.intecbrussel.data;

import be.intecbrussel.entities.Order;

import javax.persistence.*;

public class OrderDaoImp implements OrderDao {

    @Override
    public void createOrder(Order order) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(order);
            transaction.commit();

            System.out.println(order + " saved");

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
    public Order readOrder(int orderNumber) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Order orderToRead = new Order();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            orderToRead = em.find(Order.class,orderNumber);
            transaction.commit();

            System.out.println(orderToRead + " readed");

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
        return orderToRead;
    }

    @Override
    public void updateOrder(Order order) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Order orderToUpdate = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            orderToUpdate = em.find(Order.class,order.getOderNumber());
            orderToUpdate.setOrderDate(order.getOrderDate());
            orderToUpdate.setRequiredDate(order.getRequiredDate());
            orderToUpdate.setShippedDate(order.getShippedDate());
            orderToUpdate.setStatus(order.getStatus());
            orderToUpdate.setComments(order.getComments());
            orderToUpdate.setCustomerNumber(order.getCustomerNumber());
            transaction.commit();

            System.out.println(orderToUpdate + " updated");

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
    public void deleteOrder(Order order) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            Order orderToDelete = em.find(Order.class,order.getOderNumber());
            em.remove(orderToDelete);
            transaction.commit();

            System.out.println(orderToDelete + " deleted");

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
