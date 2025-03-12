package org.example.provahibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Salgrade")
@Data
public class Salgrade {

    @Column(name="Grade")
    @Id
    private int empId;

    @Column(name="Losal")
    private int losal;

    @Column(name="Hisal")
    private int hisal;
}
