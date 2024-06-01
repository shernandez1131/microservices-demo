package com.example.domain;

import com.example.domain.controller.DomainController;
import com.example.domain.model.EntityModel;
import com.example.domain.repository.EntityRepository;
import com.example.orchestrator.model.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DomainControllerTests {

    @InjectMocks
    private DomainController domainController;

    @Mock
    private EntityRepository entityRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEntityWithValidData() {
        // Arrange
        EntityModel entity = new EntityModel(1L, "Producto A", 10.0);

        // Act
        ResponseEntity<ApiResponse> response = domainController.saveEntity(entity);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Entidad guardada correctamente", response.getBody().getMessage());
    }

    @Test
    void testGetAllEntities() {
        // Arrange
        List<EntityModel> entities = new ArrayList<>();
        entities.add(new EntityModel(1L, "Producto A", 10.0));
        entities.add(new EntityModel(2L, "Producto B", 20.0));
        when(entityRepository.findAll()).thenReturn(entities);

        // Act
        ResponseEntity<List<EntityModel>> response = domainController.getAllEntities();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(entities, response.getBody());
    }
}