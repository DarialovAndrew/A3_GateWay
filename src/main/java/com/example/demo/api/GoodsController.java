package com.example.demo.api;

import com.example.demo.api.dto.ApparatusDTO;
import com.example.demo.api.dto.LockerDTO;
import com.example.demo.api.dto.ShowerDTO;
import com.example.demo.model.Apparatus;
import com.example.demo.model.Locker;
import com.example.demo.model.Shower;
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
@RequestMapping("/goods")
public class GoodsController {

    private static final String address = "http://goods:8890";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    @Autowired
    GoodsController() {

    }

    @GetMapping("/apparatuses")
    public ResponseEntity<List<Apparatus>> getApparatus() {
        ResponseEntity<Apparatus[]> response;
        response = restTemplate.exchange(address + "/goods/apparatuses", HttpMethod.GET, headersEntity, Apparatus[].class);
        List<Apparatus> apparatuses = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(apparatuses);
    }

    @GetMapping("/shower")
    public ResponseEntity<List<Shower>> getShower() {
        ResponseEntity<Shower[]> response;
        response = restTemplate.exchange(address + "/goods/showers", HttpMethod.GET, headersEntity, Shower[].class);
        List<Shower> showers = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(showers);
    }

    @GetMapping("/locker")
    public ResponseEntity<List<Locker>> getLocker() {
        ResponseEntity<Locker[]> response;
        response = restTemplate.exchange(address + "/goods/lockers", HttpMethod.GET, headersEntity, Locker[].class);
        List<Locker> lockers = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(lockers);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/apparatus")
    public ResponseEntity<Apparatus> addApparatus(@RequestBody ApparatusDTO apparatusDTO) {
        HttpEntity<ApparatusDTO> apparatus = new HttpEntity<>(apparatusDTO);
        ResponseEntity<Apparatus> response = restTemplate
                .exchange(address + "/goods/apparatus", HttpMethod.POST,
                        apparatus, Apparatus.class);

        return ResponseEntity.ok(response.getBody());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shower")
    public ResponseEntity<Shower> addShower(@RequestBody ShowerDTO showerDTO) {
        HttpEntity<ShowerDTO> shower = new HttpEntity<>(showerDTO);
        ResponseEntity<Shower> response = restTemplate
                .exchange(address + "/goods/shower", HttpMethod.POST,
                        shower, Shower.class);

        return ResponseEntity.ok(response.getBody());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/locker")
    public ResponseEntity<Locker> addLocker(@RequestBody LockerDTO lockerDTO) {
        HttpEntity<LockerDTO> locker = new HttpEntity<>(lockerDTO);
        ResponseEntity<Locker> response = restTemplate
                .exchange(address + "/goods/locker", HttpMethod.POST,
                        locker, Locker.class);

        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping("/apparatus/{id}")
    public ResponseEntity<Void> deleteApparatusById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/goods/apparatus/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/shower/{id}")
    public ResponseEntity<Void> deleteShowerById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/goods/shower/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/locker/{id}")
    public ResponseEntity<Void> deleteLockerById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/goods/locker/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }


}