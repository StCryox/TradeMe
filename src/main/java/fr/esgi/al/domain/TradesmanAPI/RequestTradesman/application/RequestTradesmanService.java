package fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.MarketManager;

import java.util.List;

public class RequestTradesmanService {
    private MarketManager marketManager;

    public RequestTradesmanService(MarketManager marketManager) {
        this.marketManager = marketManager;
    }

    public List<User> findTradesman() {
        return marketManager.getAllTrademan();
    }

}
