package exchange.notbank.verification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import exchange.notbank.verification.paramBuilders.GetVerificationStatusParamBuilder;

public class GetVerificationStatusParamBuilderTest {
  @Test
  public void putsUserId() {
    var uuid = UUID.fromString("9a6b9d9b-b4c2-45d4-85b6-70c50675909e");
    assertEquals(uuid, new GetVerificationStatusParamBuilder().userId(uuid).getParams().get("user_id"));
    assertEquals("123", new GetVerificationStatusParamBuilder().userId("123").getParams().get("user_id"));
  }

  @Test
  public void omitsUserIdByDefault() {
    assertFalse(new GetVerificationStatusParamBuilder().getParams().containsKey("user_id"));
  }

  @Test
  public void omitsNullUserId() {
    assertFalse(new GetVerificationStatusParamBuilder().userId((String) null).getParams().containsKey("user_id"));
    assertFalse(new GetVerificationStatusParamBuilder().userId((UUID) null).getParams().containsKey("user_id"));
  }
}
