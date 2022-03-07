package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.domain;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.kernel.ValueObjectID;

import java.util.List;
import java.util.Objects;

public class UsersId implements ValueObjectID {
    private final List<UserId> usersId;

    public UsersId(List<UserId> usersId) {
        this.usersId = usersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersId usersId1 = (UsersId) o;
        return Objects.equals(usersId, usersId1.usersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersId);
    }

    public List<UserId> getUsersId() {
        return usersId;
    }

    @Override
    public String toString() {
        return "UsersId: " + usersId;
    }
}
