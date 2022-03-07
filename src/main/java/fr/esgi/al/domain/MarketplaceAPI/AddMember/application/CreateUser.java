package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Role;
import fr.esgi.al.kernel.Command;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Address;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateUser implements Command {

    public final String lastname;
    public final String firstname;
    public final Role role;
    public final Address address;

    public CreateUser(String lastname, String firstname, Role role, Address address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.role = role;
        this.address = address;
    }
}
