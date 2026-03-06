package exchange.notbank.core.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.constants.MessageType;

public class MessageTypeAdapter {
  Map<Integer, MessageType> enumMap = EnumMappingBuilder.buildMapping(MessageType.values(), e -> e.value);

  @ToJson
  int toJson(MessageType value) {
    return value.value;
  }

  @FromJson
  MessageType fromJson(int value) {
    return GetFromMap.get(enumMap, value, MessageType.class.getName());
  }
}
