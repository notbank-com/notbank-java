package exchange.notbank.utils;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exchange.notbank.CredentialsLoader.UserCredentials;
import exchange.notbank.core.NotbankException;
import exchange.notbank.NotbankClient;
import exchange.notbank.TestHelper;
import exchange.notbank.utils.paramBuilders.GetProvincesParamBuilder;
import exchange.notbank.utils.constants.ProvinceCountry;

public class UtilsServiceTest {
  private static NotbankClient client;
  private static UserCredentials credentials;

  @BeforeAll
  public static void beforeAll() throws InterruptedException, ExecutionException {
    client = TestHelper.newRestClient();
    credentials = TestHelper.getUserCredentials();
    client.authenticate(credentials.userId, credentials.apiPublicKey, credentials.apiSecretKey).get();
  }

  @Test
  public void getProvinces() {
    var futureResponse = client.getUtilsService().getProvinces(new GetProvincesParamBuilder(
        ProvinceCountry.PERU));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createSubAccountFailure() {
    var futureResponse = client.getUtilsService().getProvinces(new GetProvincesParamBuilder(
      ProvinceCountry.EMPTY));
    TestHelper.checkRightOrErrorType(futureResponse, NotbankException.ErrorType.RESPONSE_ERROR);
  }

}
