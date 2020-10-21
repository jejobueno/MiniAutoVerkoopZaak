package be.intecbrussel.data;

import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.Product;

import javax.persistence.*;

public class OrderDetailsDaoImp implements OrderDetailsDao{

    @Override
    public void createOrderDetail(OrderDetail orderDetail) {

    }

    @Override
    public OrderDetail readOrderDetail(Order order) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        OrderDetail orderDetailToRead = new OrderDetail();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            orderDetailToRead = em.find(OrderDetail.class,order.getOderNumber());
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
    public void updateOrderDetail(Product productCode) {

    }

    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) {

    }
}
