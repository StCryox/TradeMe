package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;

public class CreateUserEvent implements ApplicationEvent {
    private final UserId userId;

    public CreateUserEvent(UserId userId) {
        this.userId = userId;
    }
}
