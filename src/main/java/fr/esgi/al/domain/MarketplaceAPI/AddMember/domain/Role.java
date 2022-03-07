package fr.esgi.al.domain.MarketplaceAPI.AddMember.domain;

public enum Role {
    CONTRACTOR,
    TRADESMAN,
    TRAINER;

    public static Role getRole(String role){
        switch (role) {
            case "Contractor":
                return CONTRACTOR;
            case "Tradesman":
                return TRADESMAN;
            case "Trainer":
                return TRAINER;
            default:
                throw new RuntimeException("Must specify a valid user role : Contractor, Tradesman, Trainer.");
        }
    }

}
