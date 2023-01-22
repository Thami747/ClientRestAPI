package com.thamiprojects.clientrestapi.service;

import com.thamiprojects.clientrestapi.model.Client;

import java.io.IOException;
import java.util.List;

//The below service is not used as we're not persisting to any database at this time
public interface ClientService {
    void saveClient(List<Client> client) throws IOException;

    void updateClient(List<Client> client) throws IOException;

    Client getClient(String id) throws IOException;

}
