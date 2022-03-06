package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.kernel.Query;

public class RetrieveTradesmanPaymentByTradesmanId implements Query {
    public final UserId tradesmanId;

    public RetrieveTradesmanPaymentByTradesmanId(UserId tradesmanId) {
        this.tradesmanId = tradesmanId;
    }
}
