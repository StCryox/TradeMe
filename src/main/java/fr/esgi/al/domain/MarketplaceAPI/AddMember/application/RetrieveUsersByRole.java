package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Role;
import fr.esgi.al.kernel.Query;

public class RetrieveUsersByRole implements Query {
    public final Role role;

    public RetrieveUsersByRole(Role role) {
        this.role = role;
    }
}
