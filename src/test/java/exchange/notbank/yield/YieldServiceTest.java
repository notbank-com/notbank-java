package exchange.notbank.yield;

import exchange.notbank.CredentialsLoader.UserCredentials;
import exchange.notbank.NotbankClient;
import exchange.notbank.TestHelper;
import exchange.notbank.yield.paramBuilders.DepositToYieldParamBuilder;
import exchange.notbank.yield.paramBuilders.GetYieldProductsParamBuilder;
import exchange.notbank.yield.paramBuilders.WithdrawFromYieldParamBuilder;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class YieldServiceTest {

  private static UserCredentials credentials;
  private static NotbankClient client;

  @BeforeAll
  public static void beforeAll()
    throws InterruptedException, ExecutionException {
    client = TestHelper.newRestClient();
    credentials = TestHelper.getUserCredentials();
    client
      .authenticate(
        credentials.userId,
        credentials.apiPublicKey,
        credentials.apiSecretKey
      )
      .get();
  }

  @Test
  public void toYieldDeposit() {
    var futureResponse = client
      .getYieldService()
      .depositToYield(
        new DepositToYieldParamBuilder(
          credentials.accountId,
          "USDT",
          3,
          "1",
          new BigDecimal("1")
        ).userId(credentials.userId.toString())
      );
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void fromYieldWithdrawal() {
    var futureResponse = client
      .getYieldService()
      .withdrawFromYield(
        new WithdrawFromYieldParamBuilder(
          credentials.accountId,
          "USDT",
          3,
          "1",
          new BigDecimal("1")
        ).userId(credentials.userId.toString())
      );
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void getYieldProducts() {
    var futureResponse = client
      .getYieldService()
      .getYieldProducts(new GetYieldProductsParamBuilder());
    TestHelper.checkNoError(futureResponse);
  }
}
