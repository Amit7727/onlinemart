package productservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import productservice.entity.Product;
import productservice.repo.ProductRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductRepository repo;
  public ProductController(ProductRepository repo) { this.repo = repo; }

  @GetMapping public List<Product> all() { return repo.findAll(); }

  @GetMapping("/{id}") public ResponseEntity<Product> one(@PathVariable("id") Long id) {
    return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping public ResponseEntity<Product> create(@RequestBody Product p) {
    Product saved = repo.save(p);
    return ResponseEntity.created(URI.create("/api/products/" + saved.getId())).body(saved);
  }

  @PutMapping("/{id}") public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p) {
    return repo.findById(id).map(ex -> {
      ex.setName(p.getName()); ex.setDescription(p.getDescription()); ex.setPrice(p.getPrice());
      return ResponseEntity.ok(repo.save(ex));
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    repo.deleteById(id); return ResponseEntity.noContent().build();
  }
}
