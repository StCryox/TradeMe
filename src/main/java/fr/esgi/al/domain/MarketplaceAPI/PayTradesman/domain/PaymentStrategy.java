package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

public enum PaymentStrategy {
    MONTH,
    TRIMESTER,
    YEAR;

    public static PaymentStrategy getStrategy(String strategy){
        switch (strategy) {
            case "Month":
                return MONTH;
            case "Trimester":
                return TRIMESTER;
            case "Year":
                return YEAR;
            default:
                throw new RuntimeException("Must specify a valid payment strategy : Month, Trimester, Year.");
        }
    }
}
