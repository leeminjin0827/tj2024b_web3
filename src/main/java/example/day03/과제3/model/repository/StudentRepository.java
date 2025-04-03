package example.day03.과제3.model.repository;

import example.day03.과제3.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
    extends JpaRepository<StudentEntity, Integer > {
} // i end
