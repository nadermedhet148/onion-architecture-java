package demoTest.infrastructure.SpringApp.DataSource.repostories.JPAInterfaces;

import demoTest.infrastructure.SpringApp.DataSource.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentEntityRepository extends JpaRepository<StudentEntity, Integer> {

}
