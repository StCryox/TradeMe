package fr.esgi.al.domain.MarketplaceAPI;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Role;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserRepository;

import java.util.List;

public class MarketManager {
    private UserRepository userRepository;

    public MarketManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllTrademan() {
        return userRepository.findByRole(Role.TRADESMAN);
    }
}
