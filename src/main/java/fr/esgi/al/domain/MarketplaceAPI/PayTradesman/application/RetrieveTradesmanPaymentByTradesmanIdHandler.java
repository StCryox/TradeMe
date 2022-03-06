package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPayment;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentRepository;
import fr.esgi.al.kernel.QueryHandler;

import java.util.List;

public class RetrieveTradesmanPaymentByTradesmanIdHandler implements QueryHandler<RetrieveTradesmanPaymentByTradesmanId, List<TradesmanPayment>> {

    private final TradesmanPaymentRepository tradesmanPaymentRepository;

    public RetrieveTradesmanPaymentByTradesmanIdHandler(TradesmanPaymentRepository tradesmanPaymentRepository) {
        this.tradesmanPaymentRepository = tradesmanPaymentRepository;
    }

    @Override
    public List<TradesmanPayment> handle(RetrieveTradesmanPaymentByTradesmanId query) {
        return tradesmanPaymentRepository.findByTradesmanId(query.tradesmanId);
    }
}
