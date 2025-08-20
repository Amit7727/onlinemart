package userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import userservice.entity.User;
import userservice.exceptions.NoUserFound;
import userservice.repo.UserRepository;

@org.springframework.stereotype.Service
public class Service {
	
	private final UserRepository repo;
	  @Autowired
	  public Service(UserRepository repo) { this.repo = repo; }
	  
	  public User getUserByUd(Long id) {
		  return repo.findById(id)
          .orElseThrow(() -> new NoUserFound("No user with this id"));

	  }
}
