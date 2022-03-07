package fr.esgi.al.infrastructure;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.application.*;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserRepository;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.infrastructure.InMemoryUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfiguration {

    public DefaultConfiguration defaultConfiguration() {
        return new DefaultConfiguration();
    }

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public CreateUserCommandHandler createUserCommandHandler() {
        return new CreateUserCommandHandler(userRepository(), defaultConfiguration().eventEventDispatcher());
    }

    @Bean
    public RetrieveUsersHandler retrieveUsersHandler() {
        return new RetrieveUsersHandler(userRepository());
    }

    @Bean
    public RetrieveUsersByRoleHandler retrieveUsersByRoleHandler() {
        return new RetrieveUsersByRoleHandler(userRepository());
    }
}
