package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_iD")
    private Integer iD;

    private String streetName;
    private String streetNumber;
    private String additionalInfo;
    //Relations
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private Set<Person> person = new HashSet<>();



    public Address(String streetName, String streetNumber, String additionalInfo) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.additionalInfo = additionalInfo;
    }

    public Address(String streetName, String streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }










}
