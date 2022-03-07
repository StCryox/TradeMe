package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition;

@SuppressWarnings("all")
public class TradesmanPaymentResponse {

    public String tradesmanPaymentId;
    public String tradesmanId;
    public PriceResponse price;
    public String paymentGateway;
    public String paymentStrategy;

    public TradesmanPaymentResponse(String tradesmanPaymentId, String tradesmanId, PriceResponse price, String paymentGateway, String paymentStrategy) {
        this.tradesmanPaymentId = tradesmanPaymentId;
        this.tradesmanId = tradesmanId;
        this.price = price;
        this.paymentGateway = paymentGateway;
        this.paymentStrategy = paymentStrategy;
    }
}
