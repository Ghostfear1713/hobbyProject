package DAO;

import DTO.CityDTO;
import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import model.City;
import model.Hobby;
import model.Person;

import java.util.List;

public class CityDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public City createCity(City city){
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Persists the city to the DB
        em.persist(city);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        //Closes the EntityManager connection to the DB
        em.close();

        System.out.println("Your city " + city + "has now been added to the Database");
        return city;
    }

    public void deleteCity(int id) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Finds the city with the given id
        City city = em.find(City.class, id);
        //Removes the city from the DB
        em.remove(city);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        //Closes the EntityManager connection to the DB
        em.close();
    }

    public City updateCity(City city) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Merges the updated city with the city in the DB
        City updatedCity = em.merge(city);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        //Closes the EntityManager connection to the DB
        em.close();

        System.out.println("Your city " + city + "has now been updated in the Database");
        return updatedCity;
    }

    public City findCity(int id) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Finds the city with the given id
        City city = em.find(City.class, id);
        //Closes the EntityManager connection to the DB
        em.close();
        return city;
    }

    public void getAllCities() {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Queries the DB for all cities and prints them out
        em.createQuery("SELECT c FROM City c", City.class).getResultList().forEach(System.out::println);
    }

    public List<Person> getPersonsInCity(String city) {
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.city.cityName = :city", Person.class).setParameter("city", city);
        return query.getResultList();
    }

    public List<CityDTO> getAllPostcodesAndCities() {
        EntityManager entityManager = emf.createEntityManager();
        List<City> cities = entityManager.createQuery("SELECT c FROM City c", City.class).getResultList();
        return CityDTO.fromCityObject(cities);
    }











}
