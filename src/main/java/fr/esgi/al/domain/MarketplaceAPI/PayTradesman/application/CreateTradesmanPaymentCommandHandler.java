package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application;

import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPayment;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentRepository;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

public final class CreateTradesmanPaymentCommandHandler implements CommandHandler<CreateTradesmanPayment, TradesmanPaymentId> {

    private final TradesmanPaymentRepository tradesmanPaymentRepository;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final TradesmanPaymentService tradesmanPaymentService;

    public CreateTradesmanPaymentCommandHandler(TradesmanPaymentRepository tradesmanPaymentRepository, EventDispatcher<Event> eventEventDispatcher, TradesmanPaymentService tradesmanPaymentService) {
        this.tradesmanPaymentRepository = tradesmanPaymentRepository;
        this.eventEventDispatcher = eventEventDispatcher;
        this.tradesmanPaymentService = tradesmanPaymentService;
    }

    public TradesmanPaymentId handle(CreateTradesmanPayment createTradesmanPayment) {
        final PaymentId paymentId = tradesmanPaymentService.pay(createTradesmanPayment.tradesmanId, createTradesmanPayment.price, createTradesmanPayment.paymentGateway, createTradesmanPayment.paymentStrategy);
        final TradesmanPaymentId tradesmanPaymentId = new TradesmanPaymentId(paymentId.getValue());
        TradesmanPayment tradesmanPayment = new TradesmanPayment(tradesmanPaymentId, createTradesmanPayment.tradesmanId, createTradesmanPayment.price, createTradesmanPayment.paymentGateway, createTradesmanPayment.paymentStrategy);
        tradesmanPaymentRepository.add(tradesmanPayment);
        eventEventDispatcher.dispatch(new CreateTradesmanPaymentEvent(tradesmanPaymentId));
        return tradesmanPaymentId;
    }
}
