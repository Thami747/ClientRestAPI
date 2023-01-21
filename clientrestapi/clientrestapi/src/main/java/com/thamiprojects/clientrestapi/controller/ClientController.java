package com.thamiprojects.clientrestapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thamiprojects.clientrestapi.model.Client;
import com.thamiprojects.clientrestapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    //The below service is commented out as we're not persisting to any database at this time
//    @Autowired
//    private ClientService clientService;

    @PostMapping(value = "/saveClient")
    public String saveClient(@RequestBody Client client) {
        ObjectMapper mapper = new ObjectMapper();
        String response = "";

        if (isEmptyString(client.getFirstName())) {
            response = "Client firstName cannot be empty or null";
        } else if (isEmptyString(client.getLastName())) {
            response = "Client lastName cannot be empty or null";
        } else if (!isValidSouthAfricanID(client.getIdNumber())) {
            response = "South African ID number should contain 13 digits and cannot be empty or null";
        } else {
//            clientService.saveClient(client);
            response = "Successfully created Client";
        }

        return mapper.writeValueAsString(response);
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
