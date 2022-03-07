package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.kernel.EventListener;

public class CreateMatchTradesmanEventListener implements EventListener<CreateMatchTradesmanEvent> {
    @Override
    public void listenTo(CreateMatchTradesmanEvent event) {
        System.out.println("listening CreateMatchTradesmanEvent.");
    }
}
