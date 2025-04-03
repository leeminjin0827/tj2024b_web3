package example.day03._과제3RE.model.repository;

import example.day03._과제3RE.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEntityRepository
    extends JpaRepository<StudentEntity , Integer > {
}
