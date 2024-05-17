package com.example.soapproject.endpoints;

import com.example.soapproject.models.Client;
import com.example.soapproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soapproject.GetClientByIdResponse;
import com.example.soapproject.GetClientByIdRequest;
import com.example.soapproject.ClientInfo; // Ensure this import is correct based on your generated classes

@Endpoint
public class ClientEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soapproject";

    @Autowired
    private ClientService clientService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetClientByIdRequest")
    @ResponsePayload
    public GetClientByIdResponse getClientById(@RequestPayload GetClientByIdRequest request) {
        GetClientByIdResponse response = new GetClientByIdResponse();
        Client client = clientService.getClientById(request.getId());
        if (client != null) {
            response.setClient(mapClientToClientInfo(client));

        } else {
            // Optionally handle null case explicitly if needed
        }
        return response;
    }

    private ClientInfo mapClientToClientInfo(Client client) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setId(client.getId());
        clientInfo.setNom(client.getNom());
        clientInfo.setEmail(client.getEmail());
        clientInfo.setTelephone(client.getTelephone());
        return clientInfo;
    }
}
