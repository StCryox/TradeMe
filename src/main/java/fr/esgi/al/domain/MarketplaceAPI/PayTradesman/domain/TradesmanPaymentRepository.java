package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.kernel.Repository;

import java.util.List;

public interface TradesmanPaymentRepository extends Repository<TradesmanPaymentId, TradesmanPayment> {
    List<TradesmanPayment> findAll();

    List<TradesmanPayment> findByTradesmanId(UserId tradesmanId);
}
