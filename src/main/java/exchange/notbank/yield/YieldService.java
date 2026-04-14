package exchange.notbank.yield;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.List;

import exchange.notbank.core.EndpointCategory;
import exchange.notbank.core.NotbankConnection;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.ParamBuilder;
import exchange.notbank.yield.YieldServiceResponseAdapter;
import exchange.notbank.yield.constants.Endpoints;
import exchange.notbank.yield.paramBuilders.WithdrawFromYieldParamBuilder;
import exchange.notbank.yield.paramBuilders.DepositToYieldParamBuilder;
import exchange.notbank.yield.paramBuilders.GetYieldProductsParamBuilder;
import exchange.notbank.yield.responses.YieldProduct;
import io.vavr.control.Either;


public class YieldService {
  private final Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection;
  private final YieldServiceResponseAdapter responseAdapter;

  public YieldService(Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection,
      YieldServiceResponseAdapter responseAdapter) {
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

  private <T> CompletableFuture<T> requestDelete(String endpoint, ParamBuilder paramBuilder,
      Function<String, Either<NotbankException, T>> deserializeFn) {
    return getNotbankConnection.get()
        .thenCompose(
            connection -> connection.requestDelete(EndpointCategory.NB, endpoint, paramBuilder,
                deserializeFn));
  }

  /**
   * https://apidoc.notbank.exchange/?http#deposittoyield
   */
  public CompletableFuture<Integer> depositToYield(DepositToYieldParamBuilder paramBuilder) {
    return requestPost(Endpoints.YIELD_DEPOSIT, paramBuilder, responseAdapter::toYieldDepositId);
  }

  /**
   * https://apidoc.notbank.exchange/?http#withdrawfromyield
   */
  public CompletableFuture<Integer> withdrawFromYield(WithdrawFromYieldParamBuilder paramBuilder) {
    return requestPost(Endpoints.YIELD_WITHDRAW, paramBuilder, responseAdapter::toYieldWithdrawId);
  }

  /**
   * https://stg.apidoc.notbank.exchange/#getyieldproducts
   */
  public CompletableFuture<List<YieldProduct>> getYieldProducts(
      GetYieldProductsParamBuilder paramBuilder) {
        return requestGet(
            Endpoints.GET_YIELD_PRODUCTS,
            paramBuilder,
            responseAdapter::toYieldProductList);
  }
}
