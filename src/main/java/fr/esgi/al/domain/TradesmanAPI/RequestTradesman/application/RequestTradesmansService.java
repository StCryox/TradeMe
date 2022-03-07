package fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.MarketManager;

import java.util.List;

public class RequestTradesmansService {
    private MarketManager marketManager;

    public RequestTradesmansService(MarketManager marketManager) {
        this.marketManager = marketManager;
    }

    public List<User> findTradesmans() {
        return marketManager.getAllTrademans();
    }

}
