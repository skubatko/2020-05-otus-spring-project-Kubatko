package ru.skubatko.dev.ees.ui.feign;

import ru.skubatko.dev.ees.ui.feign.dto.UserDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "users")
public interface UsersResourceFeignClient {

    @GetMapping("/users/{name}")
    Optional<UserDto> findByName(@PathVariable String name);

    @GetMapping("/users")
    List<UserDto> findAll();

    @PostMapping("/users")
    void save(@RequestBody UserDto map);

    @PutMapping("/users/{name}")
    void update(@PathVariable("name") String name, @RequestBody UserDto dto);

    @DeleteMapping("/users/{name}")
    void deleteByName(@PathVariable String name);
}
