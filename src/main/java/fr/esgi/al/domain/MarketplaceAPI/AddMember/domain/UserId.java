package fr.esgi.al.domain.MarketplaceAPI.AddMember.domain;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public class UserId implements ValueObjectID {
    private final int value;

    public UserId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return value == userId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "UserId: " + value;
    }
}
