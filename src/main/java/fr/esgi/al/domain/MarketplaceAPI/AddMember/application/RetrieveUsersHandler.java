package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.QueryHandler;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserRepository;

import java.util.List;

public class RetrieveUsersHandler implements QueryHandler<RetrieveUsers, List<User>> {

    private final UserRepository userRepository;

    public RetrieveUsersHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUsers query) {
        return userRepository.findAll();
    }
}
