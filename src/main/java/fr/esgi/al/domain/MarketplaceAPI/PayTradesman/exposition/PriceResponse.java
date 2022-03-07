package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.Currency;

public class PriceResponse {

    public final double price;
    public final Currency currency;

    public PriceResponse(double price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PriceResponse{" +
                "price=" + price +
                ", currency=" + currency +
                '}';
    }
}
