package pe.edu.i202210933.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202210933.entity.City;
import pe.edu.i202210933.entity.Country;
import pe.edu.i202210933.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Country ponceCountry = new Country();
            ponceCountry.setCode("PPR");
            ponceCountry.setName("PoncePais");
            ponceCountry.setContinent("South America");
            ponceCountry.setRegion("RegionP");
            ponceCountry.setSurfaceArea(77777.77);
            ponceCountry.setIndepYear(1600);
            ponceCountry.setPopulation(241124);
            ponceCountry.setLifeExpectancy(80.1);
            ponceCountry.setGnp(323700.0);
            ponceCountry.setGnpOld(180000.0);
            ponceCountry.setLocalName("Local Ponce");
            ponceCountry.setGovernmentForm("Republica");
            ponceCountry.setHeadOfState("Rosa Ponce");
            ponceCountry.setCapital(1);
            ponceCountry.setCode2("PP");

            City city1 = new City();
            city1.setName("CityP1");
            city1.setDistrict("Distrito1");
            city1.setPopulation(230000);
            city1.setCountry(ponceCountry);

            City city2 = new City();
            city2.setName("CityPT2");
            city2.setDistrict("Distrito2");
            city2.setPopulation(210000);
            city2.setCountry(ponceCountry);

            City city3 = new City();
            city3.setName("CityPT3");
            city3.setDistrict("Distrito3");
            city3.setPopulation(180000);
            city3.setCountry(ponceCountry);


            CountryLanguage language1 = new CountryLanguage();
            language1.setLanguage("EspañolP");
            language1.setIsOfficial("T");
            language1.setPercentage(75.0);
            language1.setCountry(ponceCountry);

            CountryLanguage language2 = new CountryLanguage();
            language2.setLanguage("InglesP");
            language2.setIsOfficial("F");
            language2.setPercentage(25.0);
            language2.setCountry(ponceCountry);

            ponceCountry.setCities(Arrays.asList(city1, city2, city3));
            ponceCountry.setCountryLanguages(Arrays.asList(language1, language2));

            em.persist(ponceCountry);

            em.getTransaction().commit();
            System.out.println("El país, las ciudades y los lenaguajes han sido persistidos exitosamente.");
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
