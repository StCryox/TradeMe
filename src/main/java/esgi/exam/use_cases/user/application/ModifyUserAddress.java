package esgi.exam.use_cases.user.application;

import esgi.exam.use_cases.user.exposition.AddressResponse;
import esgi.exam.kernel.Command;

public class ModifyUserAddress implements Command {

    public final int userId;
    public final AddressResponse address;

    public ModifyUserAddress(int userId, AddressResponse address) {
        this.userId = userId;
        this.address = address;
    }
}
