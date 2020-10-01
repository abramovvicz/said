package com.saidproject.saidproject.controller.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.user.UserService;
import com.saidproject.saidproject.utils.ResultMessage;
import com.saidproject.saidproject.utils.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    @Autowired
    public UserService userService;

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Integer id) throws NotFoundException {
        Map<String, Object> result = new HashMap<>();
        User user = userService.findById(id);
        if (user != null) {
            result.put(ResultMessage.RESULT_KEY, user);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            result.put(ResultMessage.MESSAGE_KEY, "User with id: " + id + " not found");
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll() throws NotFoundException {
        List<User> allUsers = userService.findAll();
        Map<String, Object> result = new HashMap<>();
        if (allUsers != null && !allUsers.isEmpty()) {
            result.put(ResultMessage.RESULT_KEY, allUsers);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "List of all users is empty");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody User entity) {
        Map<String, Object> result = new HashMap<>();
        User savedUser = userService.save(entity);
        if (savedUser != null) {
            result.put(ResultMessage.RESULT_KEY, savedUser);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Somethings gone wrong, please try again.");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody User entity) {
        Map<String, Object> result = new HashMap<>();
        boolean isSaved = userService.update(entity);
        if (isSaved) {
            result.put(ResultMessage.RESULT_KEY, entity);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Somethings gone wrong, please try again.");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Integer id) {
        Map<String, Object> result = new HashMap<>();
        boolean isDeleted = userService.delete(id);
        if (isDeleted) {
            result.put(ResultMessage.RESULT_KEY, id);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Could delete user, please try again.");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }
}
