package com.learning.serversentevent.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
@Builder
public class Product {

  @Id
  private String id;

  private String name;

  private String imageUrl;

  private Double rating;

  private String description;

  private Integer stock;

}
