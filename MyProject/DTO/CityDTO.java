package DTO;

import model.City;

import java.util.List;
import java.util.stream.Collectors;

public record CityDTO(String cityName, String zipCode) {
    public static List<CityDTO> fromCityObject(List<City> cities){
        return cities.stream()
                .map(city -> new CityDTO(city.getCityName(), city.getZipCode()))
                .collect(Collectors.toList());
    }

}
