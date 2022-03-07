package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public class PaymentId implements ValueObjectID {
    private final int value;

    public PaymentId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId paymentId = (PaymentId) o;
        return value == paymentId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PaymentId: " + value;
    }
}
