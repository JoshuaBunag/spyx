package com.spyx.service;

import com.spyx.controller.ClientOPT;
import com.spyx.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientOPT clientOPT;

    @Autowired
    public ClientService(@Qualifier("Fake") ClientOPT clientOPT) {
        this.clientOPT = clientOPT;
    }

    public int addClient(Client client) {
        return clientOPT.insertClient(client);
    }

    public List<Client> getAllName() {
        return clientOPT.selectAllClient();
    }

    public Optional<Client> getClientByid(UUID id) {
        return clientOPT.selectClientById((id));
    }

    public int deleteClient(UUID id) {
        return clientOPT.deleteClientById(id);
    }

    public int updateClient(UUID id, Client newClient) {
        return clientOPT.updateClientById(id, newClient);
    }

}
