package fr.esgi.al.domain.ContractorAPI;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.Project;
import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;

import java.util.List;

public class ContractorManager {
    public Project getProject(ProjectId projectId) {
        return new Project(
                new ProjectId(1),
                "TradeMe"
        );
    }

    public ProjectId assignTradesman(ProjectId projectId, List<UserId> tradesmansId) {
        System.out.println("Contract Manager assignTradesman function");
        return projectId;
    }
}
