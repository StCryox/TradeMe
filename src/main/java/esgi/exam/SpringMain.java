package esgi.exam;

import esgi.exam.use_cases.user.application.*;
import esgi.exam.use_cases.user.domain.Address;
import esgi.exam.use_cases.user.domain.User;
import esgi.exam.use_cases.user.domain.UserId;
import esgi.exam.use_cases.user.exposition.AddressResponse;
import fr.esgi.tp1607.use_cases.user.application.*;
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
        CreateUser createUser = new CreateUser("BOISSINOT", "GREGORY", new Address("PARIS"));
        final UserId userId = userCommandHandler.handle(createUser);

        //--2. Modify User Address
        ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = applicationContext.getBean(ModifyUserAddressCommandHandler.class);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getValue(), new AddressResponse("ALFORTVILLE")));

        //--3. Retrieve all users
        RetrieveUsers retrieveUsers = new RetrieveUsers();
        RetrieveUsersHandler retrieveUsersHandler = applicationContext.getBean(RetrieveUsersHandler.class);
        final List<User> users = retrieveUsersHandler.handle(retrieveUsers);
        users.forEach(System.out::println);

        //--4. Retrieve user with ALFORTVILLE city
        RetrieveUsersByCity retrieveUsersByCity = new RetrieveUsersByCity("ALFORTVILLE");
        RetrieveUsersByCityHandler retrieveUsersByCityHandler = applicationContext.getBean(RetrieveUsersByCityHandler.class);
        final List<User> searchedUsers = retrieveUsersByCityHandler.handle(retrieveUsersByCity);
        searchedUsers.forEach(System.out::println);
    }
}
