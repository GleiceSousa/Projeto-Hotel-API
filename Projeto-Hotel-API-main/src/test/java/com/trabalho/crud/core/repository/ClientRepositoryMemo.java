package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Client;

@ActiveProfiles("test")
@Repository
public class ClientRepositoryMemo implements ClientRepository {

  private final List<Client> clients = new ArrayList<Client>();

  @Override
  public List<Client> findAll() {
    return clients;
  }

  @Override
  public Optional<Client> findById(Long id) {
    return clients.stream().filter(client -> client.getId().equals(id)).findFirst();
  }

  @Override
  public Client save(Client client) {
    var id = clients.size() + 1;
    client.setId((long) id);
    clients.add(client);
    return client;
  }

  @Override
  public void deleteById(Long id) {
    clients.removeIf(client -> client.getId() == id);
  }
}
