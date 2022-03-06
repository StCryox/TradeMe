package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Address;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserRepository;

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
