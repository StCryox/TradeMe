package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.exposition;

import fr.esgi.al.domain.MarketplaceAPI.AddMember.domain.UserId;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application.CreateTradesmanPayment;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.application.RetrieveTradesmanPayments;
import fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain.*;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.ExpositionErrorHandler;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class TradesmanPaymentController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public TradesmanPaymentController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/payments", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TradesmanPaymentsResponse> getAll() {
        final List<TradesmanPayment> tradesmanPayments = queryBus.send(new RetrieveTradesmanPayments());
        TradesmanPaymentsResponse tradesmanPaymentsResponseResult = new TradesmanPaymentsResponse(tradesmanPayments.stream().map
                (tradesmanPayment ->
                        new TradesmanPaymentResponse(
                                String.valueOf(tradesmanPayment.getTradesmanPaymentId().getValue()),
                                String.valueOf(tradesmanPayment.getTradesmanId().getValue()),
                                new PriceResponse(
                                        tradesmanPayment.getPrice().getPrice(),
                                        tradesmanPayment.getPrice().getCurrency()
                                ),
                                String.valueOf(tradesmanPayment.getPaymentGateway()),
                                String.valueOf(tradesmanPayment.getPaymentStrategy())
                        )
                ).collect(Collectors.toList()));
        return ResponseEntity.ok(tradesmanPaymentsResponseResult);
    }

    @PostMapping(path = "/payments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid TradesmanPaymentRequest request) {
        CreateTradesmanPayment createTradesmanPayment = new CreateTradesmanPayment(
                new UserId(request.tradesmanId),
                new Price(request.price.price, request.price.currency),
                PaymentGateway.getGateway(request.paymentGateway),
                PaymentStrategy.getStrategy(request.paymentStrategy)
        );
        TradesmanPaymentId tradesmanPaymentId = commandBus.send(createTradesmanPayment);
        return ResponseEntity.created(URI.create("/payments/" + tradesmanPaymentId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return ExpositionErrorHandler.getStringStringMap(ex);
    }
}
