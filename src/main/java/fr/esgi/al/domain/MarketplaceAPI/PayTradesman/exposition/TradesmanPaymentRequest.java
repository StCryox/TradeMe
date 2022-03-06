package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TradesmanPaymentRequest {

    @NotNull
    public int tradesmanId;

    @NotNull
    public PriceRequest price;

    @NotNull
    @NotBlank
    public String paymentGateway;

    @NotNull
    @NotBlank
    public String paymentStrategy;

}
