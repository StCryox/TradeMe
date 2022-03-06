package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentId;
import fr.esgi.al.kernel.ApplicationEvent;

public class CreateTradesmanPaymentEvent implements ApplicationEvent {
    private final TradesmanPaymentId tradesmanPaymentId;

    public CreateTradesmanPaymentEvent(TradesmanPaymentId tradesmanPaymentId) {
        this.tradesmanPaymentId = tradesmanPaymentId;
    }
}
