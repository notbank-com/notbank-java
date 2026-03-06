package exchange.notbank.core;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.squareup.moshi.Moshi;

import exchange.notbank.core.responses.AuthErrorResponse;
import exchange.notbank.core.responses.NbErrorResponse;
import exchange.notbank.core.responses.NbResponse;

public class StandardNbResponseHandlerTest {
  static final String errorJson = "{\"detail\":\"Las credenciales de autenticación no se proveyeron.\"}";
  private static StandardNbResponseHandler handler;

  @BeforeAll
  public static void beforeAll() {
    var moshi = new Moshi.Builder().build();
    handler = new StandardNbResponseHandler(
        moshi.adapter(NbResponse.class),
        moshi.adapter(AuthErrorResponse.class),
        moshi.adapter(NbErrorResponse.class)
    );
  }

  @Test
  public void handleErrorJson() {
    var result = handler.handle(errorJson);
    assertTrue(result.isLeft());
    System.out.println(result);

  }
}
