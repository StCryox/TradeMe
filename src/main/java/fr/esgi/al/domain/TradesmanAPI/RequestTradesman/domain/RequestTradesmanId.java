package fr.esgi.al.domain.TradesmanAPI.RequestTradesman.domain;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public class RequestTradesmanId implements ValueObjectID {
    private final int value;

    public RequestTradesmanId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestTradesmanId that = (RequestTradesmanId) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TradesmanRequestId: " + value;
    }
}
