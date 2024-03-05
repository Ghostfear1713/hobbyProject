package DTO;

import model.HobbyType;
import model.Person;

import java.time.LocalDate;

public record PersonInfo(Integer personId,
                         String firstName,
                         String lastName,
                         Integer age,
                         Integer phoneNumber,
                         String streetName,
                         String streetNumber,
                         String additionalInfo,
                         String cityName,
                         String zipCode,
                         Integer hobbyId,
                         String eventTitle,
                         HobbyType hobbyType,
                         LocalDate hobbyStartDateOfEvent,
                         LocalDate hobbyEndDateOfEvent) { }
