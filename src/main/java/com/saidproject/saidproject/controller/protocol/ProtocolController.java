package com.saidproject.saidproject.controller.protocol;

import com.saidproject.saidproject.dao.protocol.Protocol;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.protocol.IProtocolService;
import com.saidproject.saidproject.utils.ResultMessage;
import com.saidproject.saidproject.utils.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/protocols")
public class ProtocolController implements IProtocolController {

    static final Logger logger = LoggerFactory.getLogger(ProtocolController.class);

    @Autowired
    private IProtocolService protocolService;

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Integer id) throws NotFoundException {
        Map<String, Object> result = new HashMap<>();
        Protocol protocol = protocolService.findById(id);
        if (protocol != null) {
            result.put(ResultMessage.RESULT_KEY, protocol);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Measurement with id: " + id + " not found");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll() throws NotFoundException {
        logger.info("this is it");

        Map<String, Object> result = new HashMap<>();
        List<Protocol> protocols = protocolService.findAll();
        if (protocols != null) {
            result.put(ResultMessage.RESULT_KEY, protocols);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Protocols not found");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Protocol protocol) {
        logger.info("ataken na post protocol");

        Map<String, Object> result = new HashMap<>();
        Protocol savedProtocol = protocolService.save(protocol);
        if (savedProtocol != null) {
            result.put(ResultMessage.RESULT_KEY, savedProtocol);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something went wrong, please try again");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(Protocol entity) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> delete(Integer id) {
        return null;
    }
}
