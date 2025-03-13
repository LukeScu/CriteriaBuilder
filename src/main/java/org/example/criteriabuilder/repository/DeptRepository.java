package org.example.criteriabuilder.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DeptRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
