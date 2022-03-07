package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.application;

import fr.esgi.al.kernel.EventListener;

public class CreateAssignTradesmanEventListener implements EventListener<CreateAssignTradesmanEvent> {
    @Override
    public void listenTo(CreateAssignTradesmanEvent event) {
        System.out.println("listening CreateAssignTradesmanEvent.");
    }
}
