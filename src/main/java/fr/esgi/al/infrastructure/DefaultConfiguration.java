package fr.esgi.al.infrastructure;

import fr.esgi.al.domain.ContractorAPI.ContractorManager;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.application.*;
import fr.esgi.al.domain.MarketplaceAPI.MarketManager;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application.*;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.*;
import fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application.RequestTradesmanQueryHandler;
import fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application.RequestTradesman;
import fr.esgi.al.kernel.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DefaultConfiguration {

    public TradesmanPaymentConfiguration tradesmanPaymentConfiguration() {
        return new TradesmanPaymentConfiguration();
    }

    public UserConfiguration userConfiguration() {
        return new UserConfiguration();
    }

    public RequestTradesmanConfiguration requestTradesmanConfiguration() {
        return new RequestTradesmanConfiguration();
    }

    public MatchTradesmanConfiguration matchTradesmanConfiguration() {
        return new MatchTradesmanConfiguration();
    }

    public MarketManager marketManager() {
        return new MarketManager(userConfiguration().userRepository());
    }

    public ContractorManager contractorManager() {
        return new ContractorManager();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateUserEvent.class, List.of(new CreateUserEventListener()));
        listenerMap.put(CreateTradesmanPaymentEvent.class, List.of(new CreateTradesmanPaymentEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateUser.class, new CreateUserCommandHandler(userConfiguration().userRepository(), eventEventDispatcher()));
        commandHandlerMap.put(CreateTradesmanPayment.class, new CreateTradesmanPaymentCommandHandler(tradesmanPaymentConfiguration().tradesmanPaymentRepository(), eventEventDispatcher(), tradesmanPaymentConfiguration().tradesmanPaymentService()));
        commandHandlerMap.put(CreateMatchTradesman.class, new CreateMatchTradesmanCommandHandler(matchTradesmanConfiguration().matchTradesmanRepository(), matchTradesmanConfiguration().matchTradesmanService(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveUsers.class, new RetrieveUsersHandler(userConfiguration().userRepository()));
        queryHandlerMap.put(RetrieveUsersByRole.class, new RetrieveUsersByRoleHandler(userConfiguration().userRepository()));
        queryHandlerMap.put(RetrieveTradesmanPayments.class, new RetrieveTradesmanPaymentsQueryHandler(tradesmanPaymentConfiguration().tradesmanPaymentRepository(), eventEventDispatcher()));
        queryHandlerMap.put(RetrieveTradesmanPaymentByTradesmanId.class, new RetrieveTradesmanPaymentByTradesmanIdQueryHandler(tradesmanPaymentConfiguration().tradesmanPaymentRepository()));
        queryHandlerMap.put(RequestTradesman.class, new RequestTradesmanQueryHandler(requestTradesmanConfiguration().requestTradesmansService()));
        queryHandlerMap.put(MatchTradesmanQuery.class, new MatchTradesmanQueryHandler(matchTradesmanConfiguration().matchTradesmanRepository()));
        queryHandlerMap.put(MatchTradesmanById.class, new MatchTradesmanByIdQueryHandler(matchTradesmanConfiguration().matchTradesmanRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }
}
