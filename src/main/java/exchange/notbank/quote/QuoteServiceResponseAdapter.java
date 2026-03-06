package exchange.notbank.quote;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import exchange.notbank.core.ErrorHandler;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.responses.DataResponse;
import exchange.notbank.quote.responses.Quote;
import exchange.notbank.wallet.responses.IdResponse;
import io.vavr.control.Either;

public class QuoteServiceResponseAdapter {
  private final ErrorHandler errorHandler;
  private final JsonAdapter<DataResponse<Quote>> quoteAdapter;
  private final JsonAdapter<DataResponse<List<Quote>>> quoteListAdapter;
  private final JsonAdapter<DataResponse<IdResponse>> idResponseAdapter;

  public QuoteServiceResponseAdapter(Moshi moshi) {
    this.errorHandler = ErrorHandler.Factory.createNbErrorHandler(moshi);
    ParameterizedType QuoteResponseType = Types.newParameterizedType(
        DataResponse.class,
        Quote.class);
    this.quoteAdapter = moshi.adapter(QuoteResponseType);
    ParameterizedType QuoteListType = Types.newParameterizedType(List.class, Quote.class);
    ParameterizedType QuoteListResponseType = Types.newParameterizedType(
        DataResponse.class,
        QuoteListType);
    this.quoteListAdapter = moshi.adapter(QuoteListResponseType);
    ParameterizedType IdResponseType = Types.newParameterizedType(
        DataResponse.class,
        IdResponse.class);
    this.idResponseAdapter = moshi.adapter(IdResponseType);
  }

  public Either<NotbankException, Void> toNone(String jsonStr) {
    return errorHandler.toNone(jsonStr);
  }

  private <T> Either<NotbankException, T> handle(String jsonString, JsonAdapter<T> jsonAdapter) {
    return errorHandler.handleAndThen(jsonAdapter).apply(jsonString);
  }

  public Either<NotbankException, Quote> toQuote(String jsonStr) {
    return handle(jsonStr, quoteAdapter).map(response -> response.data);
  }

  public Either<NotbankException, List<Quote>> toQuoteList(String jsonStr) {
    return handle(jsonStr, quoteListAdapter).map(response -> response.data);
  }

  public Either<NotbankException, IdResponse> toIdResponse(String jsonStr) {
    return handle(jsonStr, idResponseAdapter).map(response -> response.data);
  }
}
