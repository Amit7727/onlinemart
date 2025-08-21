package productservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import productservice.entity.Product;
public interface ProductRepository extends MongoRepository<Product, Long> {}
