package fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.kernel.QueryHandler;

import java.util.List;

public class RequestTradesmanQueryHandler implements QueryHandler<RequestTradesmans, List<User>> {

    private final RequestTradesmansService requestTradesmansService;

    public RequestTradesmanQueryHandler(RequestTradesmansService requestTradesmansService) {
        this.requestTradesmansService = requestTradesmansService;
    }

    @Override
    public List<User> handle(RequestTradesmans requestTradesmans) {
        System.out.println("RequestTradesmans Handler called");
        return requestTradesmansService.findTradesmans();
    }
}
