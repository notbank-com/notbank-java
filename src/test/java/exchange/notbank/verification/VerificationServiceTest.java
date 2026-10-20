package exchange.notbank.verification;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exchange.notbank.CredentialsLoader.UserCredentials;
import exchange.notbank.NotbankClient;
import exchange.notbank.TestHelper;
import exchange.notbank.verification.paramBuilders.GetVerificationStatusParamBuilder;

public class VerificationServiceTest {
  private static UserCredentials credentials;
  private static NotbankClient client;

  @BeforeAll
  public static void beforeAll() throws InterruptedException, ExecutionException {
    client = TestHelper.newRestClient();
    credentials = TestHelper.getUserCredentials();
    client.authenticate(credentials.userId, credentials.apiPublicKey, credentials.apiSecretKey).get();
  }

  @Test
  public void getVerificationStatusOfAuthenticatedUser() {
    var futureResponse = client.getVerificationService()
        .getVerificationStatus(new GetVerificationStatusParamBuilder());
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void getVerificationStatusWithUserId() {
    var futureResponse = client.getVerificationService()
        .getVerificationStatus(new GetVerificationStatusParamBuilder().userId(credentials.userId.toString()));
    TestHelper.checkNoError(futureResponse);
  }
}
