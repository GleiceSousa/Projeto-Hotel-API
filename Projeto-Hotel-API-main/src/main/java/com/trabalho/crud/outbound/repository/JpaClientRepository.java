package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Client;
import com.trabalho.crud.core.repository.ClientRepository;

@Profile("!test")
public interface JpaClientRepository extends ClientRepository, JpaRepository<Client, Long> {
}
