
package DAO;


import DTO.PersonDTO;
import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonDAOTest {


    PersonDAO personDAO = new PersonDAO();
    AddressDAO addressDAO = new AddressDAO();
    CityDAO cityDAO = new CityDAO();
    HobbyDAO hobbyDAO = new HobbyDAO();

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    Person person1;

    private final List<String> tableNames = List.of("person", "hobby", "address", "city", "hobby_person");




    @BeforeEach
    public void setup() {

        EntityManager em = emf.createEntityManager();


        for (String table : tableNames) {
            em.createNativeQuery("TRUNCATE TABLE " + table);
        }



        List<Person> persons = Arrays.asList(
                new Person("Orhan", "Secilmis", 25, 12345678),
                new Person("Michael", "Jensen", 30, 87654321),
                new Person("John", "Doe", 35, 15555678),
                new Person("Jane", "Birgitsen", 40  , 15559978),
                new Person("Mads", "Mikkelsen", 20, 32445511),
                new Person("Mikkel", "Jensen", 23, 94423344 ),
                new Person("Troels", "Hansen", 55, 33224455),
                new Person("Lars", "Larsen", 15, 93228811)
        );

        List<Address> addresses = Arrays.asList(
                new Address("Vejlebrovej", "9", "1. th"),
                new Address("Pilegårdsvej", "9", "5. tv"),
                new Address("Ballerupsvej", "13A"),
                new Address("Vanegården", "113B", "7. mf"),
                new Address("Vadgårdsvej", "224"),
                new Address("Søgården", "17"),
                new Address("Vildbandegården", "91", "1. th"),
                new Address("Bjærgesvej", "119", "5. tv")
        );

        List<City> cities = Arrays.asList(
                new City("Vejle", "7100"),
                new City("Ishøj", "2635"),
                new City("Lyngby", "2800"),
                new City("Aarhus", "8000"),
                new City("Odense", "5000"),
                new City("Aalborg", "9000"),
                new City("Horsens", "8700"),
                new City("Silkeborg", "8600")
        );

        List<Hobby> hobbies = Arrays.asList(
                new Hobby("FunWithBallz!", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 2), HobbyType.FOOTBALL),
                new Hobby("SwimBitch!", LocalDate.of(2022, 2, 5), LocalDate.of(2022, 2, 5), HobbyType.SWIMMING),
                new Hobby("RunForrestRun!", LocalDate.of(2022, 3, 10), LocalDate.of(2022, 3, 10), HobbyType.RUNNING),
                new Hobby("TennisForLife!", LocalDate.of(2022, 4, 15), LocalDate.of(2022, 4, 15), HobbyType.TENNIS),
                new Hobby("GamingIsLife", LocalDate.of(2022, 5, 20), LocalDate.of(2022, 5, 22), HobbyType.GAMING),
                new Hobby("MoveYourAss", LocalDate.of(2022, 6, 25), LocalDate.of(2022, 6, 25), HobbyType.RUNNING),
                new Hobby("DorkForces2022", LocalDate.of(2022, 7, 30), LocalDate.of(2022, 7, 30), HobbyType.GAMING),
                new Hobby("SwimFit", LocalDate.of(2022, 8, 5), LocalDate.of(2022, 8, 5), HobbyType.SWIMMING)
        );

        for(int i = 0; i < persons.size(); i++){
            Person person = persons.get(i);
            Address address = addresses.get(i);
            City city = cities.get(i);
            Hobby hobby = hobbies.get(i);

            person.addAddress(address);
            person.addCity(city);
            person.addHobby(hobby);
            // The below line both SAVES the person AND also update the persons array with the same person but with ID
            persons.set(i,personDAO.createPerson(person));
        }

        person1 = persons.get(0);

    }


    @Test
    void getPersonDetails() {

        EntityManager entityManager = emf.createEntityManager();
        int personId = 1;

        PersonDTO personDTO = personDAO.getPersonDetails(personId);

        // YOU MUST ALWAYS ALWAYS ALWAYS END A TEST WITH ASSERT AND NOT SOUT - IT STOPS ON ASSERT!

        // Different assertions

        //1. assertEquals()
        //2. assertTrue()/False()
        //3. assertThrows()

        assertEquals(personDTO.id(),person1.getID());

    }

    @Test
    void getPhoneNumberOfPerson() {
    }
}
