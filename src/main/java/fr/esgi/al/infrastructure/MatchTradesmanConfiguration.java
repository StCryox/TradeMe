package fr.esgi.al.infrastructure;

import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.MatchTradesmanService;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanRepository;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.infrastructure.InMemoryMatchTradesmanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatchTradesmanConfiguration {
    public DefaultConfiguration defaultConfiguration() {
        return new DefaultConfiguration();
    }

    @Bean
    public MatchTradesmanService matchTradesmanService() {
        return new MatchTradesmanService(defaultConfiguration().marketManager(), defaultConfiguration().contractorManager());
    }

    @Bean
    public MatchTradesmanRepository matchTradesmanRepository() {
        return new InMemoryMatchTradesmanRepository();
    }
}
