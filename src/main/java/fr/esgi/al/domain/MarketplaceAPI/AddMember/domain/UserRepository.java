package fr.esgi.al.domain.MarketplaceAPI.AddMember.domain;

import fr.esgi.al.kernel.Repository;

import java.util.List;

public interface UserRepository extends Repository<UserId, User> {
    List<User> findAll();

    List<User> findByRole(Role role);
}
