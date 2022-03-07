package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.kernel.Entity;

import java.util.List;

public class MatchTradesman implements Entity<MatchTradesmanId> {
    private final MatchTradesmanId matchTradesmanId;
    private final List<User> tradesmans;

    public MatchTradesman(MatchTradesmanId matchTradesmanId, List<User> tradesmans) {
        this.matchTradesmanId = matchTradesmanId;
        this.tradesmans = tradesmans;
    }

    public List<User> getTradesmans() {
        return tradesmans;
    }

    @Override
    public MatchTradesmanId id() {
        return matchTradesmanId;
    }
}
