package esgi.exam.use_cases.user.exposition;

@SuppressWarnings("all")
public class UserResponse {

    public String id;
    public String lastname;
    public String firstname;
    public AddressResponse address;

    public UserResponse(String id, String lastname, String firstname, AddressResponse address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address=" + address +
                '}';
    }
}
