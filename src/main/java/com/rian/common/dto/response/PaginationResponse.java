package com.rian.common.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder
public class PaginationResponse {

  @JsonProperty("totalCurrentItems")
  private int totalCurrentItems;

  @JsonProperty("totalItems")
  private Long totalItems;

  @JsonProperty("currentPage")
  private int currentPage;

  @JsonProperty("totalPages")
  private int totalPages;

}
