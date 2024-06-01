package com.example.orchestrator.model;

import lombok.Data;

@Data // Genera getters, setters, toString, equals y hashCode
public class RequestModel {
    private String nombre;
    private double precio;
}