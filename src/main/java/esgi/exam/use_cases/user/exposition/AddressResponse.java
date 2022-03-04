package esgi.exam.use_cases.user.exposition;

public class AddressResponse {

    public final String city;

    public AddressResponse(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                '}';
    }
}
