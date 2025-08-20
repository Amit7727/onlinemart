package userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import userservice.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {}
 
