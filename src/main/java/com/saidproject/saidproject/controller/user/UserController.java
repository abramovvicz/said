package com.saidproject.saidproject.controller.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    @Autowired
    public UserService userService;

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findById(@PathVariable("id") Integer id) throws EmptyResultDataAccessException {
        User user = userService.findById(id);
        return Objects.isNull(user) ? ResponseEntity.badRequest().body(new User()) : ResponseEntity.ok(user);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAll() {
        List<User> allUsers = userService.findAll();
        return allUsers.isEmpty() ? ResponseEntity.badRequest().body(Collections.emptyList()) : ResponseEntity.ok(allUsers);
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody User entity) {
        User savedUser = userService.save(entity);
        return Objects.isNull(savedUser) ? ResponseEntity.badRequest().body(new User()) : ResponseEntity.ok(savedUser);
    }

    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody User entity) {
        boolean isSaved = userService.update(entity);
        return new ResponseEntity(isSaved ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity delete(@PathParam("id") Integer id) {
        boolean isDeleted = userService.delete(id);
        return new ResponseEntity(isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
