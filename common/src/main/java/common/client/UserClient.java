package common.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import common.dto.UserDto;

@FeignClient(name="user-service", url="${user.service.url}")
public interface UserClient {
  @GetMapping("/api/users/{id}")
  UserDto getById(@PathVariable("id") Long id);
}