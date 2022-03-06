package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

public class Price {
    private final double price;
    private final Currency currency;

    public Price(double price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "" + price + " " + currency;
    }

    public Currency getCurrency() {
        return currency;
    }
}
