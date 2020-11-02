package com.example.demo.api;


import com.example.demo.api.dto.CleanerDTO;
import com.example.demo.api.dto.ManagerDTO;
import com.example.demo.api.dto.TrainerDTO;
import com.example.demo.model.Cleaner;
import com.example.demo.model.Manager;
import com.example.demo.model.Trainer;
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
@RequestMapping("/staff")
public class StaffController {
    private static final String address = "http://staff:8889";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    @Autowired
    public StaffController() {

    }

    @RequestMapping(method = RequestMethod.POST, value = "/trainer")
    public ResponseEntity<Trainer> addTrainer(@RequestBody TrainerDTO trainerDTO) {
        HttpEntity<TrainerDTO> trainers = new HttpEntity<>(trainerDTO);
        ResponseEntity<Trainer> response = restTemplate
                .exchange(address + "/staff/trainer", HttpMethod.POST,
                        trainers, Trainer.class);

        return ResponseEntity.ok(response.getBody());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cleaner")
    public ResponseEntity<Cleaner> addCleaner(@RequestBody CleanerDTO cleanerDTO) {
        HttpEntity<CleanerDTO> cleaners = new HttpEntity<>(cleanerDTO);
        ResponseEntity<Cleaner> response = restTemplate
                .exchange(address + "/staff/cleaner", HttpMethod.POST,
                        cleaners, Cleaner.class);

        return ResponseEntity.ok(response.getBody());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/manager")
    public ResponseEntity<Manager> addManager(@RequestBody ManagerDTO managerDTO) {
        HttpEntity<ManagerDTO> managers = new HttpEntity<>(managerDTO);
        ResponseEntity<Manager> response = restTemplate
                .exchange(address + "/staff/manager", HttpMethod.POST,
                        managers, Manager.class);

        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping("/trainer/{id}")
    public ResponseEntity<Void> deleteTrainerById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/staff/trainer/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cleaner/{id}")
    public ResponseEntity<Void> deleteCleanerById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/staff/cleaner/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/manager/{id}")
    public ResponseEntity<Void> deleteManagerById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/staff/manager/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/managers")
    public ResponseEntity<List<Manager>> getManagers() {
        ResponseEntity<Manager[]> response;
        response = restTemplate.exchange(address + "/staff/manager", HttpMethod.GET, headersEntity, Manager[].class);
        List<Manager> managers = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getTrainers() {
        ResponseEntity<Trainer[]> response;
        response = restTemplate.exchange(address + "/staff/trainer", HttpMethod.GET, headersEntity, Trainer[].class);
        List<Trainer> trainers = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(trainers);
    }

    @GetMapping("/cleaners")
    public ResponseEntity<List<Cleaner>> getCleaner() {
        ResponseEntity<Cleaner[]> response;
        response = restTemplate.exchange(address + "/staff/cleaner", HttpMethod.GET, headersEntity, Cleaner[].class);
        List<Cleaner> cleaners = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(cleaners);
    }


}
