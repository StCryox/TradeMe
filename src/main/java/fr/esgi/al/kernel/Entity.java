package fr.esgi.al.kernel;

@SuppressWarnings("all")
public interface Entity<VOID extends ValueObjectID> {
    VOID id();
}
