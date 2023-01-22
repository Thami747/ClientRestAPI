package com.thamiprojects.clientrestapi.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thamiprojects.clientrestapi.model.Client;

import java.io.*;
import java.util.List;

public class ClientObjectMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String filePath = "src/test/resources/clientList.json";
    public static List<Client> getClientsFromJson() throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        TypeReference<List<Client>> typeReference = new TypeReference<>() {};
        return objectMapper.readValue(inputStream, typeReference);
    }

    public static void saveNewClient(List<Client> client) throws IOException {
        objectMapper.writeValue(new File(filePath), client);
    }
}
