package org.example.provahibernate.service;

import jakarta.persistence.Tuple;
import org.example.provahibernate.entity.Dept;
import org.example.provahibernate.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptService implements IDeptService{

    DeptRepository deptRepository;

    @Autowired
    public DeptService(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public void findAll() {
        List<Dept> lista = this.deptRepository.findAllDept();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio43() {
        List<Dept> lista = this.deptRepository.esercizio43();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio51() {
        List<Tuple> lista = this.deptRepository.esercizio51();
        lista.forEach(System.out::println);
    }

    @Override
    public void esercizio52() {
        List<Dept> lista = this.deptRepository.esercizio52();
        lista.forEach(System.out::println);
    }

    @Override
    @Transactional
    public void esercizio88() {
        this.deptRepository.esercizio88();
    }
}
