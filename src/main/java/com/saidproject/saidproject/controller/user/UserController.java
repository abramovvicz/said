package com.saidproject.saidproject.controller.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    @Autowired
    public UserService userService;

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        return Objects.isNull(user) ?  new ResponseEntity<>( HttpStatus.NOT_FOUND) : new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(pattern = "YYYY-mm-dd")
    public ResponseEntity save(@RequestBody User entity) {
        boolean isSaved = userService.save(entity);
        return new ResponseEntity(isSaved ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
    }

    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
