package fr.esgi.al.domain.TradesmanAPI;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.TradesmanAPI.AssignTradesman.application.CreateAssignTradesman;
import fr.esgi.al.domain.TradesmanAPI.AssignTradesman.domain.UsersId;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.CreateMatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.MatchTradesmanById;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application.RequestTradesman;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.Price;
import fr.esgi.al.kernel.QueryBus;

import java.util.List;

public class TradesmanManager {
    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public TradesmanManager(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    public List<User> findTradesman() {
        return queryBus.send(new RequestTradesman());
    }

    public List<User> matchTradesman(ProjectId projectId, Price price) {
        CreateMatchTradesman createMatchTradesman = new CreateMatchTradesman(
                projectId,
                price
        );
        MatchTradesmanId matchTradesmanId = commandBus.send(createMatchTradesman);
        return queryBus.send(new MatchTradesmanById(matchTradesmanId));
    }

    public List<User> assignTradesman(ProjectId projectId, List<UserId> usersId) {
        CreateAssignTradesman createAssignTradesman = new CreateAssignTradesman(
                projectId,
                usersId
        );
        return commandBus.send(createAssignTradesman);
    }
}
