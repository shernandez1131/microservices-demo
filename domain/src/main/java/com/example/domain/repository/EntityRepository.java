package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.domain.model.EntityModel;

public interface EntityRepository extends JpaRepository<EntityModel, Long> {
}
