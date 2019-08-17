package com.acme.monitor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.acme.monitor.model.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

  @Query("From Client c WHERE c.client_id = :clientId")
  public Client findByClientId(@Param("clientId") int clientId);

  public Client findByNameIgnoreCase(String name);
}
