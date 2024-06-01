package com.example.domain.controller;

import com.example.domain.model.EntityModel;
import com.example.domain.repository.EntityRepository;
import com.example.orchestrator.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private EntityRepository entityRepository;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveEntity(@RequestBody EntityModel entity) {
        try {
            if (entity.getNombre() == null || entity.getNombre().isEmpty() || entity.getPrecio() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Datos inválidos", null));
            }
            entityRepository.save(entity);
            return ResponseEntity.ok(new ApiResponse("Entidad guardada correctamente", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error guardando la entidad", e.getMessage()));
        }
    }

    @GetMapping("/entities")
    public ResponseEntity<List<EntityModel>> getAllEntities() {
        List<EntityModel> entities = entityRepository.findAll();
        return ResponseEntity.ok(entities);
    }

}
