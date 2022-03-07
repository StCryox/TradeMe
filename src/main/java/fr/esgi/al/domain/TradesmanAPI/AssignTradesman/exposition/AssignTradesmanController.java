package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.exposition;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.AddressResponse;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.UserResponse;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.exposition.UsersResponse;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application.CreateTradesmanPayment;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentGateway;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.PaymentStrategy;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.TradesmanPaymentId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition.TradesmanPaymentRequest;
import fr.esgi.al.domain.TradesmanAPI.AssignTradesman.application.CreateAssignTradesman;
import fr.esgi.al.domain.TradesmanAPI.AssignTradesman.domain.UsersId;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.CreateMatchTradesman;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.application.MatchTradesmanById;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.domain.MatchTradesmanId;
import fr.esgi.al.domain.TradesmanAPI.MatchTradesman.exposition.MatchTradesmanRequest;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.ExpositionErrorHandler;
import fr.esgi.al.kernel.Price;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class AssignTradesmanController {

    private final CommandBus commandBus;

    public AssignTradesmanController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping(path = "/tradesmans/assign", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersId> create(@RequestBody @Valid AssignTradesmanRequest request) {
        System.out.println("userId: " + request.usersId.usersId);
        CreateAssignTradesman createAssignTradesman = new CreateAssignTradesman(
                new ProjectId(request.projectId),
                request.usersId.usersId.getUsersId()
        );
        UsersId usersId = commandBus.send(createAssignTradesman);
        return ResponseEntity.created(URI.create("/tradesmans/assign/" + usersId.getUsersId())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return ExpositionErrorHandler.getStringStringMap(ex);
    }
}
