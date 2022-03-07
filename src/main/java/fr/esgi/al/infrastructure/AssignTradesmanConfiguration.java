package fr.esgi.al.infrastructure;

import fr.esgi.al.domain.TradesmanAPI.AssignTradesman.application.AssignTradesmanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssignTradesmanConfiguration {
    public DefaultConfiguration defaultConfiguration() {
        return new DefaultConfiguration();
    }

    @Bean
    public AssignTradesmanService assignTradesmanService() {
        return new AssignTradesmanService(defaultConfiguration().contractorManager());
    }
}
