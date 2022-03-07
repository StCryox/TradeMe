package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.kernel.Query;

public class MatchTradesmanById implements Query {
    public final MatchTradesmanId matchTradesmanId;

    public MatchTradesmanById(MatchTradesmanId matchTradesmanId) {
        this.matchTradesmanId = matchTradesmanId;
    }
}
