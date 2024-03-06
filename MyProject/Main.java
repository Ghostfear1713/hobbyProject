import DAO.AddressDAO;
import DAO.CityDAO;
import DAO.HobbyDAO;
import DAO.PersonDAO;
import model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        AddressDAO addressDAO = new AddressDAO();
        CityDAO cityDAO = new CityDAO();
        HobbyDAO hobbyDAO = new HobbyDAO();


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
        //Above are all detached objects (not in the database)

        //USER STORY 1 - As a user I want to get all the information about a person
        //System.out.println(personDAO.getPersonDetails(1));

        //USER STORY 2 - As a user I want to get all phone numbers from a given person
        //System.out.println(personDAO.getPhoneNumberOfPerson(3));

        //USER STORY 3 - As a user I want to get all persons with a given hobby
        //System.out.println(hobbyDAO.getPersonsWithHobby("RUNNING"));

        //USER STORY 4 - As a user I want to get the number of people with a given hobby
        //System.out.println(hobbyDAO.getNumberOfPeopleWithHobby(HobbyType.GAMING));

        //USER STORY 5 - As a user I want to get a list all hobbies + a count of how many are interested in each hobby


        //USER STORY 6 - As a user I want to get all persons living in a given city (i.e. 2800 Lyngby)
        //System.out.println(cityDAO.getPersonsInCity("Vejle"));

        //USER STORY 7 - As a user I want to get a list of all postcodes and city names in Denmark
        //System.out.println(cityDAO.getAllPostcodesAndCities());

        //USER STORY 8 - As a user I want to get all the information about a person (address, hobbies etc.) given a phone number
        //System.out.println(personDAO.getPersonByPhoneNumber(12345678));









        /*for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            Address address = addresses.get(i);
            City city = cities.get(i);
            Hobby hobby = hobbies.get(i);

            Address address1 = addressDAO.createAddress(address);
            City city1 = cityDAO.createCity(city);
            Hobby hobby1 = hobbyDAO.createHobby(hobby);
            Person person1 = personDAO.createPerson(person);

            person1.addAddress(address1);
            person1.addCity(city1);
            person1.addHobby(hobby1);
            personDAO.updatePerson(person1);
        }*/

        //This method is used to inserts all of my detached objects into the database
        /*for(int i = 0; i < persons.size(); i++){
            Person person = persons.get(i);
            Address address = addresses.get(i);
            City city = cities.get(i);
            Hobby hobby = hobbies.get(i);

            person.addAddress(address);
            person.addCity(city);
            person.addHobby(hobby);
            personDAO.createPerson(person);
        }*/





        //TESTING FOR MY SELF
        //_____________________________________________________________________________________________________________




    }
}
