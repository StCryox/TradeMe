package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.QueryHandler;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserRepository;

import java.util.List;

public class RetrieveUsersByCityHandler implements QueryHandler<RetrieveUsersByCity, List<User>> {

    private final UserRepository userRepository;

    public RetrieveUsersByCityHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUsersByCity query) {
        return userRepository.findByCity(query.city);
    }
}
