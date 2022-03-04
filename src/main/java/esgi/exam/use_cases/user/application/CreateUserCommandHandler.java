package esgi.exam.use_cases.user.application;

import esgi.exam.kernel.CommandHandler;
import esgi.exam.kernel.Event;
import esgi.exam.kernel.EventDispatcher;
import esgi.exam.use_cases.user.domain.Address;
import esgi.exam.use_cases.user.domain.User;
import esgi.exam.use_cases.user.domain.UserId;
import esgi.exam.use_cases.user.domain.UserRepository;

public final class CreateUserCommandHandler implements CommandHandler<CreateUser, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public UserId handle(CreateUser createUser) {
        final UserId userId = userRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, new Address(createUser.address.getCity()));
        userRepository.add(user);
        eventEventDispatcher.dispatch(new CreateUserEvent(userId));
        return userId;
    }
}
