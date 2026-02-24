package exchange.notbank.subaccount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.function.Function;

import exchange.notbank.subaccount.constants.Endpoints;
import exchange.notbank.subaccount.responses.SubAccountInfo;
import exchange.notbank.subaccount.paramBuilders.CreateSubAccountParamBuilder;
import exchange.notbank.subaccount.paramBuilders.GetSubAccountsParamBuilder;
import exchange.notbank.core.NotbankConnection;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.EndpointCategory;
import exchange.notbank.core.ParamBuilder;

import io.vavr.control.Either;

public class SubAccountService {
    private final Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection;
    private final SubAccountResponseAdapter responseAdapter;

    public SubAccountService(Supplier<CompletableFuture<NotbankConnection>> getNotbankConnection,
        SubAccountResponseAdapter responseAdapter) {
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
     * https://apidoc.notbank.exchange/?http#getsubaccounts
     */
    public CompletableFuture<List<SubAccountInfo>> getSubaccounts(GetSubAccountsParamBuilder paramBuilder) {
      return requestGet(Endpoints.GET_SUBACCOUNTS, paramBuilder, responseAdapter::toSubAccountList);
    }

    /**
     * https://apidoc.notbank.exchange/?http#createsubaccount
     */
    public CompletableFuture<Void> createSubaccount(CreateSubAccountParamBuilder paramBuilder){
      return requestPost(Endpoints.CREATE_SUBACCOUNT, paramBuilder, responseAdapter::toNone);
    }

}
