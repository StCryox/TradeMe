package fr.esgi.al.domain.ContractorAPI.GetTradesman.exposition;

import fr.esgi.al.domain.ContractorAPI.CreateProject.domain.ProjectId;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.User;
import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.Currency;
import fr.esgi.al.domain.TradesmanAPI.TradesmanManager;
import fr.esgi.al.kernel.ExpositionErrorHandler;
import fr.esgi.al.kernel.Price;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class GetTradesmanController {

    private final QueryBus queryBus;
    private final TradesmanManager tradesmanManager;

    public GetTradesmanController(QueryBus queryBus, TradesmanManager tradesmanManager) {
        this.queryBus = queryBus;
        this.tradesmanManager = tradesmanManager;
    }

    @GetMapping(path = "/contractor/tradesman", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAll() {
        List<User> users = tradesmanManager.findTradesman();
        ProjectId projectId = new ProjectId(1);
        tradesmanManager.matchTradesman(projectId, new Price(200.0, Currency.EUR));
        List<UserId> usersId = new ArrayList<UserId>();
        users.forEach(user -> usersId.add(user.getId()));
        return ResponseEntity.ok(tradesmanManager.assignTradesman(projectId, usersId));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return ExpositionErrorHandler.getStringStringMap(ex);
    }

}
