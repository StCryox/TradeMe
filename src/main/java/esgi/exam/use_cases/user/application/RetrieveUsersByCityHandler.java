package esgi.exam.use_cases.user.application;

import esgi.exam.kernel.QueryHandler;
import esgi.exam.use_cases.user.domain.User;
import esgi.exam.use_cases.user.domain.UserRepository;

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
