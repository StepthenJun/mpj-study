package com.sosd.mpjstudy.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 分页查询 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDto<T> {
  /** 页数 */
  private Long page = 1L;

  /** 每页数量 */
  private Long pageSize = 10L;

  /** 查询条件 */
  private T query;

  /** 排序 */
  private SearchSortDto sort = new SearchSortDto();

  public SearchDto(T query) {
    this.query = query;
  }

  public Long getPage() {
    if (page <= 0) {
      return 1L;
    }
    return page;
  }

  public Long getPageSize() {
    if (pageSize <= 0) {
      return 10L;
    }
    if (pageSize >= 1000) {
      return 1000L;
    }
    return pageSize;
  }
}
