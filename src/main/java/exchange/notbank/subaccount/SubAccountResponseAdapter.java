package exchange.notbank.subaccount;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import exchange.notbank.core.ErrorHandler;
import exchange.notbank.core.NotbankException;
import exchange.notbank.subaccount.responses.SubAccountInfo;
import io.vavr.control.Either;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class SubAccountResponseAdapter {

    private final ErrorHandler errorHandler;
    private final JsonAdapter<SubAccountInfo> subaccountAdapter;
    private final JsonAdapter<List<SubAccountInfo>> subaccountListAdapter;

    public SubAccountResponseAdapter(Moshi moshi) {
        this.errorHandler = ErrorHandler.Factory.createApErrorHandler(moshi);
        this.subaccountAdapter = moshi.adapter(SubAccountInfo.class);
        ParameterizedType QuoteListType = Types.newParameterizedType(
            List.class,
            SubAccountInfo.class
        );
        this.subaccountListAdapter = moshi.adapter(QuoteListType);
    }

    public Either<NotbankException, Void> toNone(String jsonStr) {
        return errorHandler.toNone(jsonStr);
    }

    private <T> Either<NotbankException, T> handle(
        String jsonString,
        JsonAdapter<T> jsonAdapter
    ) {
        return errorHandler.handleAndThen(jsonAdapter).apply(jsonString);
    }

    public Either<NotbankException, SubAccountInfo> toSubAccount(String jsonStr) {
        return handle(jsonStr, subaccountAdapter);
    }

    public Either<NotbankException, List<SubAccountInfo>> toSubAccountList(
        String jsonStr
    ) {
        return handle(jsonStr, subaccountListAdapter);
    }
}
