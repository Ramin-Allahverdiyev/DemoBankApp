package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.entity.AuthType;
import com.example.demoBankApp.entity.Authority;
import com.example.demoBankApp.mapper.ClientMapper;
import com.example.demoBankApp.repository.ClientRepository;
import com.example.demoBankApp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private static final Logger logger= LoggerFactory.getLogger(ClientServiceImpl.class);

    @Override
    public Optional<ClientResponse> registerClient(ClientRequest request) {
        logger.info("ActionLog.registerClient.start request: {}",request);
        var client = ClientMapper.INSTANCE.dtoToEntity(request);
        Set<AuthType> authTypes = request.getAuthType();
        Set<Authority> authorities = authTypes.stream()
                .map(authType -> new Authority(authType.name()))
                .collect(Collectors.toSet());
        client.setAuthorities(authorities);
        var savedClient = clientRepository.save(client);
        var response=ClientMapper.INSTANCE.entityToDto(savedClient);
        logger.info("ActionLog.registerClient.stop response: {}",response);
        return Optional.of(response);
    }

    @Override
    public Page<ClientResponse> findAllByPage(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(ClientMapper.INSTANCE::entityToDto);
    }

}
