package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application;

import fr.esgi.al.domain.ContractorAPI.ContractorManager;
import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.Project;
import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.MarketManager;
import fr.esgi.al.kernel.Price;

import java.util.ArrayList;
import java.util.List;

public class MatchTradesmanService {
    private MarketManager marketManager;
    private ContractorManager contractorManager;

    public MatchTradesmanService(MarketManager marketManager, ContractorManager contractorManager) {
        this.marketManager = marketManager;
        this.contractorManager = contractorManager;
    }

    public List<User> matchTradesman(ProjectId projectId, Price price) {
        if(analyzeProject(projectId)){
            System.out.println("\nAnalyze project done");
            System.out.println(searchTradesmanCandidates(price));
            return searchTradesmanCandidates(price);
        }
        return new ArrayList<User>();
    }

    private Boolean analyzeProject(ProjectId projectId) {
        Project project = contractorManager.getProject(projectId);
        return project.getProjectName().equals("TradeMe");
    }

    private List<User> searchTradesmanCandidates(Price price) {
        return marketManager.getAllTrademan();
    }
}
