package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.QueryHandler;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserRepository;

import java.util.List;

public class RetrieveUsersByRoleHandler implements QueryHandler<RetrieveUsersByRole, List<User>> {

    private final UserRepository userRepository;

    public RetrieveUsersByRoleHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUsersByRole query) {
        return userRepository.findByRole(query.role);
    }
}
