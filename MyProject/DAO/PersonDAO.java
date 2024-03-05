package DAO;

import DTO.PersonDTO;
import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.*;

public class PersonDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Person createPerson(Person person){
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Persists the person to the DB
        em.persist(person);
        em.getTransaction().commit();
        em.close();
        System.out.println("Your person " + person + "has now been added to the Database");
        return person;
    }

    public void deletePerson(int id) {
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Finds the person with the given id
        Person person = em.find(Person.class, id);
        //Removes the person from the DB
        em.remove(person);
        em.getTransaction().commit();
        em.close();
        System.out.println("Your person with the id " + id + " has now been deleted from the Database");
    }

    public Person updatePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Merges the updated person with the person in the DB
        Person updatedPerson = em.merge(person);
        em.getTransaction().commit();
        em.close();
        System.out.println("Your person " + person + "has now been updated in the Database");
        return updatedPerson;
    }

    public Person findPerson(int id) {
        EntityManager em = emf.createEntityManager();
        //Finds the person with the given id
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }


    public PersonDTO getPersonDetails(int id) {
        EntityManager entityManager = emf.createEntityManager();

        Person person = (Person) entityManager.createQuery("SELECT p from Person p WHERE p.iD = :id", Person.class).setParameter("id", id).getSingleResult();
        entityManager.close();
        return PersonDTO.fromPerson(person);
    }











//    public void getAllPersonDetails(int id) {
//        EntityManager em = emf.createEntityManager();
//        //Queries the DB for all persons and prints them out
//        //CreateNativeQueries can take in SQL queries and return the result as a list
//        List<Object[]> results = em.createNativeQuery("SELECT p.*, a.*, c.*, h.*\n" +
//                "FROM Person p\n" +
//                "         JOIN Address a ON p.person_id = a.address_id\n" +
//                "         JOIN City c ON p.city_city_id = c.city_id\n" +
//                "         Join hobby_person hp ON hp.persons_person_id = p.person_id\n" +
//                "         JOIN Hobby h ON hp.hobbies_hobby_id = h.hobby_id WHERE p.person_id = ?").setParameter(1, id).
//                getResultList();
//        for (Object[] row : results) {
//            System.out.println(Arrays.toString(row));
//        }
//    }







}
