package fr.esgi.al.infrastructure;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application.*;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentRepository;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.infrastructure.InMemoryTradesmanPaymentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TradesmanPaymentConfiguration {

    public DefaultConfiguration defaultConfiguration() {
        return new DefaultConfiguration();
    }

    @Bean
    public TradesmanPaymentRepository tradesmanPaymentRepository() {
        return new InMemoryTradesmanPaymentRepository();
    }

    @Bean
    public TradesmanPaymentService tradesmanPaymentService() {
        return new TradesmanPaymentService();
    }

    @Bean
    public CreateTradesmanPaymentCommandHandler createTradesmanPaymentCommandHandler() {
        return new CreateTradesmanPaymentCommandHandler(tradesmanPaymentRepository(), defaultConfiguration().eventEventDispatcher(), tradesmanPaymentService());
    }

    @Bean
    public RetrieveTradesmanPaymentsQueryHandler retrieveTradesmanPayment() {
        return new RetrieveTradesmanPaymentsQueryHandler(tradesmanPaymentRepository(), defaultConfiguration().eventEventDispatcher());
    }

    @Bean
    public RetrieveTradesmanPaymentByTradesmanIdQueryHandler retrieveTradesmanPaymentByTradesmanId() {
        return new RetrieveTradesmanPaymentByTradesmanIdQueryHandler(tradesmanPaymentRepository());
    }
}
