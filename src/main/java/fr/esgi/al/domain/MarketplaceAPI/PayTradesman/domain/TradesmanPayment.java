package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.kernel.Entity;
import fr.esgi.al.kernel.Price;

public class TradesmanPayment implements Entity<TradesmanPaymentId> {
    private TradesmanPaymentId tradesmanPaymentId;
    private UserId tradesmanId;
    private Price price;
    private PaymentGateway paymentGateway;
    private PaymentStrategy paymentStrategy;

    public TradesmanPayment(TradesmanPaymentId tradesmanPaymentId, UserId tradesmanId, Price price, PaymentGateway paymentGateway, PaymentStrategy paymentStrategy) {
        this.tradesmanPaymentId = tradesmanPaymentId;
        this.tradesmanId = tradesmanId;
        this.price = price;
        this.paymentGateway = paymentGateway;
        this.paymentStrategy = paymentStrategy;
    }

    public UserId getTradesmanId() {
        return tradesmanId;
    }

    public TradesmanPaymentId getTradesmanPaymentId() {
        return tradesmanPaymentId;
    }

    public Price getPrice() {
        return price;
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    @Override
    public TradesmanPaymentId id() {
        return tradesmanPaymentId;
    }

    @Override
    public String toString() {
        return "TradesmanPayment{" +
                "tradesmanPaymentId=" + tradesmanPaymentId +
                ", tradesmanId=" + tradesmanId +
                ", price=" + price +
                ", paymentGateway=" + paymentGateway +
                ", paymentStrategy=" + paymentStrategy +
                '}';
    }
}
