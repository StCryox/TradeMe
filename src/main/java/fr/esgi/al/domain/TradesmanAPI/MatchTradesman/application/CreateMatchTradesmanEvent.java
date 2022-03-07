package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.kernel.ApplicationEvent;

public class CreateMatchTradesmanEvent implements ApplicationEvent {
    private final MatchTradesmanId matchTradesmanId;

    public CreateMatchTradesmanEvent(MatchTradesmanId matchTradesmanId) {
        this.matchTradesmanId = matchTradesmanId;
    }
}
