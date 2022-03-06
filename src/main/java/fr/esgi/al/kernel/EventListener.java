package fr.esgi.al.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
