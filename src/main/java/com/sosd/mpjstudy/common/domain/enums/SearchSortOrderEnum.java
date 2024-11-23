package com.sosd.mpjstudy.common.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchSortOrderEnum implements ICommonEnum {
  Asc("asc", "升序"),
  Desc("desc", "降序");

  @EnumValue
  private final String value;
  private final String label;
}
