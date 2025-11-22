public class Address {
    private final String street;
    private final String city;

    public Address(String street, String city) {
        if (street == null || city == null) {
            throw new IllegalArgumentException("street and city must not be null");
        }
        this.street = street;
        this.city = city;
    }

    // Copy constructor
    public Address(Address other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.street = other.street;
        this.city = other.city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return street + ", " + city;
    }
}
