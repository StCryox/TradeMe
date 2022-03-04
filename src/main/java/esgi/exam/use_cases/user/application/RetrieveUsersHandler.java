package esgi.exam.use_cases.user.application;

import esgi.exam.kernel.QueryHandler;
import esgi.exam.use_cases.user.domain.User;
import esgi.exam.use_cases.user.domain.UserRepository;

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
