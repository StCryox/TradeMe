package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

public enum Currency {
    EUR,
    USD,
    SGD,
    INR;

    public static Currency getCurrency(String currency){
        switch (currency) {
            case "EUR":
                return EUR;
            case "USD":
                return USD;
            case "SGD":
                return SGD;
            case "INR":
                return INR;
            default:
                throw new RuntimeException("Must specify a valid currency : EUR, USG, SGD, INR.");
        }
    }
}

