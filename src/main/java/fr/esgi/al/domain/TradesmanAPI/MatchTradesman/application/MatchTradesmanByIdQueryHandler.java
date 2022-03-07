package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanRepository;
import fr.esgi.al.kernel.QueryHandler;

import java.util.List;

public class MatchTradesmanByIdQueryHandler implements QueryHandler<MatchTradesmanById, List<User>> {

    private final MatchTradesmanRepository matchTradesmanRepository;

    public MatchTradesmanByIdQueryHandler(MatchTradesmanRepository matchTradesmanRepository) {
        this.matchTradesmanRepository = matchTradesmanRepository;
    }

    @Override
    public List<User> handle(MatchTradesmanById query) {
        System.out.println("MatchTradesmanById Handler called");
        MatchTradesman matchTradesman = matchTradesmanRepository.findById(query.matchTradesmanId);
        return matchTradesman.getTradesmans();
    }
}
