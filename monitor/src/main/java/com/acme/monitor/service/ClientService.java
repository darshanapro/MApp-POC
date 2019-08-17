package com.acme.monitor.service;

import com.acme.monitor.controller.request.ClientRequest;
import com.acme.monitor.controller.response.ClientResponse;
import com.acme.monitor.model.Client;

public interface ClientService {

  Client getByName(String clientName);
  
  ClientResponse getById(int clientId);
  
  ClientResponse save(ClientRequest clientRequest);
  
  ClientResponse update(ClientRequest clientRequest);
}
