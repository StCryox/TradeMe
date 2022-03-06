package fr.esgi.al.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
