package exchange.notbank.quote;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exchange.notbank.CredentialsLoader.UserCredentials;
import exchange.notbank.NotbankClient;
import exchange.notbank.TestHelper;
import exchange.notbank.quote.constants.QuoteMode;
import exchange.notbank.quote.constants.QuoteOperation;
import exchange.notbank.quote.paramBuilders.CreateDirectQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.CreateInverseQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.ExecuteQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.GetQuoteParamBuilder;
import exchange.notbank.quote.paramBuilders.GetQuotesParamBuilder;

public class QuoteServiceTest {
  private static NotbankClient client;
  private static UserCredentials credentials;

  @BeforeAll
  public static void beforeAll() throws InterruptedException, ExecutionException {
    client = TestHelper.newRestClient();
    credentials = TestHelper.getUserCredentials();
    client.authenticate(credentials.userId, credentials.apiPublicKey, credentials.apiSecretKey).get();
  }

  @Test
  public void getQuotes() {
    var futureResponse = client.getQuoteService().getQuotes(new GetQuotesParamBuilder().mode(QuoteMode.DIRECT));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createDirectQuote() {
    var futureResponse = client.getQuoteService().createDirectQuote(new CreateDirectQuoteParamBuilder(
        credentials.accountId,
        "BTC",
        new BigDecimal("1000"),
        "USDT",
        QuoteOperation.BUY));
    TestHelper.checkNoError(futureResponse);
  }

  @Test
  public void createInverseQuote() {
    var futureResponse = client.getQuoteService().createInverseQuote(new CreateInverseQuoteParamBuilder(
        credentials.accountId,
        "BTC",
        new BigDecimal("1000"),
        "USDT"));
    TestHelper.checkNoError(futureResponse);
  }


    @Test
  public void getQuote() {
    var futureResponse = client.getQuoteService().getQuote(new GetQuoteParamBuilder(UUID.fromString("5774db41-2301-4032-ae79-c558193fd53b")));
    TestHelper.checkNoError(futureResponse);
  }


    @Test
  public void executeQuote() {
    var futureResponse = client.getQuoteService().executeQuote(new ExecuteQuoteParamBuilder(UUID.fromString("7d9b3314-40a5-43cf-bb39-c75cd8689ce8")));
    TestHelper.checkNoError(futureResponse);
  }

}
