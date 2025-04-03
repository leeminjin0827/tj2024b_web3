package example.day03.과제3.model.repository;

import example.day03.과제3.model.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository
    extends JpaRepository<CourseEntity, Integer > {
} // i end
