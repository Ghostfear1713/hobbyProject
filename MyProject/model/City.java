package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "city_iD")
    private Integer iD;

    private String cityName;
    private String zipCode;
    //Relations many:1
    @OneToMany(mappedBy = "city")
    private Set<Person> person = new HashSet<>();


    public City(String cityName, String zipCode) {
        this.cityName = cityName;
        this.zipCode = zipCode;
    }







}
