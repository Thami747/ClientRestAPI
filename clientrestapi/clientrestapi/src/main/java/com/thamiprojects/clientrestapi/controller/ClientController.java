package com.thamiprojects.clientrestapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thamiprojects.clientrestapi.model.Client;
import com.thamiprojects.clientrestapi.service.ClientService;
import com.thamiprojects.clientrestapi.utilities.ClientObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    //The below service is commented out as we're not persisting to any database at this time
    @Autowired
    private ClientService clientService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/saveClient")
    public Client saveClient(@RequestBody Client client) throws IOException {
        Client clientResponse = new Client();
        boolean isDuplicate = false;

        System.out.println("Hello:----" + objectMapper.writeValueAsString(ClientObjectMapper.getClientsFromJson()));
        if (isEmptyString(client.getFirstName())) {
            clientResponse.setMessage("Client firstName cannot be empty or null");
        } else if (isEmptyString(client.getLastName())) {
            clientResponse.setMessage("Client lastName cannot be empty or null");
        } else if (!isValidSouthAfricanID(client.getIdNumber())) {
            clientResponse.setMessage("South African ID number should contain 13 digits and cannot be empty or null");
        } else {
            for (Client clientObj : ClientObjectMapper.getClientsFromJson()) {
                if (clientObj.getIdNumber().equals(client.getIdNumber()) || clientObj.getMobileNumber().equals(client.getMobileNumber())) {
                    clientResponse.setMessage("Filed to create Client, either ID number or mobile number is duplicate");
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                List<Client> newClientList = ClientObjectMapper.getClientsFromJson();
                client.setMessage("Successfully created Client");
                newClientList.add(client);
                clientService.saveClient(newClientList);
                clientResponse = client;

            }
        }
        return clientResponse;
    }

    @PostMapping(value = "/updateClient")
    public Client updateClient(@RequestBody Client client) throws IOException {
        Client clientResponse = new Client();
        boolean clientExists = false;
        int index = 0;

        System.out.println("Hello:----" + objectMapper.writeValueAsString(ClientObjectMapper.getClientsFromJson()));
        if (isEmptyString(client.getFirstName())) {
            clientResponse.setMessage("Client firstName cannot be empty or null");
        } else if (isEmptyString(client.getLastName())) {
            clientResponse.setMessage("Client lastName cannot be empty or null");
        } else if (!isValidSouthAfricanID(client.getIdNumber())) {
            clientResponse.setMessage("South African ID number should contain 13 digits and cannot be empty or null");
        } else {
            for (Client clientObj : ClientObjectMapper.getClientsFromJson()) {
                if (clientObj.getIdNumber().equals(client.getIdNumber())) {
                    List<Client> newClientList = ClientObjectMapper.getClientsFromJson();
                    newClientList.get(index).setFirstName(client.getFirstName());
                    newClientList.get(index).setLastName(client.getLastName());
                    newClientList.get(index).setMobileNumber(client.getMobileNumber());
                    newClientList.get(index).setAddress(client.getAddress());
                    newClientList.get(index).setMessage("Successfully updated Client");
                    client.setMessage("Successfully updated Client");
                    clientService.updateClient(newClientList);
                    clientResponse = client;
                    clientExists = true;
                    break;
                }
                ++index;
            }

            if (!clientExists) {
                clientResponse.setMessage("Client does not exist!");
            }
        }
        return clientResponse;
    }

    private boolean isEmptyString(String s) {
        if (s != null && !s.isEmpty())
            return false;
        else
            return true;
    }

    //--TODO the below function requires a third party API to validate the accuracy of a South African ID number--
    private boolean isValidSouthAfricanID(String idNumber) {
        if (isEmptyString(idNumber)) {
            return false;
        } else {
            if (idNumber.length() != 13)
                return false;
            else
                return true;
        }
    }
}
