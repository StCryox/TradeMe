package fr.esgi.al.domain.ContractorAPI;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.Project;
import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;

public class ContractorManager {
    public Project getProject(ProjectId projectId) {
        return new Project(
                new ProjectId(1),
                "TradeMe"
        );
    }
}
