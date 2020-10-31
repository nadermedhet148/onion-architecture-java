package demoTest.infrastructure.SpringApp.DataSource.repostories.JPAInterfaces;

import demoTest.infrastructure.SpringApp.DataSource.models.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseEntityRepository extends JpaRepository<CourseEntity, Integer> {

}
