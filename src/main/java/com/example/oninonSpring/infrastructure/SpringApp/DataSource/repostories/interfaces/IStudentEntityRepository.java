package com.example.oninonSpring.infrastructure.SpringApp.DataSource.repostories.interfaces;

import com.example.oninonSpring.infrastructure.SpringApp.DataSource.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentEntityRepository extends JpaRepository<StudentEntity, Integer> {

}
