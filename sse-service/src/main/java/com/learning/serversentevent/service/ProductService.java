package com.learning.serversentevent.service;

import com.learning.serversentevent.entity.Product;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

  Mono<Product> save(Product product);

  Mono<Product> buyProduct(String id);

  Flux<List<Product>> findAllProducts();

}
