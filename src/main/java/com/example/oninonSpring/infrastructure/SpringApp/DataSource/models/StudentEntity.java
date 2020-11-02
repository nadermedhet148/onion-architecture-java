package com.example.oninonSpring.infrastructure.SpringApp.DataSource.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class StudentEntity {

    @Id
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name;
}
