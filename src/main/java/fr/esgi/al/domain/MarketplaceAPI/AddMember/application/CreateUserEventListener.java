package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.EventListener;

public class CreateUserEventListener implements EventListener<CreateUserEvent> {
    @Override
    public void listenTo(CreateUserEvent event) {
        System.out.println("listening CreateUserEvent.");
    }
}
