package fr.esgi.al.domain.MarketplaceAPI.AddMember.application;

import fr.esgi.al.kernel.EventListener;

public class ModifyUserAddressEventListener implements EventListener<ModifyUserAddressEvent> {
    @Override
    public void listenTo(ModifyUserAddressEvent event) {
        System.out.println("Listening ModifyUserAddressEvent.");
    }
}
