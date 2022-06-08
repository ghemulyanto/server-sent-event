package com.learning.serversentevent.service;

import com.learning.serversentevent.entity.Product;
import com.learning.serversentevent.repository.ProductMongoRepository;
import com.learning.serversentevent.repository.ProductRepository;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private final ProductMongoRepository productMongoRepository;

  @Override
  public Mono<Product> save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Mono<Product> buyProduct(String id) {
    return productRepository.findById(id).map(product -> {
      product.setStock(product.getStock() - 1);
      return product;
    }).flatMap(productRepository::save);
  }


  @Override
  public Flux<List<Product>> findAllProducts() {
    return Flux.interval(Duration.ofSeconds(2))
        .onBackpressureDrop()
        .map(this::findProductList);
  }

  private List<Product> findProductList(long interval) {
    return productMongoRepository.findAll();
  }




}
