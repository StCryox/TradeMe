package fr.esgi.al;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.application.*;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Address;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.AddressResponse;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application.CreateTradesmanPayment;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application.CreateTradesmanPaymentCommandHandler;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        //--1. Create User
        CreateUserCommandHandler userCommandHandler = applicationContext.getBean(CreateUserCommandHandler.class);
        CreateUser createUser = new CreateUser("NGUYEN", "Ifzas", new Address("PARIS"));
        final UserId userId = userCommandHandler.handle(createUser);

        //--2. Modify User Address
        ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = applicationContext.getBean(ModifyUserAddressCommandHandler.class);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getValue(), new AddressResponse("ALFORTVILLE")));

        // Create Payment
        CreateTradesmanPaymentCommandHandler paymentCommandHandler = applicationContext.getBean(CreateTradesmanPaymentCommandHandler.class);
        CreateTradesmanPayment createTradesmanPayment = new CreateTradesmanPayment(
                userId,
                new Price(100.50, Currency.EUR),
                PaymentGateway.PAYPAL,
                PaymentStrategy.MONTH
        );
        final TradesmanPaymentId tradesmanPaymentId = paymentCommandHandler.handle(createTradesmanPayment);

        //--3. Retrieve all users
        RetrieveUsers retrieveUsers = new RetrieveUsers();
        RetrieveUsersHandler retrieveUsersHandler = applicationContext.getBean(RetrieveUsersHandler.class);
        final List<User> users = retrieveUsersHandler.handle(retrieveUsers);
        users.forEach(System.out::println);
    }
}
