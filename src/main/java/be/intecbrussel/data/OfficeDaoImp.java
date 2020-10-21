package be.intecbrussel.data;

import be.intecbrussel.entities.Office;

import javax.persistence.*;

public class OfficeDaoImp implements OfficeDao{

    @Override
    public void createOffice(Office office) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(office);
            transaction.commit();

            System.out.println(office + " saved");

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
    public Office readOffice(int officeCode) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Office officeToRead = new Office();

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            officeToRead = em.find(Office.class,officeCode);
            transaction.commit();

            System.out.println(officeToRead + " readed");

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
        return officeToRead;
    }

    @Override
    public void updateOffice(Office office) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Office officeToUpdate = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            officeToUpdate = em.find(Office.class,office.getOfficeCode());
            officeToUpdate.setCity(office.getCity());
            officeToUpdate.setPhone(office.getPhone());
            officeToUpdate.setAddressLine1(office.getAddressLine1());
            officeToUpdate.setAddressLine2(office.getAddressLine2());
            officeToUpdate.setState(office.getState());
            officeToUpdate.setCountry(office.getCountry());
            officeToUpdate.setPostalCode(office.getPostalCode());
            officeToUpdate.setTerritory(office.getTerritory());
            transaction.commit();

            System.out.println(officeToUpdate + " updated");

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
    public void deleteOffice(Office office) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mypersistenceunit");
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            Office officeToDelete = em.find(Office.class,office.getOfficeCode());
            em.remove(officeToDelete);
            transaction.commit();

            System.out.println(officeToDelete + " deleted");

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
