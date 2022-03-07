package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.exposition;

import javax.validation.constraints.NotNull;

public class AssignTradesmanRequest {

    @NotNull
    public int projectId;

    @NotNull
    public UsersIdRequest usersId;

}
