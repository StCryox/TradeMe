package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.kernel.ApplicationEvent;

public class RetrieveTradesmanPaymentsEvent implements ApplicationEvent {
    private final RetrieveTradesmanPayments retrieveTradesmanPayments;

    public RetrieveTradesmanPaymentsEvent(RetrieveTradesmanPayments retrieveTradesmanPayments) {
        this.retrieveTradesmanPayments = retrieveTradesmanPayments;
    }
}
