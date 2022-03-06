package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.kernel.EventListener;

public class CreateTradesmanPaymentEventListener implements EventListener<CreateTradesmanPaymentEvent> {
    @Override
    public void listenTo(CreateTradesmanPaymentEvent event) {
        System.out.println("listening CreateTradesmanPaymentEvent.");
    }
}
