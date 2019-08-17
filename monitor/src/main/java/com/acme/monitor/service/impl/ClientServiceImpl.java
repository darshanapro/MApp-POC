package com.acme.monitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acme.monitor.controller.request.ClientRequest;
import com.acme.monitor.controller.response.ClientResponse;
import com.acme.monitor.dao.ClientDao;
import com.acme.monitor.model.Client;
import com.acme.monitor.service.ClientService;

@Service(value = "clientService")
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientDao clientDao;

  @Override
  public Client getByName(String clientName) {

    return clientDao.findByNameIgnoreCase(clientName);

  }

  @Override
  public ClientResponse getById(int clientId) {

    Client client = clientDao.findByClientId(clientId);
    return (client == null ? null : new ClientResponse(client.getClient_id(), client.getName()));
  }

  @Override
  public ClientResponse save(ClientRequest clientRequest) {

    Client client = new Client();
    client.setCreatedBy(0); // TODO : need to make dynamic
    client.setUpdatedBy(0); // TODO : need to make dynamic
    client.setName(clientRequest.getName()); // TODO : need to add validation for duplication
    return getClientResponse(clientDao.save(client));

  }

  @Override
  public ClientResponse update(ClientRequest clientRequest) {

    Client client = clientDao.findByClientId(clientRequest.getClient_id());

    if (client != null) {
      client.setName(clientRequest.getName()); // TODO : need to add validation for duplication
      client.setUpdatedBy(0);
      client = clientDao.save(client);
    }

    return getClientResponse(client);

  }


  private ClientResponse getClientResponse(Client client) {

    return (client != null ? new ClientResponse(client.getClient_id(), client.getName()) : null);

  }

}
