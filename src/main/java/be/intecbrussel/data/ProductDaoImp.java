package be.intecbrussel.data;

import be.intecbrussel.entities.Product;

import javax.persistence.*;
import java.util.stream.Stream;

public class ProductDaoImp implements ProductDao {

    @Override
    public void createProduct(Product product) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(product);
            transaction.commit();

            System.out.println(product + " saved");

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
    public Product readProductByCode(String productCode) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Product productToRead = new Product();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            productToRead = em.find(Product.class,productCode);
            transaction.commit();

            System.out.println(productToRead + " readed");

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
        return productToRead;
    }

    @Override
    public Product readProductByName(String productName) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Product productToRead = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            Query query = em.createQuery("SELECT p FROM Product AS p WHERE p.productName LIKE ?1");
            query.setParameter(1, productName);
            Stream<Product> results = query.getResultStream();
            productToRead = results.findFirst().get();
            transaction.commit();

            System.out.println(productToRead + " readed");

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
        return productToRead;
    }

    @Override
    public void updateProduct(Product product) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Product productToUpdate = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            productToUpdate = em.find(Product.class,product.getProductCode());
            productToUpdate.setProductName(product.getProductName());
            productToUpdate.setProductLine(product.getProductLine());
            productToUpdate.setProductScale(product.getProductScale());
            productToUpdate.setProductVendor(product.getProductVendor());
            productToUpdate.setProductDescription(product.getProductDescription());
            productToUpdate.setQuantityInStock(product.getQuantityInStock());
            productToUpdate.setBuyPrice(product.getBuyPrice());
            productToUpdate.setMSRP(product.getMSRP());
            transaction.commit();

            System.out.println(product + " updated");

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
    public void deleteProduct(Product product) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            Product productToDelete = em.find(Product.class,product.getProductCode());
            em.remove(productToDelete);
            transaction.commit();

            System.out.println(productToDelete + " saved");

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
