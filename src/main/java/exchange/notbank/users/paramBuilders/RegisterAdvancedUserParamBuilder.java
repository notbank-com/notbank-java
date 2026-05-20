package exchange.notbank.users.paramBuilders;

import java.util.HashMap;
import java.util.Map;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;
import exchange.notbank.users.constants.ArProvince;
import exchange.notbank.users.constants.BrState;
import exchange.notbank.users.constants.CivilStatus;
import exchange.notbank.users.constants.ClComune;
import exchange.notbank.users.constants.Gender;
import exchange.notbank.users.constants.IdentityType;
import exchange.notbank.users.constants.Profession;

public class RegisterAdvancedUserParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public RegisterAdvancedUserParamBuilder(String firstName, String lastName, String phoneNumber, Profession profession,
      Gender gender, String birthdate, String citizenship, IdentityType identityType, String identityNumber,
      String identityCountry, String addressCountry, String addressCity, String addressStreet,
      String addressPostalCode, boolean pep, boolean subjectComply, boolean isPublicServant) {
    this.httpConfiguration = HttpConfiguration.empty();
    this.params = new HashMap<>();
    this.params.put("first_name", firstName);
    this.params.put("last_name", lastName);
    this.params.put("phone_number", phoneNumber);
    this.params.put("profession", profession.value);
    this.params.put("gender", gender.value);
    this.params.put("birthdate", birthdate);
    this.params.put("citizenship", citizenship);
    this.params.put("identity_type", identityType.value);
    this.params.put("identity_number", identityNumber);
    this.params.put("identity_country", identityCountry);
    this.params.put("address_country", addressCountry);
    this.params.put("address_city", addressCity);
    this.params.put("address_street", addressStreet);
    this.params.put("address_postal_code", addressPostalCode);
    this.params.put("pep", pep);
    this.params.put("subject_comply", subjectComply);
    this.params.put("is_public_servant", isPublicServant);
  }

  public RegisterAdvancedUserParamBuilder addressProvince(ArProvince value) {
    this.params.put("address_province", value.value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder addressDistrict(String value) {
    this.params.put("address_district", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder addressNumber(String value) {
    this.params.put("address_number", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder addressState(BrState value) {
    this.params.put("address_state", value.value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder addressComplement(String value) {
    this.params.put("address_complement", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder addressComune(ClComune value) {
    this.params.put("address_comune", value.value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder civilStatus(CivilStatus value) {
    this.params.put("civil_status", value.value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder spouseName(String value) {
    this.params.put("spouse_name", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder pepPosition(String value) {
    this.params.put("pep_position", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder pepInstitution(String value) {
    this.params.put("pep_institution", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder pepLinksDescription(String value) {
    this.params.put("pep_links_description", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder isPepFamilyMember(boolean value) {
    this.params.put("is_pep_family_member", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder pepFamilyMemberName(String value) {
    this.params.put("pep_family_member_name", value);
    return this;
  }

  public RegisterAdvancedUserParamBuilder pepFamilyMemberRelation(String value) {
    this.params.put("pep_family_member_relation", value);
    return this;
  }

  @Override
  public Map<String, Object> getParams() {
    return params;
  }

  @Override
  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public RegisterAdvancedUserParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
