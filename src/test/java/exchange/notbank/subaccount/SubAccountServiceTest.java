package exchange.notbank.subaccount;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exchange.notbank.CredentialsLoader.UserCredentials;
import exchange.notbank.core.NotbankException;
import exchange.notbank.NotbankClient;
import exchange.notbank.TestHelper;
import exchange.notbank.subaccount.paramBuilders.CreateSubAccountParamBuilder;
import exchange.notbank.subaccount.paramBuilders.GetSubAccountsParamBuilder;

public class SubAccountServiceTest {
  private static NotbankClient client;
  private static UserCredentials credentials;

  @BeforeAll
  public static void beforeAll() throws InterruptedException, ExecutionException {
    client = TestHelper.newRestClient();
    credentials = TestHelper.getUserCredentials();
    client.authenticate(credentials.userId, credentials.apiPublicKey, credentials.apiSecretKey).get();
  }

  @Test
  public void getSubAccounts() {
    var futureResponse = client.getSubaccountService().getSubaccounts(new GetSubAccountsParamBuilder().page(1));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createSubAccount() {
    var futureResponse = client.getSubaccountService().createSubaccount(new CreateSubAccountParamBuilder(
        "testaccountjava"));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createSubAccountFailure() {
    var futureResponse = client.getSubaccountService().createSubaccount(new CreateSubAccountParamBuilder(
        ""));
    TestHelper.checkRightOrErrorType(futureResponse, NotbankException.ErrorType.RESPONSE_ERROR);
  }

}
