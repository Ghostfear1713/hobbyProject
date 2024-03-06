package DAO;

import DTO.AddressDTO;
import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Address;
import model.Person;

import java.util.List;

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

    public AddressDTO getAddressInfo(int personId){

       List<Object[]> valuesFromAddress = emf.createEntityManager().createQuery("SELECT a.streetName, a.streetNumber FROM Address a JOIN a.person ap WHERE ap.iD = :id").setParameter("id", personId).getResultList();

        return new AddressDTO((String) valuesFromAddress.get(0)[0], (String) valuesFromAddress.get(0)[1]);
    }


    public AddressDTO getAddressInfoAlt (int personId) {
        EntityManager em = emf.createEntityManager();

      AddressDTO dto = em.createQuery("SELECT NEW DTO.AddressDTO(a.streetName, a.streetNumber) FROM Address a JOIN a.person ap WHERE ap.iD = :myVaryingParameter", AddressDTO.class)
              .setParameter("myVaryingParameter", personId).getSingleResult();

       return dto;
    }

    public AddressDTO getAdressInfoPart2 (int personId) {

        EntityManager em = emf.createEntityManager();

        //SELECTS all addresses to begin with and retrieves only the adresses that has a person with the id ":id"
        // Is there an address that contains a person with the id ":id"
        // ABOUT THE JOIN: We select all adresses, then join the person table to it and find all addresses that has a relation to a person with the id ":id"
        Address addressTemp = em.createQuery("SELECT a FROM Address a JOIN a.person ap WHERE ap.iD = :id", Address.class).setParameter("id",personId).getSingleResult();
        //  Determines that Adress will be returned ^                            ^ Says return the adress where IT'S person has an ID with the number :id

        return AddressDTO.fromAddressObject(addressTemp);


    }













}
