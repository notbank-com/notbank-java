package exchange.notbank.core;

import java.io.IOException;
import java.util.Optional;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.Moshi;

import exchange.notbank.core.responses.AuthErrorResponse;
import exchange.notbank.core.responses.NbErrorResponse;
import exchange.notbank.core.responses.NbResponse;
import io.vavr.control.Either;

public class StandardNbResponseHandler {
  private final JsonAdapter<NbResponse> responseJsonAdapter;
  private final JsonAdapter<AuthErrorResponse> authErrorJsonAdapter;
  private final JsonAdapter<NbErrorResponse> responseErrorJsonAdapter;

  public StandardNbResponseHandler(
      JsonAdapter<NbResponse> responseJsonAdapter,
      JsonAdapter<AuthErrorResponse> authErrorJsonAdapter,
      JsonAdapter<NbErrorResponse> nbErrorJsonAdapter
  ) {
    this.responseJsonAdapter = responseJsonAdapter;
    this.responseErrorJsonAdapter = nbErrorJsonAdapter;
    this.authErrorJsonAdapter = authErrorJsonAdapter;
  }

  public static class Factory {
    public static StandardNbResponseHandler create(Moshi moshi) {
      return new StandardNbResponseHandler(
          moshi.adapter(NbResponse.class),
          moshi.adapter(AuthErrorResponse.class),
          moshi.adapter(NbErrorResponse.class)
      );
    }
  }

  public Either<NotbankException, String> handle(String jsonStr) {
    var nbResponseOrAuthError = getError(jsonStr);
    if (nbResponseOrAuthError.isEmpty()) {
      // means is not this kind of error, is another structure instead
      try{
          var nbError = responseErrorJsonAdapter.fromJson(jsonStr);
          if (nbError != null && nbError.status != null && nbError.status.equals("error") ){
              return Either.left(
                  NotbankException.Factory.create(nbError)
              );
          }
      }catch(IOException | JsonDataException e){
          return Either.left(
              NotbankException.Factory.create(
                  NotbankException.ErrorType.JSON_FORMAT,
                  "Error serializing following response error -> " + jsonStr
              )
          );
      }
      return Either.right(jsonStr);
    }
    var actualError = nbResponseOrAuthError.get().get();
    var error = NotbankException.Factory.create(actualError);
    return Either.left(error);
  }

  private Optional<Either<NbResponse, AuthErrorResponse>> getError(String jsonError) {
    try {
      var authResponse = authErrorJsonAdapter.fromJson(jsonError);
      if (
          authResponse != null
          && authResponse.detail != null
          && authResponse.detail.equals("Las credenciales de autenticación no se proveyeron.")
      ){
          return Optional.of(Either.right(authResponse));
      }
      var standardResponse = responseJsonAdapter.fromJson(jsonError);
      var standardErrorResponse = responseErrorJsonAdapter.fromJson(jsonError);
      if (standardResponse.status != null
          && standardResponse.status.equals("success")) {
        return Optional.empty();
      }
      if (standardErrorResponse.status != null
          && standardErrorResponse.status.equals("error")) {
        return Optional.empty();
      }
      return Optional.of(Either.left(standardResponse));
    } catch (IOException | JsonDataException e) {
      return Optional.empty();
    }
  }
}
