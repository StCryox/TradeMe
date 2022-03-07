package fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.kernel.QueryHandler;

import java.util.List;

public class RequestTradesmanQueryHandler implements QueryHandler<RequestTradesman, List<User>> {

    private final RequestTradesmanService requestTradesmanService;

    public RequestTradesmanQueryHandler(RequestTradesmanService requestTradesmanService) {
        this.requestTradesmanService = requestTradesmanService;
    }

    @Override
    public List<User> handle(RequestTradesman requestTradesman) {
        System.out.println("RequestTradesmans Handler called");
        return requestTradesmanService.findTradesman();
    }
}
