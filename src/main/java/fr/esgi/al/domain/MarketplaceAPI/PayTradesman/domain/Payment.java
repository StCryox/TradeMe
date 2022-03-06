package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

public interface Payment<VOID> {
    PaymentId pay(VOID id,
             Price price,
             PaymentGateway paymentGateway,
             PaymentStrategy paymentStrategy);
    //Pay who, how much, how, when
}
