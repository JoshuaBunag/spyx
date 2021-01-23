package com.spyx.controller;

import com.spyx.model.Client;
import com.spyx.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("model/client")
@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @GetMapping
    public List<Client> getAllClient() {
        return clientService.getAllName();
    }

    @GetMapping(path = "{id}")
    public Client getClientById(@PathVariable("id") UUID id) {
        return clientService.getClientByid(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClientById(@PathVariable("id") UUID id) {
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{id}")
    public void updateClientById(@PathVariable("id") UUID id, @RequestBody Client clientToUpdate) {
        clientService.updateClient(id, clientToUpdate);
    }

}
