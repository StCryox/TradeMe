package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain;

import fr.esgi.al.kernel.Repository;

import java.util.List;

public interface MatchTradesmanRepository extends Repository<MatchTradesmanId, MatchTradesman> {
    List<MatchTradesman> findAll();
}
