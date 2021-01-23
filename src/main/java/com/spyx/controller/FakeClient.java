package com.spyx.controller;

import com.spyx.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("Fake")
public class FakeClient implements ClientOPT{

    private static List<Client> DB = new ArrayList<>();


    @Override
    public int insertClient(UUID id, Client client) {
        DB.add(new Client(id, client.getName()));
        return 1;
    }

    @Override
    public List<Client> selectAllClient() {
        return DB;
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {
        return DB.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteClientById(UUID id) {
        Optional<Client> clientMaybe = selectClientById(id);
        if (clientMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateClientById(UUID id, Client client) {
        return selectClientById(id)
                .map(c -> {
                    int indexOfClientToDelete = DB.indexOf(client);
                    if (indexOfClientToDelete >= 0) {
                        DB.set(indexOfClientToDelete, client);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
