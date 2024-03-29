package fr.esgi.al.domain.MarketplaceAPI.AddMember.domain;


import fr.esgi.al.kernel.Entity;

import java.util.Objects;

public final class User implements Entity<UserId> {

    private final UserId id;
    private final String lastname;
    private final String firstname;
    private final Role role;
    private Address address;

    public User(UserId id, String lastname, String firstname, Role role, Address address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.role = role;
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public UserId getId() {
        return id;
    }

    @Override
    public UserId id() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Address getAddress() {
        return address;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname) && Objects.equals(role, user.role) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, role, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", role='" + role + '\'' +
                ", address=" + address +
                '}';
    }
}
