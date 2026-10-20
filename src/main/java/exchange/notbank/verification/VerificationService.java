package exchange.notbank.verification;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import exchange.notbank.core.EndpointCategory;
import exchange.notbank.core.NotbankConnection;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.ParamBuilder;
import exchange.notbank.verification.constants.Endpoints;
import exchange.notbank.verification.paramBuilders.GetVerificationStatusParamBuilder;
import exchange.notbank.verification.responses.VerificationStatus;
import io.vavr.control.Either;

public class VerificationService {
  private final Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection;
  private final VerificationServiceResponseAdapter responseAdapter;

  public VerificationService(Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection,
      VerificationServiceResponseAdapter responseAdapter) {
    this.getNotbankConnection = getNotbankConnection;
    this.responseAdapter = responseAdapter;
  }

  private <T> CompletableFuture<T> requestGet(String endpoint, ParamBuilder paramBuilder,
      Function<String, Either<NotbankException, T>> deserializeFn) {
    return getNotbankConnection.get()
        .thenCompose(
            connection -> connection.requestGet(EndpointCategory.NB, endpoint, paramBuilder, deserializeFn));
  }

  /**
   * https://docs.notbank.exchange/#getverificationstatusv2
   */
  public CompletableFuture<VerificationStatus> getVerificationStatus(GetVerificationStatusParamBuilder paramBuilder) {
    return requestGet(Endpoints.VERIFICATION_STATUS_V2, paramBuilder, responseAdapter::toVerificationStatus);
  }
}
