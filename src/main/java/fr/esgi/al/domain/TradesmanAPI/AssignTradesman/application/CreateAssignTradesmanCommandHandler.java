package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.application;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.MatchTradesmanService;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanRepository;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class CreateAssignTradesmanCommandHandler implements CommandHandler<CreateAssignTradesman, List<UserId>> {

    private final AssignTradesmanService assignTradesmanService;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateAssignTradesmanCommandHandler(AssignTradesmanService assignTradesmanService, EventDispatcher<Event> eventEventDispatcher) {
        this.assignTradesmanService = assignTradesmanService;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public List<UserId> handle(CreateAssignTradesman createAssignTradesman) {
        List<UserId> usersId = assignTradesmanService.assignTradesman(createAssignTradesman.projectId, createAssignTradesman.usersId);
        eventEventDispatcher.dispatch(new CreateAssignTradesmanEvent());
        return usersId;
    }
}
