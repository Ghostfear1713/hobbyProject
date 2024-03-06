package DTO;

import model.Address;

public record AddressDTO(String streetname, String streetnumber) {
    public static AddressDTO fromAddressObject(Address address) {
        return new AddressDTO(
                address.getStreetName(),
                address.getStreetNumber()
        );
    }

}
