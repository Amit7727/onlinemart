package userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import userservice.entity.User;
import userservice.repo.UserRepository;
import userservice.service.Service;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private Service myservice;
	
  private final UserRepository repo;
  @Autowired
  public UserController(UserRepository repo) { this.repo = repo; }

  @GetMapping public List<User> all() { return repo.findAll(); }

  @GetMapping("/{id}") public ResponseEntity<User> one(@PathVariable("id") Long id) {
    return new ResponseEntity<User>(myservice.getUserByUd(id),HttpStatus.OK);
  }

  @PostMapping public ResponseEntity<User> create(@RequestBody User u) {
    User saved = repo.save(u);
    return ResponseEntity.created(URI.create("/api/users/" + saved.getId())).body(saved);
  }

  @PutMapping("/{id}") public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User u) {
    return repo.findById(id).map(ex -> {
      ex.setName(u.getName()); ex.setEmail(u.getEmail());
      return ResponseEntity.ok(repo.save(ex));
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    repo.deleteById(id); return ResponseEntity.noContent().build();
  }
}

