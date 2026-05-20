package exchange.notbank.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.squareup.moshi.Moshi;

public class RegisterUserResponseAdapterTest {
  private static UserServiceResponseAdapter adapter;

  @BeforeAll
  public static void beforeAll() {
    var moshi = new Moshi.Builder().build();
    adapter = new UserServiceResponseAdapter(null, moshi);
  }

  @Test
  public void successResponseDeserializesUserId() {
    var json = "{\"status\":\"success\",\"data\":{\"userId\":\"9a6b9d9b-b4c2-45d4-85b6-70c50675909e\",\"token\":\"eyJhbGci...kpXVCJ9\"}}";
    var result = adapter.toRegisterUserData(json);
    assertTrue(result.isRight());
    assertEquals("9a6b9d9b-b4c2-45d4-85b6-70c50675909e", result.get().userId);
  }

  @Test
  public void successResponseDeserializesToken() {
    var json = "{\"status\":\"success\",\"data\":{\"userId\":\"9a6b9d9b-b4c2-45d4-85b6-70c50675909e\",\"token\":\"eyJhbGci...kpXVCJ9\"}}";
    var result = adapter.toRegisterUserData(json);
    assertTrue(result.isRight());
    assertNotNull(result.get().token);
    assertTrue(result.get().token.startsWith("eyJ"));
  }

  @Test
  public void errorResponseIsLeft() {
    var json = "{\"detail\":\"Las credenciales de autenticación no se proveyeron.\"}";
    var result = adapter.toRegisterUserData(json);
    assertTrue(result.isLeft());
  }
}
