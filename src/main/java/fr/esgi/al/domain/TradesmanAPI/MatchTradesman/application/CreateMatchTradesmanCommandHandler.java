package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanRepository;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class CreateMatchTradesmanCommandHandler implements CommandHandler<CreateMatchTradesman, MatchTradesmanId> {

    private final MatchTradesmanRepository matchTradesmanRepository;
    private final MatchTradesmanService matchTradesmanService;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final AtomicInteger count;

    public CreateMatchTradesmanCommandHandler(MatchTradesmanRepository matchTradesmanRepository, MatchTradesmanService matchTradesmanService, EventDispatcher<Event> eventEventDispatcher) {
        this.matchTradesmanRepository = matchTradesmanRepository;
        this.matchTradesmanService = matchTradesmanService;
        this.eventEventDispatcher = eventEventDispatcher;
        this.count = new AtomicInteger(0);
    }

    public MatchTradesmanId handle(CreateMatchTradesman createMatchTradesman) {
        final MatchTradesmanId matchTradesmanId = new MatchTradesmanId(count.incrementAndGet());
        List<User> matchedTradesmans = matchTradesmanService.matchTradesman(createMatchTradesman.projectId, createMatchTradesman.price);
        MatchTradesman matchTradesman = new MatchTradesman(matchTradesmanId, matchedTradesmans);
        matchTradesmanRepository.add(matchTradesman);
        eventEventDispatcher.dispatch(new CreateMatchTradesmanEvent(matchTradesmanId));
        return matchTradesmanId;
    }
}
