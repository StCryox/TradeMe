package fr.esgi.al.infrastructure;

import fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application.RequestTradesmanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestTradesmanConfiguration {

    public DefaultConfiguration defaultConfiguration() {
        return new DefaultConfiguration();
    }

    @Bean
    RequestTradesmanService requestTradesmansService() {
        return new RequestTradesmanService(defaultConfiguration().marketManager());
    }
}
