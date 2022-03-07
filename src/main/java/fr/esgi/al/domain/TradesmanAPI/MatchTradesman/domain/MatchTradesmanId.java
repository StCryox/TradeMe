package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public class MatchTradesmanId implements ValueObjectID {
    private final int value;

    public MatchTradesmanId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchTradesmanId matchTradesmanId = (MatchTradesmanId) o;
        return value == matchTradesmanId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MatchTradesmanId: " + value;
    }
}
