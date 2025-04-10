package example.day04._과제4.model.repository;

import example.day04._과제4.model.entity.Task4Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Task4Repository extends JpaRepository<Task4Entity , Integer > {

}
