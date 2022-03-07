package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.kernel.EventListener;

public class RetrieveTradesmanPaymentsEventListener implements EventListener<RetrieveTradesmanPaymentsEvent> {
    @Override
    public void listenTo(RetrieveTradesmanPaymentsEvent event) {
        System.out.println("listening RetrieveTradesmanPaymentsEvent.");
    }
}
