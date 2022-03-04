package esgi.exam.use_cases.user.application;

import esgi.exam.kernel.EventListener;

public class CreateUserEventListener implements EventListener<CreateUserEvent> {
    @Override
    public void listenTo(CreateUserEvent event) {
        System.out.println("listening CreateUserEvent.");
    }
}
