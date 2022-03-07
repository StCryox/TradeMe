package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Address;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Role;
import fr.esgi.al.kernel.Command;
import fr.esgi.al.kernel.Price;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateMatchTradesman implements Command {

    public final ProjectId projectId;
    public final Price price;

    public CreateMatchTradesman(ProjectId projectId, Price price) {
        this.projectId = projectId;
        this.price = price;
    }
}
