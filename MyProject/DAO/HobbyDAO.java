package DAO;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Hobby;

public class HobbyDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Hobby createHobby(Hobby hobby){
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Persists the hobby to the DB
        em.persist(hobby);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        em.close();

        System.out.println("Your hobby " + hobby + "has now been added to the Database");
        return hobby;
    }

    public void deleteHobby(int id) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Finds the hobby with the given id
        Hobby hobby = em.find(Hobby.class, id);
        //Removes the hobby from the DB
        em.remove(hobby);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        em.close();
    }

    public Hobby updateHobby(Hobby hobby) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Merges the updated hobby with the hobby in the DB
        Hobby updatedHobby = em.merge(hobby);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        em.close();

        System.out.println("Your hobby " + hobby + "has now been updated in the Database");
        return updatedHobby;
    }

    public Hobby findHobby(int id) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Finds the hobby with the given id
        Hobby hobby = em.find(Hobby.class, id);
        em.close();

        return hobby;
    }

    public void getAllHobbies() {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Queries the DB for all hobbies and prints them out
        em.createQuery("SELECT h FROM Hobby h", Hobby.class).getResultList().forEach(System.out::println);
    }


















}
