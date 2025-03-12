package org.example.criteriabuilder.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Emp")
@Data
@ToString(exclude = {"subordinati", "rowid"})
public class Emp {

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

    //Per esercizio 16
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "Rowid", insertable = false, updatable = false)
    private String rowid;

    //Per esercizio 44 e 68
    //FetchType.EAGER per formattazione corretta dell'esercizio 44 (tranne se spring.jpa.show-sql=false in properties)
    //FetchType.LAZY per gli altri esercizi: non ci interessa ricavare i subordinati ad ogni query
    @OneToMany(mappedBy = "mgr", fetch = FetchType.LAZY)
    private List<Emp> subordinati;

}
