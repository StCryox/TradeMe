package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.exposition;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;

import java.util.List;

@SuppressWarnings("all")
public class MatchTradesmanResponse {

    public MatchTradesmanId matchTradesmanId;
    public List<User> tradesmans;

    public MatchTradesmanResponse(MatchTradesmanId matchTradesmanId, List<User> tradesmans) {
        this.matchTradesmanId = matchTradesmanId;
        this.tradesmans = tradesmans;
    }
}
