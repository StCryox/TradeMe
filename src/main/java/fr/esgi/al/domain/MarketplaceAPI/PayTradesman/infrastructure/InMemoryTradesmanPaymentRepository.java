package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.infrastructure;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPayment;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentRepository;
import fr.esgi.al.kernel.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryTradesmanPaymentRepository implements TradesmanPaymentRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<TradesmanPaymentId, TradesmanPayment> data = new ConcurrentHashMap<>();

    @Override
    public List<TradesmanPayment> findAll() {
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

    @Override
    public void add(TradesmanPayment tradesmanPayment) {
        data.put(tradesmanPayment.id(), tradesmanPayment);
    }

    @Override
    public void delete(TradesmanPaymentId id) {
        data.remove(id);
    }
}
