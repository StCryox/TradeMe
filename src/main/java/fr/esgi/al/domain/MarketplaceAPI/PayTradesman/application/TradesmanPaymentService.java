package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.*;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentDate;
import fr.esgi.al.kernel.Payment;
import fr.esgi.al.kernel.Price;

import java.util.concurrent.atomic.AtomicInteger;

public class TradesmanPaymentService implements Payment<UserId> {
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public PaymentId pay(UserId id,
                    Price price,
                    PaymentGateway paymentGateway,
                    PaymentStrategy paymentStrategy) {
        switch (paymentStrategy){
            case YEAR:
                return payYearly(id, price, paymentGateway);
            case TRIMESTER:
                return payEveryTreeMonth(id, price, paymentGateway);
            case MONTH:
            default:
                return payMonthly(id, price, paymentGateway);
        }
    }

    private PaymentId payYearly(UserId tradesmanId, Price price, PaymentGateway paymentGateway){
        System.out.println("Paiement annuel"
                + " à  " + tradesmanId.toString()
                + " de " + price.toString()
                + " via " + paymentGateway
                + " le " + PaymentDate.now()
                + ".\nProchain paiement le " + PaymentDate.nextMonth()
        );
        return new PaymentId(count.incrementAndGet());
    }

    private PaymentId payEveryTreeMonth(UserId tradesmanId, Price price, PaymentGateway paymentGateway){
        System.out.println("Paiement trimestrielle"
                + " à  " + tradesmanId.toString()
                + " de " + price.toString()
                + " via " + paymentGateway
                + " le " + PaymentDate.now()
                + ".\nProchain paiement le " + PaymentDate.nextMonth()
        );
        return new PaymentId(count.incrementAndGet());
    }

    private PaymentId payMonthly(UserId tradesmanId, Price price, PaymentGateway paymentGateway){
        System.out.println("Paiement mensuelle"
                + " à  " + tradesmanId.toString()
                + " de " + price.toString()
                + " via " + paymentGateway
                + " le " + PaymentDate.now()
                + ".\nProchain paiement le " + PaymentDate.nextMonth()
        );
        return new PaymentId(count.incrementAndGet());
    }
}
