package exchange.notbank.verification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.squareup.moshi.Moshi;

import exchange.notbank.core.NotbankException;
import exchange.notbank.verification.constants.VerificationLevel;
import exchange.notbank.verification.constants.VerificationProcessResult;

public class VerificationServiceResponseAdapterTest {
  private static VerificationServiceResponseAdapter adapter;

  @BeforeAll
  public static void beforeAll() {
    var moshi = new Moshi.Builder().build();
    adapter = new VerificationServiceResponseAdapter(moshi);
  }

  @Test
  public void parsesAllFields() {
    var json = "{\"status\":\"success\",\"data\":{\"id\":\"9a6b9d9b-b4c2-45d4-85b6-70c50675909e\",\"locked\":true,"
        + "\"next_level\":\"trader\",\"last_previous_status\":\"approved\",\"last_previous_reason\":\"document_expired\","
        + "\"is_business\":false,\"verification_tier\":2}}";
    var result = adapter.toVerificationStatus(json);
    assertTrue(result.isRight());
    var status = result.get();
    assertEquals("9a6b9d9b-b4c2-45d4-85b6-70c50675909e", status.id);
    assertTrue(status.locked);
    assertEquals(VerificationLevel.TRADER, status.nextLevel);
    assertEquals(VerificationProcessResult.APPROVED, status.lastPreviousStatus);
    assertEquals("document_expired", status.lastPreviousReason);
    assertFalse(status.isBusiness);
    assertEquals(2, status.verificationTier);
  }

  @Test
  public void parsesNullFields() {
    var json = "{\"status\":\"success\",\"data\":{\"id\":null,\"locked\":false,\"next_level\":null,"
        + "\"last_previous_status\":null,\"last_previous_reason\":null,\"is_business\":false,\"verification_tier\":0}}";
    var result = adapter.toVerificationStatus(json);
    assertTrue(result.isRight());
    var status = result.get();
    assertNull(status.id);
    assertNull(status.nextLevel);
    assertNull(status.lastPreviousStatus);
    assertNull(status.lastPreviousReason);
  }

  @Test
  public void parsesEnums() {
    var json = "{\"status\":\"success\",\"data\":{\"id\":null,\"locked\":false,\"next_level\":\"trader_plus\","
        + "\"last_previous_status\":\"rejected\",\"last_previous_reason\":null,\"is_business\":true,\"verification_tier\":3}}";
    var result = adapter.toVerificationStatus(json);
    assertTrue(result.isRight());
    assertEquals(VerificationLevel.TRADER_PLUS, result.get().nextLevel);
    assertEquals(VerificationProcessResult.REJECTED, result.get().lastPreviousStatus);
  }

  @Test
  public void returnsErrorOnErrorStatus() {
    var json = "{\"status\":\"error\",\"code\":\"user_not_found\",\"message\":\"User not found\"}";
    var result = adapter.toVerificationStatus(json);
    assertTrue(result.isLeft());
    assertEquals(NotbankException.ErrorType.RESPONSE_ERROR, result.getLeft().errorType);
  }

  @Test
  public void returnsJsonFormatErrorOnUnknownEnumValue() {
    var json = "{\"status\":\"success\",\"data\":{\"id\":null,\"locked\":false,\"next_level\":\"platinum\","
        + "\"last_previous_status\":null,\"last_previous_reason\":null,\"is_business\":false,\"verification_tier\":1}}";
    var result = adapter.toVerificationStatus(json);
    assertTrue(result.isLeft());
    assertEquals(NotbankException.ErrorType.JSON_FORMAT, result.getLeft().errorType);
  }
}
