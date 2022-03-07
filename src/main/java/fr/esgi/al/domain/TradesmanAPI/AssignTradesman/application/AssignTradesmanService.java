package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.application;

import fr.esgi.al.domain.ContractorAPI.ContractorManager;
import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;

import java.util.List;

public class AssignTradesmanService {
    private final ContractorManager contractorManager;

    public AssignTradesmanService(ContractorManager contractorManager) {
        this.contractorManager = contractorManager;
    }

    public List<UserId> assignTradesman(ProjectId projectId, List<UserId> usersId) {
        List<UserId> availableTradesmans = verifyTradesmanStillAvailable(usersId);
        contractorManager.assignTradesman(projectId, availableTradesmans);
        return availableTradesmans;
    }

    private List<UserId> verifyTradesmanStillAvailable(List<UserId> userIds) {
        return userIds;
    }
}
