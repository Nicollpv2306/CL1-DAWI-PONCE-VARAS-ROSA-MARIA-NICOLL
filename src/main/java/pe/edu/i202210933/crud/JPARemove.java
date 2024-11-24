package pe.edu.i202210933.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202210933.entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Country ponceCountryRemove = em.find(Country.class, "PPR");

            em.remove(ponceCountryRemove);

            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
