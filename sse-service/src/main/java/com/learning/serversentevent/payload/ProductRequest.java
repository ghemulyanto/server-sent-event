package com.learning.serversentevent.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

  private String name;

  @JsonProperty("image_url")
  private String imageUrl;

  private Double rating;

  private String description;

  private Integer stock;

}
