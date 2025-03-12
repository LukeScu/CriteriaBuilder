package org.example.criteriabuilder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="Emp1")
@Data
public class Emp1 {

    @Column(name="Empno")
    @Id
    private int empId;

    @Column(name="Ename")
    private String ename;

    @Column(name="Job")
    private String job;

    @Column(name="Mgr")
    private Integer mgr;

    @Column(name="Hiredate")
    private Date hiredate;

    @Column(name="Sal")
    private Double sal;

    @Column(name="Comm")
    private Integer comm;

    @ManyToOne
    @JoinColumn(name = "Deptno")
    private Dept dept;
}
