package be.intecbrussel.data;

import be.intecbrussel.entities.ProductLine;

import javax.persistence.*;

public class ProductLineDaoImp implements ProductLineDao {

    @Override
    public void createProductLine(ProductLine productLine) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(productLine);
            transaction.commit();

            System.out.println(productLine + " saved");

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
    public ProductLine readProductLine(String productLine) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        ProductLine productLineToRead = new ProductLine();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            productLineToRead = em.find(ProductLine.class,productLine);
            transaction.commit();

            System.out.println(productLineToRead + " readed");

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
        return productLineToRead;
    }

    @Override
    public void updateProductLine(ProductLine productLine) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        ProductLine productLineToUpdate = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            productLineToUpdate = em.find(ProductLine.class,productLine.getProductLine());
            productLineToUpdate.setTextDescription(productLine.getTextDescription());
            productLineToUpdate.setHtmlDescription(productLine.getHtmlDescription());
            productLineToUpdate.setImage(productLine.getImage());
            transaction.commit();

            System.out.println(productLine + " updated");

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
    public void deleteProductLine(ProductLine productLine) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            ProductLine productLineToDelete = em.find(ProductLine.class,productLine.getProductLine());
            em.remove(productLineToDelete);
            transaction.commit();

            System.out.println(productLine + " saved");

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
