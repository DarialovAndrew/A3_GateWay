package com.example.demo.api;

import com.example.demo.api.dto.ClientDTO;
import com.example.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final String address = "http://clients:8887";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    @Autowired
    ClientController() {

    }

    @GetMapping()
    public ResponseEntity<List<Client>> getClients() {
        ResponseEntity<Client[]> response;
        response = restTemplate.exchange(address + "/client", HttpMethod.GET, headersEntity, Client[].class);
        List<Client> clients = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(clients);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Client> addClient(@RequestBody ClientDTO clientDTO) {
        HttpEntity<ClientDTO> clients = new HttpEntity<>(clientDTO);
        ResponseEntity<Client> response = restTemplate
                .exchange(address + "/client", HttpMethod.POST,
                        clients, Client.class);

        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApparatusById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/client/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }


}