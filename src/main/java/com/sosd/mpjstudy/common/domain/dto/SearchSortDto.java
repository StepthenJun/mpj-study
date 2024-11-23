package com.sosd.mpjstudy.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 查询排序 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchSortDto {
  /** 排序规则 */
  private String prop = "";

  /** 排序顺序 */
  private SearchSortOrderEnum order = SearchSortOrderEnum.Asc;

  public boolean isAsc() {
    return SearchSortOrderEnum.Asc.equals(this.order);
  }
}
