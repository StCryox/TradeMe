package fr.esgi.al.domain.TradesmanAPI;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application.RequestTradesman;
import fr.esgi.al.kernel.QueryBus;

import java.util.List;

public class TradesmanManager {
    private final QueryBus queryBus;

    public TradesmanManager(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    public List<User> findTradesman() {
        return queryBus.send(new RequestTradesman());
    }
}
