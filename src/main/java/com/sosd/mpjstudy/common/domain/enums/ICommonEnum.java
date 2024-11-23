package com.sosd.mpjstudy.common.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface ICommonEnum {

  @JsonValue
  String getValue();

  String getLabel();
}
