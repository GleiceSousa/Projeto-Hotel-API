package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Client;
import com.trabalho.crud.core.repository.ClientRepository;

@ActiveProfiles("test")
@SpringBootTest
class ClientServiceTest {

  @Autowired
  private ClientRepository repository;

  @Autowired
  private ClientService service;

  @BeforeEach
  void populateRepository() {
    MockitoAnnotations.openMocks(this);
    repository.save(Client.builder().name("Client 1").email("email1@email.com").build());
    repository.save(Client.builder().name("Client 2").email("email2@email.com").build());
    repository.save(Client.builder().name("Client 3").email("email3@email.com").build());
  }

  @Test
  @DisplayName("Busca todos os clientes")
  void testBuscarTodosOsClients() {
    var allClients = service.findAll();

    assertEquals(3, allClients.size());
  }
}
