package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Address;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserRepository;

public final class CreateUserCommandHandler implements CommandHandler<CreateUser, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public UserId handle(CreateUser createUser) {
        final UserId userId = userRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, createUser.role, new Address(createUser.address.getCity()));
        userRepository.add(user);
        eventEventDispatcher.dispatch(new CreateUserEvent(userId));
        return userId;
    }
}
