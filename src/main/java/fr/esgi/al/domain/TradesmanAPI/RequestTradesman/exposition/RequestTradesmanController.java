package fr.esgi.al.domain.TradesmanAPI.RequestTradesman.exposition;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.AddressResponse;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.UserResponse;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.UsersResponse;
import fr.esgi.al.domain.TradesmanAPI.RequestTradesman.application.RequestTradesman;
import fr.esgi.al.kernel.ExpositionErrorHandler;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class RequestTradesmanController {

    private final QueryBus queryBus;

    public RequestTradesmanController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/tradesmans/find", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponse> getAllTradesmans() {
        final List<User> users = queryBus.send(new RequestTradesman());
        UsersResponse usersResponseResult = new UsersResponse(users.stream().map
                (user ->
                        new UserResponse(
                                String.valueOf(user.getId().getValue()),
                                user.getLastname(),
                                user.getFirstname(),
                                String.valueOf(user.getRole()),
                                new AddressResponse(user.getAddress().getCity())
                        )
                ).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponseResult);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return ExpositionErrorHandler.getStringStringMap(ex);
    }
}
