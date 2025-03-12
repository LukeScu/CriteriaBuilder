package org.example.criteriabuilder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Dept")
@Data
public class Dept {

    @Column(name="Deptno")
    @Id
    private int deptno;

    @Column(name="Dname")
    private String deptName;

    @Column(name="Loc")
    private String loc;

}
