package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPayment;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentRepository;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.kernel.QueryHandler;

import java.util.List;

public class RetrieveTradesmanPaymentsHandler implements QueryHandler<RetrieveTradesmanPayments, List<TradesmanPayment>> {

    private final TradesmanPaymentRepository tradesmanPaymentRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public RetrieveTradesmanPaymentsHandler(TradesmanPaymentRepository tradesmanPaymentRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.tradesmanPaymentRepository = tradesmanPaymentRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public List<TradesmanPayment> handle(RetrieveTradesmanPayments query) {
        eventEventDispatcher.dispatch(new RetrieveTradesmanPaymentsEvent());
        return tradesmanPaymentRepository.findAll();
    }
}
