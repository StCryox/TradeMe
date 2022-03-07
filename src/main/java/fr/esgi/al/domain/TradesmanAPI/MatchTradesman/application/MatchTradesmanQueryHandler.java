package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanRepository;
import fr.esgi.al.kernel.QueryHandler;

import java.util.List;

public class MatchTradesmanQueryHandler implements QueryHandler<MatchTradesmanQuery, List<MatchTradesman>> {

    private final MatchTradesmanRepository matchTradesmanRepository;

    public MatchTradesmanQueryHandler(MatchTradesmanRepository matchTradesmanRepository) {
        this.matchTradesmanRepository = matchTradesmanRepository;
    }

    @Override
    public List<MatchTradesman> handle(MatchTradesmanQuery query) {
        System.out.println("MatchTradesman Handler called");
        return matchTradesmanRepository.findAll();
    }
}
