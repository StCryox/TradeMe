package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

import fr.esgi.al.kernel.ValueObjectID;
import java.util.Objects;

public class TradesmanPaymentId implements ValueObjectID {
    private final int value;

    public TradesmanPaymentId(int value) {
            this.value = value;
        }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesmanPaymentId tradesmanPaymentId = (TradesmanPaymentId) o;
        return value == tradesmanPaymentId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TradesmanId: " + value;
    }
}
