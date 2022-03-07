package fr.esgi.al.infrastructure;

import fr.esgi.al.domain.ContractorAPI.GetTradesman.exposition.GetTradesmanController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContractorConfiguration {
    public DefaultConfiguration defaultConfiguration() {
        return new DefaultConfiguration();
    }

}
