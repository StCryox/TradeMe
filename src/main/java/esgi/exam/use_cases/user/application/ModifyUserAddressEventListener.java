package esgi.exam.use_cases.user.application;

import esgi.exam.kernel.EventListener;

public class ModifyUserAddressEventListener implements EventListener<ModifyUserAddressEvent> {
    @Override
    public void listenTo(ModifyUserAddressEvent event) {
        System.out.println("Listening ModifyUserAddressEvent.");
    }
}
