package exchange.notbank.users;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import exchange.notbank.core.ErrorHandler;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.StandardApResponseHandler;
import exchange.notbank.core.responses.DataResponse;
import exchange.notbank.users.responses.Device;
import exchange.notbank.users.responses.RegisterUserData;
import io.vavr.control.Either;

public class UserServiceResponseAdapter {
  private final ErrorHandler errorHandler;
  private final ErrorHandler nbErrorHandler;
  private final JsonAdapter<List<Integer>> integerListAdapter;
  private final JsonAdapter<List<String>> stringListAdapter;
  private final JsonAdapter<List<Device>> deviceListAdapter;
  private final JsonAdapter<DataResponse<RegisterUserData>> registerUserDataJsonAdapter;

  public UserServiceResponseAdapter(StandardApResponseHandler responseHandler, Moshi moshi) {
    this.errorHandler = ErrorHandler.Factory.createApErrorHandler(moshi);
    this.nbErrorHandler = ErrorHandler.Factory.createNbErrorHandler(moshi);
    ParameterizedType IntegerListType = Types.newParameterizedType(List.class, Integer.class);
    this.integerListAdapter = moshi.adapter(IntegerListType);
    ParameterizedType StringListType = Types.newParameterizedType(List.class, String.class);
    this.stringListAdapter = moshi.adapter(StringListType);
    ParameterizedType DeviceListType = Types.newParameterizedType(List.class, Device.class);
    this.deviceListAdapter = moshi.adapter(DeviceListType);
    ParameterizedType RegisterUserDataResponseType = Types.newParameterizedType(
        DataResponse.class,
        RegisterUserData.class);
    this.registerUserDataJsonAdapter = moshi.adapter(RegisterUserDataResponseType);
  }

  public Either<NotbankException, Void> toNone(String jsonStr) {
    return errorHandler.toNone(jsonStr);
  }

  private <T> Either<NotbankException, T> handle(String jsonString, JsonAdapter<T> jsonAdapter) {
    return errorHandler.handleAndThen(jsonAdapter).apply(jsonString);
  }

  public Either<NotbankException, List<Device>> toDeviceList(String jsonStr) {
    return handle(jsonStr, deviceListAdapter);
  }

  public Either<NotbankException, List<Integer>> toIntegerList(String jsonStr) {
    return handle(jsonStr, integerListAdapter);
  }

  public Either<NotbankException, List<String>> toStringList(String jsonStr) {
    return handle(jsonStr, stringListAdapter);
  }

  public Either<NotbankException, RegisterUserData> toRegisterUserData(String jsonStr) {
    return nbErrorHandler.handleAndThen(registerUserDataJsonAdapter).apply(jsonStr)
        .map(response -> response.data);
  }
}