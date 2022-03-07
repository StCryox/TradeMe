package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.infrastructure;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Address;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Role;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.*;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanRepository;
import fr.esgi.al.kernel.NoSuchEntityException;
import fr.esgi.al.kernel.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryMatchTradesmanRepository implements MatchTradesmanRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<MatchTradesmanId, MatchTradesman> data = new ConcurrentHashMap<>();

    @Override
    public MatchTradesmanId nextIdentity() {
        return new MatchTradesmanId(count.incrementAndGet());
    }

    @Override
    public void add(MatchTradesman matchTradesman) {
        data.put(matchTradesman.id(), matchTradesman);
    }

    @Override
    public void delete(MatchTradesmanId id) {
        data.remove(id);
    }

    @Override
    public MatchTradesman findById(MatchTradesmanId id) throws NoSuchEntityException {
        System.out.println("InMemoryMatchTradesmanRepository findById");
        addFakeData(id);
        final MatchTradesman matchTradesman = data.get(id);
        if(matchTradesman == null){
            return new MatchTradesman(id, new ArrayList<User>());
        }
        return matchTradesman;
    }

    @Override
    public List<MatchTradesman> findAll() {
        return List.copyOf(data.values());
    }

    private void addFakeData(MatchTradesmanId id) {
        System.out.println("Manually adding data");
        User user1 = new User(
                new UserId(1),
                "Nguyen",
                "Ifzas",
                Role.TRADESMAN,
                new Address("Romainville")
        );
        User user2 = new User(
                new UserId(2),
                "Benadjaoud",
                "Wissam",
                Role.TRADESMAN,
                new Address("Paris")
        );
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        MatchTradesman matchTradesman = new MatchTradesman(
                id,
                users
        );
        data.put(id, matchTradesman);
    }
}
