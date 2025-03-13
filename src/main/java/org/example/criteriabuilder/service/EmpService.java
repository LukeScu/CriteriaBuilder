package org.example.criteriabuilder.service;

import org.example.criteriabuilder.entity.Emp;
import org.example.criteriabuilder.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService implements IEmpService{

    EmpRepository empRepository;

    @Autowired
    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public void esercizio1() {
        List<Emp> lista = this.empRepository.esercizio1();
        lista.forEach(System.out::println);
    }
}
