package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

public enum PaymentGateway {
    BANK_CARD,
    BANK_TRANSFER,
    PAYPAL;

    public static PaymentGateway getGateway(String gateway){
        switch (gateway) {
            case "Paypal":
                return PAYPAL;
            case "Card":
                return BANK_CARD;
            case "Bank":
                return BANK_TRANSFER;
            default:
                throw new RuntimeException("Must specify a valid payment gateway: Paypal, Card, Bank.");
        }
    }

}
