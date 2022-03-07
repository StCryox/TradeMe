package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.exposition;

import javax.validation.constraints.NotNull;

public class MatchTradesmanRequest {

    @NotNull
    public int projectId;

    @NotNull
    public PriceRequest price;

}
