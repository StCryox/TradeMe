package fr.esgi.al.domain.MarketplaceAPI.AddMember.infrastructure;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.*;
import fr.esgi.al.kernel.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<UserId, User> data = new ConcurrentHashMap<>();

    @Override
    public UserId nextIdentity() {
        return new UserId(count.incrementAndGet());
    }

    @Override
    public User findById(UserId id) {
        final User user = data.get(id);
        if (user == null) {
            throw NoSuchEntityException.withId(id);
        }
        return user;
    }

    @Override
    public void add(User user) {
        data.put(user.getId(), user);
    }

    @Override
    public void delete(UserId id) {
        data.remove(id);
    }

    @Override
    public List<User> findAll() {
        System.out.println("\nInMemoryUserRepository findAll function");
        addFakeData();
        return List.copyOf(data.values());
    }

    @Override
    public List<User> findByRole(Role role) {
        System.out.println("\nInMemoryUserRepository findByRole function");
        addFakeData();
        return List.copyOf(data.values().stream()
                .filter(user -> user.getRole().equals(role)).collect(Collectors.toList()));
    }

    private void addFakeData() {
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
        User user3 = new User(
                new UserId(3),
                "Macron",
                "Emmanuel",
                Role.CONTRACTOR,
                new Address("Contractor")
        );
        data.put(user1.getId(), user1);
        data.put(user2.getId(), user2);
        data.put(user3.getId(), user3);
    }
}
