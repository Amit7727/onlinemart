package productservice.repo;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import productservice.entity.Product;
public interface ProductRepository extends CrudRepository<Product, Long> {}
