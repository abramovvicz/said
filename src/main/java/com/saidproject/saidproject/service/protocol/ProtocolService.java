package com.saidproject.saidproject.service.protocol;

import com.saidproject.saidproject.dao.protocol.Protocol;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.repo.h2.protocol.H2ProtocolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProtocolService implements IProtocolService {
    
    @Autowired
    private H2ProtocolRepo h2ProtocolRepo;

    @Override
    public Protocol findById(int id) throws NotFoundException {
        Protocol protocolById = h2ProtocolRepo.findById(id);
        if (protocolById == null) {
            throw new NotFoundException("Protocol not found");
        }

        return protocolById;
    }

    @Override
    public List<Protocol> findAll() throws NotFoundException {
        return null;
    }

    @Override
    public Protocol save(Protocol protocol) {
        Protocol savedProtocol = h2ProtocolRepo.save(protocol);
        return savedProtocol;
    }

    @Override
    public boolean update(Protocol entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
