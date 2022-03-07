package fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition;

@SuppressWarnings("all")
public class UserResponse {

    public String id;
    public String lastname;
    public String firstname;
    public String role;
    public AddressResponse address;

    public UserResponse(String id, String lastname, String firstname, String role, AddressResponse address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.role = role;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", role='" + role + '\'' +
                ", address=" + address +
                '}';
    }
}
