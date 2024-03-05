package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_iD")
    private Integer iD;

    private String eventTitle;
    private LocalDate startDateOfEvent;
    private LocalDate endDateOfEvent;

    @Enumerated(EnumType.STRING)
    private HobbyType hobbyType;
    @ManyToMany
    private Set<Person> persons = new HashSet<>();



    public Hobby(String eventTitle, LocalDate startDateOfEvent, LocalDate endDateOfEvent, HobbyType hobbyType) {
        this.eventTitle = eventTitle;
        this.startDateOfEvent = startDateOfEvent;
        this.endDateOfEvent = endDateOfEvent;
        this.hobbyType = hobbyType;
    }


    @Override
    public String toString() {
        return "Hobby{" +
                "eventTitle='" + eventTitle + '\'' +
                ", startDateOfEvent=" + startDateOfEvent +
                ", endDateOfEvent=" + endDateOfEvent +
                ", hobbyType=" + hobbyType +
                '}';
    }
}
