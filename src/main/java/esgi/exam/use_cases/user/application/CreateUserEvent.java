package esgi.exam.use_cases.user.application;

import esgi.exam.kernel.ApplicationEvent;
import esgi.exam.use_cases.user.domain.UserId;

public class CreateUserEvent implements ApplicationEvent {
    private final UserId userId;

    public CreateUserEvent(UserId userId) {
        this.userId = userId;
    }
}
