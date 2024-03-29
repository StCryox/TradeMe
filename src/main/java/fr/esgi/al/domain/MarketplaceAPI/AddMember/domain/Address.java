package fr.esgi.al.domain.MarketplaceAPI.AddMember.domain;

public class Address {

    private final String city;

    public Address(String street) {
        this.city = street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
