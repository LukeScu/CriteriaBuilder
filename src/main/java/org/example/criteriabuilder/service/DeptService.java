package org.example.criteriabuilder.service;

import org.example.criteriabuilder.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService implements IDeptService{

    DeptRepository deptRepository;

    @Autowired
    public DeptService(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

}
