package exchange.notbank.subaccount;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exchange.notbank.CredentialsLoader.UserCredentials;
import exchange.notbank.NotbankClient;
import exchange.notbank.TestHelper;
import exchange.notbank.subaccount.paramBuilders.CreateSubAccountParamBuilder;
import exchange.notbank.subaccount.paramBuilders.GetSubAccountsParamBuilder;

public class SubAccountServiceTest {
  private static NotbankClient client;
  private static UserCredentials credentials;

  @BeforeAll
  public static void beforeAll() throws InterruptedException, ExecutionException {
    client = NotbankClient.Factory.createRestClient(TestHelper.HOST);
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
        "test_account_java"));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createSubAccountFailure() {
    var futureResponse = client.getSubaccountService().createSubaccount(new CreateSubAccountParamBuilder(
        ""));
    TestHelper.checkNoError(futureResponse);
  }

}
