package exchange.notbank.utils;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import exchange.notbank.core.EndpointCategory;
import exchange.notbank.core.NotbankConnection;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.ParamBuilder;
import exchange.notbank.utils.constants.Endpoints;
import exchange.notbank.utils.UtilsServiceResponseAdapter;
import exchange.notbank.utils.paramBuilders.GetProvincesParamBuilder;
import io.vavr.control.Either;

public class UtilsService {
  private final Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection;
  private final UtilsServiceResponseAdapter responseAdapter;

  public UtilsService(Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection,
      UtilsServiceResponseAdapter responseAdapter) {
    this.getNotbankConnection = getNotbankConnection;
    this.responseAdapter = responseAdapter;
  }

  private <T> CompletableFuture<T> requestPost(String endpoint, ParamBuilder paramBuilder,
      Function<String, Either<NotbankException, T>> deserializeFn) {
    return getNotbankConnection.get()
        .thenCompose(
            connection -> connection.requestPost(EndpointCategory.NB, endpoint, paramBuilder, deserializeFn));
  }

  private <T> CompletableFuture<T> requestGet(String endpoint, ParamBuilder paramBuilder,
      Function<String, Either<NotbankException, T>> deserializeFn) {
    return getNotbankConnection.get()
        .thenCompose(
            connection -> connection.requestGet(EndpointCategory.NB, endpoint, paramBuilder, deserializeFn));
  }

  /**
   * https://apidoc.notbank.exchange/?http#getprovinces
   */
  public CompletableFuture<List<String>> getProvinces(GetProvincesParamBuilder paramBuilder) {
    return requestGet(Endpoints.PROVINCES, paramBuilder, responseAdapter::toProvinceList);
  }

}
