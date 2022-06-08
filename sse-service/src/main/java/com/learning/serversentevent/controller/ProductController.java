package com.learning.serversentevent.controller;

import com.learning.serversentevent.entity.Product;
import com.learning.serversentevent.payload.ProductRequest;
import com.learning.serversentevent.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public Mono<Product> createProduct(@RequestBody ProductRequest productRequest) {
    Product product = Product.builder().name(productRequest.getName())
        .imageUrl(productRequest.getImageUrl()).rating(productRequest.getRating())
        .description(productRequest.getDescription()).stock(productRequest.getStock()).build();
    return productService.save(product);
  }

  @PostMapping("{id}")
  public Mono<Product> buyProduct(@PathVariable("id") String id) {
    return productService.buyProduct(id);
  }


  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<List<Product>> getAllProducts(){
    return productService.findAllProducts();
  }
}
