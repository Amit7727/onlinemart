package common.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import common.dto.ProductDto;

@FeignClient(name="product-service", url="${product.service.url}")
public interface ProductClient {
  @GetMapping("/api/products/{id}")
  ProductDto getById(@PathVariable("id") Long id);
}
