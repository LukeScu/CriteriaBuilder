package org.example.criteriabuilder.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.example.criteriabuilder.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmpRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Emp> esercizio1() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from);

        return entityManager.createQuery(query).getResultList();
    }
}



