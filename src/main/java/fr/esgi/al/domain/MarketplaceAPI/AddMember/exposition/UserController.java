package fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.application.CreateUser;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.application.RetrieveUsers;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.ExpositionErrorHandler;
import fr.esgi.al.kernel.QueryBus;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.Address;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class UserController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public UserController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/users", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponse> getAll() {
        final List<User> users = queryBus.send(new RetrieveUsers());
        UsersResponse usersResponseResult = new UsersResponse(users.stream().map
                (user ->
                        new UserResponse(
                                String.valueOf(user.getId().getValue()),
                                user.getLastname(),
                                user.getFirstname(),
                                new AddressResponse(user.getAddress().getCity())
                        )
                ).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponseResult);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid UserRequest request) {
        CreateUser createUser = new CreateUser(
                request.lastname,
                request.firstname,
                new Address(request.address.city)
        );
        UserId userId = commandBus.send(createUser);
        return ResponseEntity.created(URI.create("/users/" + userId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return ExpositionErrorHandler.getStringStringMap(ex);
    }
}
