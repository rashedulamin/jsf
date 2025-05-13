package de.hsm.dataTable.domain;

public class Address {

    private String street;
    private String city;
    private Integer zipCode;
    private String country;

    public Address() {
        super();
    }

    public Address(Integer zipCode, String city, String street, String country) {
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
