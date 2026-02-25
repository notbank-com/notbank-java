package exchange.notbank.subaccount;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import exchange.notbank.core.ErrorHandler;
import exchange.notbank.core.NotbankException;
import exchange.notbank.subaccount.responses.SubAccountInfo;
import exchange.notbank.subaccount.responses.SubAccountList;
import exchange.notbank.subaccount.responses.SubAccountListResponse;
import io.vavr.control.Either;

public class SubAccountResponseAdapter {

    private final ErrorHandler errorHandler;
    private final JsonAdapter<SubAccountInfo> subaccountAdapter;
    private final JsonAdapter<SubAccountListResponse> dataAdapter;

    public SubAccountResponseAdapter(Moshi moshi) {
        this.errorHandler = ErrorHandler.Factory.createNbErrorHandler(moshi);
        this.subaccountAdapter = moshi.adapter(SubAccountInfo.class);
        this.dataAdapter = moshi.adapter(SubAccountListResponse.class);

    }
    public Either<NotbankException, Void> toNone(String jsonStr) {
        return errorHandler.toNone(jsonStr);
    }

    private <T> Either<NotbankException, T> handle(String jsonString, JsonAdapter<T> jsonAdapter) {
      return errorHandler.handleAndThen(jsonAdapter).apply(jsonString);
    }

    public Either<NotbankException, SubAccountInfo> toSubAccount(String jsonStr) {
        return handle(jsonStr, subaccountAdapter);
    }

    public Either<NotbankException, SubAccountList> toSubAccountList(
            String jsonStr) {
        var data = handle(jsonStr, this.dataAdapter);
        if(data.isLeft()){
            return Either.left(data.getLeft());
        }
        return Either.right(data.get().data);
    }
}
