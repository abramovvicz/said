package com.saidproject.saidproject.controller.healthcheck;

import com.saidproject.saidproject.utils.ResultMessage;
import com.saidproject.saidproject.utils.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/checkProfile")
public class SomeControllerToChange {
    @Autowired
    Environment env;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> result = new HashMap<>();
        result.put(ResultMessage.RESULT_KEY, env.getActiveProfiles());
        result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
        return ResponseEntity.ok(result);
    }
}
