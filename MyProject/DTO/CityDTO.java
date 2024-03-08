package DTO;

import model.City;

import java.util.List;
import java.util.stream.Collectors;

public record CityDTO(String cityName, String zipCode) {
    public static List<CityDTO> fromCityObject(List<City> cities){
        //We use stream since we are working with a list and streams are very efficient when working with lists
        return cities.stream()
                //Our map transforms each City object in the stream into a CityDTO object - For each City object city,
                // we'll create a new CityDTO object using the CityDTO constructor, passing the cityName and zipCode
                // properties of the City object as arguments.
                .map(city -> new CityDTO(city.getCityName(), city.getZipCode()))
                .collect(Collectors.toList());
    }

}
