package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentGateway;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentStrategy;
import fr.esgi.al.kernel.Price;
import fr.esgi.al.kernel.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateTradesmanPayment implements Command {

    public final UserId tradesmanId;
    public final Price price;
    public final PaymentGateway paymentGateway;
    public final PaymentStrategy paymentStrategy;

    public CreateTradesmanPayment(UserId tradesmanId, Price price, PaymentGateway paymentGateway, PaymentStrategy paymentStrategy) {
        this.tradesmanId = tradesmanId;
        this.price = price;
        this.paymentGateway = paymentGateway;
        this.paymentStrategy = paymentStrategy;
    }
}
