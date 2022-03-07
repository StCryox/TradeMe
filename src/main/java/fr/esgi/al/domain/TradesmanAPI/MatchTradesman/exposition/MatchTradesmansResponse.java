package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.exposition;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;

import java.util.List;

@SuppressWarnings("all")
public class MatchTradesmansResponse {

    public final List<MatchTradesmanResponse> tradesmanResponses;

    public MatchTradesmansResponse(List<MatchTradesmanResponse> tradesmanResponses) {
        this.tradesmanResponses = tradesmanResponses;
    }
}
