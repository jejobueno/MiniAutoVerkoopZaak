package be.intecbrussel.data;

import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.OrderDetailPK;
import be.intecbrussel.entities.Product;

import javax.persistence.*;

public class OrderDetailsDaoImp implements OrderDetailsDao{

    @Override
    public void createOrderDetail(OrderDetail orderDetail) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(orderDetail);
            transaction.commit();

            System.out.println(orderDetail + " saved");

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
    public OrderDetail readOrderDetail(Order order, Product product) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        OrderDetail orderDetailToRead = new OrderDetail();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            OrderDetailPK orderDetailPK = new OrderDetailPK(product,order);
            transaction.begin();
            orderDetailToRead = em.find(OrderDetail.class,orderDetailPK);
            transaction.commit();

            System.out.println(orderDetailToRead + " readed");

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
        return orderDetailToRead;
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        OrderDetail orderDetailToUpdated = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            OrderDetailPK orderDetailPK = new OrderDetailPK(orderDetail.getProduct(),orderDetail.getOrder());
            transaction.begin();
            orderDetailToUpdated = em.find(OrderDetail.class, orderDetailPK);
            orderDetailToUpdated.setOrderLineNumber(orderDetail.getOrderLineNumber());
            orderDetailToUpdated.setPriceEach((orderDetail.getPriceEach()));
            orderDetailToUpdated.setQuantityOrdered(orderDetail.getQuantityOrdered());
            transaction.commit();

            System.out.println(orderDetail + " updated");

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
    public void deleteOrderDetail(OrderDetail orderDetail) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        OrderDetail orderDetailToDelete = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            OrderDetailPK orderDetailPK = new OrderDetailPK(orderDetail.getProduct(),orderDetail.getOrder());
            transaction.begin();
            orderDetailToDelete = em.find(OrderDetail.class, orderDetailPK);
            em.remove(orderDetailToDelete);
            transaction.commit();

            System.out.println(orderDetail + " deleted");

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
