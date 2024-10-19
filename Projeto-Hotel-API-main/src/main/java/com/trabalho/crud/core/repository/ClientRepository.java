package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.Client;

public interface ClientRepository {

  List<Client> findAll();

  Optional<Client> findById(Long id);

  Client save(Client client);

  void deleteById(Long id);
}
