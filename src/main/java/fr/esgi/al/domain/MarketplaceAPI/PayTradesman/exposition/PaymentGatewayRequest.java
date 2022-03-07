package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentGateway;

public class PaymentGatewayRequest {

    public PaymentGateway paymentGateway;

    public PaymentGatewayRequest(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
