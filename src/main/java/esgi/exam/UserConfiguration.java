package esgi.exam;

import esgi.exam.kernel.*;
import esgi.exam.use_cases.user.application.*;
import esgi.exam.use_cases.user.domain.UserRepository;
import esgi.exam.use_cases.user.infrastructure.DefaultEventDispatcher;
import esgi.exam.use_cases.user.infrastructure.InMemoryUserRepository;
import fr.esgi.tp1607.kernel.*;
import fr.esgi.tp1607.use_cases.user.application.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ModifyUserAddressEvent.class, List.of(new ModifyUserAddressEventListener()));
        listenerMap.put(CreateUserEvent.class, List.of(new CreateUserEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateUserCommandHandler createUserCommandHandler() {
        return new CreateUserCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public ModifyUserAddressCommandHandler modifyUserAddressCommandHandler() {
        return new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateUser.class, new CreateUserCommandHandler(userRepository(), eventEventDispatcher()));
        commandHandlerMap.put(ModifyUserAddress.class, new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveUsers.class, new RetrieveUsersHandler(userRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveUsersHandler retrieveUsersHandler() {
        return new RetrieveUsersHandler(userRepository());
    }

    @Bean
    public RetrieveUsersByCityHandler retrieveUsersByCityHandler() {
        return new RetrieveUsersByCityHandler(userRepository());
    }
}
