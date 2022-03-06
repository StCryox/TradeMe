package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.Query;

public class RetrieveUsersByCity implements Query {
    public final String city;

    public RetrieveUsersByCity(String city) {
        this.city = city;
    }
}
