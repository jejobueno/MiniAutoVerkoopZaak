package be.intecbrussel.data;

import be.intecbrussel.entities.Payment;

import javax.persistence.*;

public class PaymentDaoImp implements PaymentDao{
    @Override
    public void createPayment(Payment payment) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(payment);
            transaction.commit();

            System.out.println(payment + " saved");

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
    public Payment readPayment(String checkNumber) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Payment paymentToRead = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            paymentToRead = em.find(Payment.class,checkNumber);
            transaction.commit();

            System.out.println(paymentToRead + " readed");

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
        return paymentToRead;
    }

    @Override
    public void updatePayment(Payment payment) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Payment paymentToUpdate = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            paymentToUpdate = em.find(Payment.class,payment.getCheckNumber());
            paymentToUpdate.setCustomerNumber(payment.getCustomerNumber());
            paymentToUpdate.setAmount(payment.getAmount());
            paymentToUpdate.setPaymentDate(payment.getPaymentDate());
            transaction.commit();

            System.out.println(paymentToUpdate + " updated");

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
    public void deletePayment(Payment payment) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Payment paymentToDelete = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            paymentToDelete = em.find(Payment.class,payment.getCheckNumber());
            em.remove(paymentToDelete);
            transaction.commit();

            System.out.println(paymentToDelete + " deleted");

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
