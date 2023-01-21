package com.thamiprojects.clientrestapi.service;

import com.thamiprojects.clientrestapi.model.Client;
import com.thamiprojects.clientrestapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//The below service implementation is commented out as we're not persisting to any database at this time
@Service
public class ClientServiceImpl implements ClientService {

//    @Autowired
//    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
//        return clientRepository.save(client);
        return client;
    }
}
