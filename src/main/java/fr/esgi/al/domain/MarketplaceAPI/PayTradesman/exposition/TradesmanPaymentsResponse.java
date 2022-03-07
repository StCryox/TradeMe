package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public class TradesmanPaymentsResponse {
    public final List<TradesmanPaymentResponse> tradesmanPayments;

    public TradesmanPaymentsResponse(List<TradesmanPaymentResponse> tradesmanPayments) {
        this.tradesmanPayments = tradesmanPayments;
    }
}
