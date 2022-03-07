package fr.esgi.al.kernel;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentGateway;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentStrategy;

public interface Payment<VOID> {
    PaymentId pay(VOID id,
                  Price price,
                  PaymentGateway paymentGateway,
                  PaymentStrategy paymentStrategy);
    //Pay who, how much, how, when
}
