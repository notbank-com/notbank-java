package exchange.notbank.yield;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import exchange.notbank.core.ErrorHandler;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.responses.DataResponse;
import exchange.notbank.yield.responses.YieldProduct;

import io.vavr.control.Either;

public class YieldServiceResponseAdapter {
  private final ErrorHandler errorHandler;
  private final JsonAdapter<DataResponse<List<YieldProduct>>> yieldProductsJsonAdapter;
  private final JsonAdapter<DataResponse<Integer>> yieldInOutOperationJsonAdapter;

  public YieldServiceResponseAdapter(Moshi moshi){
    this.errorHandler = ErrorHandler.Factory.createNbErrorHandler(moshi);
    ParameterizedType YieldInOutResponseType = Types.newParameterizedType(
        DataResponse.class,
        Integer.class);
    this.yieldInOutOperationJsonAdapter = moshi.adapter(YieldInOutResponseType);
    ParameterizedType yieldProductListType = Types.newParameterizedType(List.class, YieldProduct.class);
    ParameterizedType yieldProductListResponseType = Types.newParameterizedType(
      DataResponse.class, yieldProductListType
    );
    this.yieldProductsJsonAdapter = moshi.adapter(yieldProductListResponseType);
  }

  private <T> Either<NotbankException, T> handle(String jsonString, JsonAdapter<T> jsonAdapter) {
    return errorHandler.handleAndThen(jsonAdapter).apply(jsonString);
  }

  Either<NotbankException, Integer> toYieldWithdrawId(String jsonStr) {
    return handle(jsonStr, yieldInOutOperationJsonAdapter).map(response -> response.data);
  }

  Either<NotbankException, Integer> toYieldDepositId(String jsonStr) {
    return handle(jsonStr, yieldInOutOperationJsonAdapter).map(response -> response.data);
  }

  public Either<NotbankException, List<YieldProduct>> toYieldProductList(String jsonStr) {
    return handle(jsonStr, yieldProductsJsonAdapter).map(response -> response.data);
  }
}
