package com.thamiprojects.clientrestapi.service;

import com.thamiprojects.clientrestapi.model.Client;
import com.thamiprojects.clientrestapi.utilities.ClientObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//The below service implementation is commented out as we're not persisting to any database at this time
@Service
public class ClientServiceImpl implements ClientService {

    public void saveClient(List<Client> client) throws IOException {
        ClientObjectMapper.saveNewClient(client);
    }

    public void updateClient(List<Client> client) throws IOException {
        ClientObjectMapper.saveNewClient(client);
    }
}
