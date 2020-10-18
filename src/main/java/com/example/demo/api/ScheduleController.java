package com.example.demo.api;

import com.example.demo.api.dto.CleanerTimeDTO;
import com.example.demo.api.dto.GroupMeetDTO;
import com.example.demo.api.dto.TrainerMeetDTO;
import com.example.demo.model.CleanerTime;
import com.example.demo.model.GroupMeet;
import com.example.demo.model.TrainerMeet;
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
@RequestMapping("/shedule")
public class ScheduleController {
    private static final String address = "http://localhost:8888";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    @Autowired
    public ScheduleController() {
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trainermeet")
    public ResponseEntity<TrainerMeet> addTrainerMeet(@RequestBody TrainerMeetDTO trainerMeetDTO) {
        HttpEntity<TrainerMeetDTO> trainersmeets = new HttpEntity<>(trainerMeetDTO);
        ResponseEntity<TrainerMeet> response = restTemplate
                .exchange(address + "/schedule/trainermeet", HttpMethod.POST,
                        trainersmeets, TrainerMeet.class);

        return ResponseEntity.ok(response.getBody());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/groupmeet")
    public ResponseEntity<GroupMeet> addGroupMeet(@RequestBody GroupMeetDTO groupMeetDTO) {
        HttpEntity<GroupMeetDTO> groupMeets = new HttpEntity<>(groupMeetDTO);
        ResponseEntity<GroupMeet> response = restTemplate
                .exchange(address + "/schedule/groupmeet", HttpMethod.POST,
                        groupMeets, GroupMeet.class);

        return ResponseEntity.ok(response.getBody());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cleanertime")
    public ResponseEntity<CleanerTime> addCleanerTime(@RequestBody CleanerTimeDTO cleanerTimeDTO) {
        HttpEntity<CleanerTimeDTO> cleanerTimes = new HttpEntity<>(cleanerTimeDTO);
        ResponseEntity<CleanerTime> response = restTemplate
                .exchange(address + "/schedule/cleanertime", HttpMethod.POST,
                        cleanerTimes, CleanerTime.class);

        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping("/trainermeet/{id}")
    public ResponseEntity<Void> deleteTrainerMeetById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/schedule/trainermeet/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/groupmeet/{id}")
    public ResponseEntity<Void> deleteGroupMeetById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/schedule/groupmeet/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cleanertime/{id}")
    public ResponseEntity<Void> deleteCleanerTimeById(@PathVariable UUID id) {
        HttpEntity<UUID> deleteItemById = new HttpEntity<>(id);
        ResponseEntity<Void> response = restTemplate
                .exchange(address + "/schedule/cleanertime/" + id, HttpMethod.DELETE,
                        deleteItemById, Void.class);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/trainermeet")
    public ResponseEntity<List<TrainerMeet>> getTrainerMeet() {
        ResponseEntity<TrainerMeet[]> response;
        response = restTemplate.exchange(address + "/schedule/trainermeet", HttpMethod.GET, headersEntity, TrainerMeet[].class);
        List<TrainerMeet> trainerMeets = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(trainerMeets);
    }

    @GetMapping("/cleanertime")
    public ResponseEntity<List<CleanerTime>> getCleanerTime() {
        ResponseEntity<CleanerTime[]> response;
        response = restTemplate.exchange(address + "/schedule/cleanertime", HttpMethod.GET, headersEntity, CleanerTime[].class);
        List<CleanerTime> cleanerTimes = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(cleanerTimes);
    }

    @GetMapping("/groupmeet")
    public ResponseEntity<List<GroupMeet>> getGroupMeet() {
        ResponseEntity<GroupMeet[]> response;
        response = restTemplate.exchange(address + "/schedule/groupmeet", HttpMethod.GET, headersEntity, GroupMeet[].class);
        List<GroupMeet> groupMeets = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(groupMeets);
    }

}
