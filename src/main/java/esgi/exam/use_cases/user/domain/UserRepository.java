package esgi.exam.use_cases.user.domain;

import esgi.exam.kernel.Repository;

import java.util.List;

public interface UserRepository extends Repository<UserId, User> {
    List<User> findAll();

    List<User> findByCity(String city);
}
