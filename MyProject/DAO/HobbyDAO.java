package DAO;

import DTO.HobbyDTO;
import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Hobby;
import model.HobbyType;
import model.Person;

import java.util.List;

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

    public List<Person> getPersonsWithHobby(String hobby) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            String sqlQuery = "SELECT p.* " +
                    "FROM Person p " +
                    "JOIN Hobby_Person hp ON p.person_id = hp.persons_person_id " +
                    "JOIN Hobby h ON hp.hobbies_hobby_id = h.hobby_id " +
                    "WHERE h.hobbyType = :hobbyType";
            List<Person> resultList = entityManager.createNativeQuery(sqlQuery, Person.class)
                    .setParameter("hobbyType", hobby)
                    .getResultList();
            return resultList;
        } finally {
            entityManager.close();
        }
    }

    public long getNumberOfPeopleWithHobby (HobbyType hobbyType) {
        //By writing it inside the try block, we ensure that the EntityManager is closed after the operation
        try (EntityManager entityManager = emf.createEntityManager()) {
            long count = (long) entityManager.createQuery("SELECT COUNT (p.iD) AS person_count FROM Person p JOIN p.hobbies ph WHERE ph.hobbyType = :hobbyType")
                    .setParameter("hobbyType", hobbyType).getSingleResult();
            return count;
        }
    }

    public List<Hobby> getAllHobbiesAndCount(){
        try(EntityManager entityManager = emf.createEntityManager()){
            TypedQuery<Hobby> query = entityManager.createQuery("SELECT h FROM Hobby h", Hobby.class);
            return query.getResultList();

        }
    }












}
