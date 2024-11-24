package pe.edu.i202210933.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202210933.entity.Country;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        try {
            Country peru = em.find(Country.class, "PER");

            peru.getCities().stream().filter( city -> city.getPopulation() > 700000)
                    .forEach( city -> System.out.println("Ciudad: " + city.getName() + " - Población: " + city.getPopulation()));
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
