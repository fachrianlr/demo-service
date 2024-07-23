package com.rian.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class GenericResponse<K> {

  @JsonProperty("respCode")
  private String respCode;

  @JsonProperty("respDesc")
  private String respDesc;

  @JsonInclude(Include.NON_NULL)
  @JsonProperty("data")
  private K data;

  @JsonInclude(Include.NON_NULL)
  @JsonProperty("paging_info")
  private PaginationResponse pagingInfo;

}
