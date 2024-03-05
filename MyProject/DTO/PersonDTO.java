package DTO;

import lombok.ToString;
import model.Person;

import java.util.List;
import java.util.stream.Collectors;


public record PersonDTO(int id, String firstName, String LastName, int age, int phoneNumber, String Streetname, String streetnumber, String additionalInfo, String cityname, String zipcode, List<String> hobbies) {


    public static PersonDTO fromPerson(Person person) {
        return new PersonDTO(
                person.getID(),
                person.getFirstName(),
                person.getLastName(),
                person.getAge(),
                person.getPhoneNumber(),
                person.getAddress().getStreetName(),
                person.getAddress().getStreetNumber(),
                person.getAddress().getAdditionalInfo(),
                person.getCity().getCityName(),
                person.getCity().getZipCode(),
                person.getHobbies().stream().map(Hobby -> Hobby.getHobbyType().toString()).collect(Collectors.toList())
        );
    }

}