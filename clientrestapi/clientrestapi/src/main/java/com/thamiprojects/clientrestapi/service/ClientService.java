package com.thamiprojects.clientrestapi.service;

import com.thamiprojects.clientrestapi.model.Client;

//The below service is not used as we're not persisting to any database at this time
public interface ClientService {
    public Client saveClient(Client client);
}
