package exchange.notbank.verification;

import java.lang.reflect.ParameterizedType;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import exchange.notbank.core.ErrorHandler;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.responses.DataResponse;
import exchange.notbank.verification.responses.VerificationStatus;

import io.vavr.control.Either;

public class VerificationServiceResponseAdapter {
  private final ErrorHandler errorHandler;
  private final JsonAdapter<DataResponse<VerificationStatus>> verificationStatusJsonAdapter;

  public VerificationServiceResponseAdapter(Moshi moshi) {
    this.errorHandler = ErrorHandler.Factory.createNbErrorHandler(moshi);
    ParameterizedType verificationStatusResponseType = Types.newParameterizedType(
        DataResponse.class,
        VerificationStatus.class);
    this.verificationStatusJsonAdapter = moshi.adapter(verificationStatusResponseType);
  }

  private <T> Either<NotbankException, T> handle(String jsonString, JsonAdapter<T> jsonAdapter) {
    return errorHandler.handleAndThen(jsonAdapter).apply(jsonString);
  }

  Either<NotbankException, VerificationStatus> toVerificationStatus(String jsonStr) {
    return handle(jsonStr, verificationStatusJsonAdapter).map(response -> response.data);
  }
}
