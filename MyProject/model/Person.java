package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int iD;
    private String firstName;
    private String lastName;
    private int age;
    private int phoneNumber;

    //OUR RELATIONS
    //Relation 1:many
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private City city;

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Hobby> hobbies = new HashSet<>();



    public Person(String firstName, String lastName, int age, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }




    public void addAddress(Address address){
        if(address != null){
            //Adding the address to our list "listOfAddresses" IF the address is not null
            this.address = address;
            address.getPerson().add(this);
        }
    }

    public void addCity(City city){
        if(city != null){
            //Adding the city to our list "listOfCities" IF the city is not null
            this.city = city;
            city.getPerson().add(this);
        }
    }

    public void addHobby(Hobby hobby){
        if(hobby != null){
            //Adding the hobby to our list "listOfHobbies" IF the hobby is not null
            this.hobbies.add(hobby);
            hobby.getPersons().add(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "iD=" + iD +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", address=" + (address != null ? address.getStreetName() + " " + address.getStreetNumber() : null) +
                ", city=" + (city != null ? city.getCityName() : null) +
                ", hobbies=" + hobbies +
                '}';
    }



}
