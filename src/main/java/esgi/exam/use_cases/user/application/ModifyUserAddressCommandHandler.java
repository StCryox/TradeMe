package esgi.exam.use_cases.user.application;

import esgi.exam.kernel.CommandHandler;
import esgi.exam.kernel.Event;
import esgi.exam.kernel.EventDispatcher;
import esgi.exam.use_cases.user.domain.Address;
import esgi.exam.use_cases.user.domain.UserId;
import esgi.exam.use_cases.user.domain.UserRepository;

public class ModifyUserAddressCommandHandler implements CommandHandler<ModifyUserAddress, Void> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyUserAddressCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyUserAddress command) {
        var userId = new UserId(command.userId);
        var user = userRepository.findById(userId);
        var address = new Address(command.address.city);
        user.changeAddress(address);
        userRepository.add(user);
        eventEventDispatcher.dispatch(new ModifyUserAddressEvent(userId));
        return null;
    }
}
