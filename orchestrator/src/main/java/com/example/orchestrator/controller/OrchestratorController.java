package com.example.orchestrator.controller;

import com.example.orchestrator.model.ApiResponse;
import com.example.orchestrator.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orchestrator")
@CrossOrigin(origins = "http://localhost:4200")
public class OrchestratorController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/process")
    public ResponseEntity<ApiResponse> processRequest(@RequestBody RequestModel request) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/domain/save", request, String.class);
            return ResponseEntity.ok(new ApiResponse("Entidad procesada correctamente", response.getBody()));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(new ApiResponse("Error procesando la solicitud", e.getResponseBodyAsString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error procesando la solicitud", e.getMessage()));
        }
    }

    @GetMapping("/entities")
    public ResponseEntity<List<Map<String, Object>>> getAllEntities() {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8081/domain/entities", List.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
