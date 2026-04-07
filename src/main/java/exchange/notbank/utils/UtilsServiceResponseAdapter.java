package exchange.notbank.utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import exchange.notbank.core.ErrorHandler;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.responses.DataResponse;

import io.vavr.control.Either;

public class UtilsServiceResponseAdapter {
  private final ErrorHandler errorHandler;
  private final JsonAdapter<DataResponse<List<String>>> provinceAdapter;

  public UtilsServiceResponseAdapter(Moshi moshi) {
    ParameterizedType ProvinceListType = Types.newParameterizedType(List.class, String.class);
    ParameterizedType ProvinceListResponseType = Types.newParameterizedType(
        DataResponse.class,
        ProvinceListType);
    this.errorHandler = ErrorHandler.Factory.createNbErrorHandler(moshi);
    this.provinceAdapter = moshi.adapter(ProvinceListResponseType);
  }

  public Either<NotbankException, Void> toNone(String jsonStr) {
    return errorHandler.toNone(jsonStr);
  }

  private <T> Either<NotbankException, T> handle(String jsonString, JsonAdapter<T> jsonAdapter) {
    return errorHandler.handleAndThen(jsonAdapter).apply(jsonString);
  }

  public Either<NotbankException, List<String>> toProvinceList(String jsonStr) {
    return handle(jsonStr, provinceAdapter).map(response -> response.data);
  }
}
