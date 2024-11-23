package com.sosd.mpjstudy.common.domain.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * 分页查询结果
 *
 * @param <T>
 */
@Data
public class PageResult<T> {

  /** 数据总数 */
  private Long total = 0L;

  /** 数据列表 */
  private List<T> rows = new ArrayList<>(0);
}
