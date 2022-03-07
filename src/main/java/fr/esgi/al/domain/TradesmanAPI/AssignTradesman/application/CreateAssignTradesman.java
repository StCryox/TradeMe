package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.application;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.kernel.Command;
import fr.esgi.al.kernel.Price;

import java.util.List;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateAssignTradesman implements Command {

    public final ProjectId projectId;
    public final List<UserId> usersId;

    public CreateAssignTradesman(ProjectId projectId, List<UserId> usersId) {
        this.projectId = projectId;
        this.usersId = usersId;
    }
}
