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

public class RegisterBasicUserParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public RegisterBasicUserParamBuilder(String firstName, String lastName, String phoneNumber, Profession profession,
      Gender gender, String birthdate, String citizenship, IdentityType identityType, String identityNumber,
      String identityCountry, String addressCountry, String addressCity, String addressStreet,
      String addressPostalCode) {
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
  }

  public RegisterBasicUserParamBuilder addressProvince(ArProvince value) {
    this.params.put("address_province", value.value);
    return this;
  }

  public RegisterBasicUserParamBuilder subjectComply(boolean value) {
    this.params.put("subject_comply", value);
    return this;
  }

  public RegisterBasicUserParamBuilder addressDistrict(String value) {
    this.params.put("address_district", value);
    return this;
  }

  public RegisterBasicUserParamBuilder addressNumber(String value) {
    this.params.put("address_number", value);
    return this;
  }

  public RegisterBasicUserParamBuilder addressState(BrState value) {
    this.params.put("address_state", value.value);
    return this;
  }

  public RegisterBasicUserParamBuilder addressComplement(String value) {
    this.params.put("address_complement", value);
    return this;
  }

  public RegisterBasicUserParamBuilder addressComune(ClComune value) {
    this.params.put("address_comune", value.value);
    return this;
  }

  public RegisterBasicUserParamBuilder civilStatus(CivilStatus value) {
    this.params.put("civil_status", value.value);
    return this;
  }

  public RegisterBasicUserParamBuilder spouseName(String value) {
    this.params.put("spouse_name", value);
    return this;
  }

  public RegisterBasicUserParamBuilder pep(boolean value) {
    this.params.put("pep", value);
    return this;
  }

  public RegisterBasicUserParamBuilder pepPosition(String value) {
    this.params.put("pep_position", value);
    return this;
  }

  public RegisterBasicUserParamBuilder pepInstitution(String value) {
    this.params.put("pep_institution", value);
    return this;
  }

  public RegisterBasicUserParamBuilder pepLinksDescription(String value) {
    this.params.put("pep_links_description", value);
    return this;
  }

  public RegisterBasicUserParamBuilder isPepFamilyMember(boolean value) {
    this.params.put("is_pep_family_member", value);
    return this;
  }

  public RegisterBasicUserParamBuilder pepFamilyMemberName(String value) {
    this.params.put("pep_family_member_name", value);
    return this;
  }

  public RegisterBasicUserParamBuilder pepFamilyMemberRelation(String value) {
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

  public RegisterBasicUserParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
