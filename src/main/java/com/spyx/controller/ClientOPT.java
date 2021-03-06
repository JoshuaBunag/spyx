package com.spyx.controller;

import com.spyx.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientOPT {

    int insertClient(UUID id ,Client client);

    default int insertClient(Client client) {
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    List<Client> selectAllClient();

    Optional<Client> selectClientById(UUID id);

    int deleteClientById(UUID id);

    int updateClientById(UUID id, Client client);
}
