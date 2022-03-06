package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.Currency;

public class PriceRequest {

    public double price;
    public Currency currency;

    @Override
    public String toString() {
        return "PriceRequest{" +
                "price=" + price +
                ", currency=" + currency +
                '}';
    }
}
