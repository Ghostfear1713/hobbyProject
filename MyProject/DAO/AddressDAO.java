package DAO;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Address;

public class AddressDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Address createAddress(Address address){
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Persists the address to the DB
        em.persist(address);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        //Closes the EntityManager connection to the DB
        em.close();

        System.out.println("Your address " + address + "has now been added to the Database");
        return address;
    }

    public void deleteAddress(int id) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Finds the address with the given id
        Address address = em.find(Address.class, id);
        //Removes the address from the DB
        em.remove(address);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        //Closes the EntityManager connection to the DB
        em.close();
    }

    public Address updateAddress(Address address) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Begins a transaction/operation with our DB connection
        em.getTransaction().begin();
        //Merges the updated address with the address in the DB
        Address updatedAddress = em.merge(address);
        //Commits the transaction to the DB
        em.getTransaction().commit();
        //Closes the EntityManager connection to the DB
        em.close();

        System.out.println("Your address " + address + "has now been updated in the Database");
        return updatedAddress;
    }

    public Address findAddress(int id) {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Finds the address with the given id
        Address address = em.find(Address.class, id);
        //Closes the EntityManager connection to the DB
        em.close();
        return address;
    }

    public void getAllAddresses() {
        //Creates a new EntityManager to connect to the Database
        EntityManager em = emf.createEntityManager();
        //Queries the DB for all addresses and prints them out
        em.createQuery("SELECT a FROM Address a", Address.class).getResultList().forEach(System.out::println);
    }













}
