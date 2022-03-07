package fr.esgi.al.domain.TradesmanAPI.MatchTradesman.exposition;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.AddressResponse;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.UserResponse;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.UsersResponse;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.CreateMatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.MatchTradesmanById;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.MatchTradesmanQuery;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.ExpositionErrorHandler;
import fr.esgi.al.kernel.Price;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class MatchTradesmanController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public MatchTradesmanController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/tradesmans/match", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MatchTradesmansResponse> getAll() {
        final List<MatchTradesman> matchedTradesmens = queryBus.send(new MatchTradesmanQuery());
        MatchTradesmansResponse matchTradesmansResponse =  new MatchTradesmansResponse(matchedTradesmens.stream().map
                (matchedTradesman ->
                        new MatchTradesmanResponse(
                                matchedTradesman.id(),
                                matchedTradesman.getTradesmans()
                        )
                ).collect(Collectors.toList()));
        return ResponseEntity.ok(matchTradesmansResponse);
    }

    @PostMapping(path = "/tradesmans/match", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersResponse> create(@RequestBody @Valid MatchTradesmanRequest request) {
        CreateMatchTradesman createMatchTradesman = new CreateMatchTradesman(
                new ProjectId(request.projectId),
                new Price(request.price.price, request.price.currency)
        );
        MatchTradesmanId matchTradesmanId = commandBus.send(createMatchTradesman);
        final List<User> matchedTradesmens = queryBus.send(new MatchTradesmanById(matchTradesmanId));
        UsersResponse usersResponse =  new UsersResponse(matchedTradesmens.stream().map
                (matchedTradesman ->
                        new UserResponse(
                                String.valueOf(matchedTradesman.getId().getValue()),
                                matchedTradesman.getLastname(),
                                matchedTradesman.getFirstname(),
                                String.valueOf(matchedTradesman.getRole()),
                                new AddressResponse(matchedTradesman.getAddress().getCity())
                        )
                ).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return ExpositionErrorHandler.getStringStringMap(ex);
    }
}
