package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.AddressResponse;
import fr.esgi.al.kernel.Command;

public class ModifyUserAddress implements Command {

    public final int userId;
    public final AddressResponse address;

    public ModifyUserAddress(int userId, AddressResponse address) {
        this.userId = userId;
        this.address = address;
    }
}
