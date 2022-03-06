package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.infrastructure;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.*;
import fr.esgi.al.kernel.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryTradesmanPaymentRepository implements TradesmanPaymentRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private Map<TradesmanPaymentId, TradesmanPayment> data = new ConcurrentHashMap<>();

    @Override
    public void add(TradesmanPayment tradesmanPayment) {
        System.out.println("\nInMemoryTradesmanPaymentRepository add function");
        System.out.println("TradesmanPayment toString");
        System.out.println(tradesmanPayment.toString());
        data.put(tradesmanPayment.id(), tradesmanPayment);
        System.out.println("\ndata after adding");
        System.out.println(data.values());
        System.out.println("add end\n");
    }

    @Override
    public void delete(TradesmanPaymentId id) {
        data.remove(id);
    }

    @Override
    public List<TradesmanPayment> findAll() {
        System.out.println("\nInMemoryTradesmanPaymentRepository findAll function");
        System.out.println("Date before manually adding");
        System.out.println(data.values());
        TradesmanPayment tradesmanPayment = new TradesmanPayment(
                new TradesmanPaymentId(5),
                new UserId(5),
                new Price(10000.0, Currency.EUR),
                PaymentGateway.BANK_TRANSFER,
                PaymentStrategy.TRIMESTER
        );
        TradesmanPayment tradesmanPayment2 = new TradesmanPayment(
                new TradesmanPaymentId(6),
                new UserId(50),
                new Price(1000.0, Currency.EUR),
                PaymentGateway.BANK_TRANSFER,
                PaymentStrategy.TRIMESTER
        );
        data.put(tradesmanPayment.id(), tradesmanPayment);
        data.put(tradesmanPayment2.id(), tradesmanPayment2);
        System.out.println("\ndata after put");
        System.out.println(data.values());
        System.out.println("findAll end\n");
        return List.copyOf(data.values());
    }

    @Override
    public List<TradesmanPayment> findByTradesmanId(UserId tradesmanId) {
        return List.copyOf(data.values().stream()
                .filter(tradesmanPayment -> tradesmanPayment.getTradesmanId().equals(tradesmanId)).collect(Collectors.toList()));
    }

    @Override
    public TradesmanPaymentId nextIdentity() {
        return new TradesmanPaymentId(count.incrementAndGet());
    }

    @Override
    public TradesmanPayment findById(TradesmanPaymentId id) throws NoSuchEntityException {
        final TradesmanPayment tradesmanPayment = data.get(id);
        if(tradesmanPayment == null){
            throw new RuntimeException("No payment found with id: " + id.getValue());
        }
        return tradesmanPayment;
    }
}
