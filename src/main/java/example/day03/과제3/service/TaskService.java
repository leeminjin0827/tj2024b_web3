package example.day03.과제3.service;

import example.day03.과제3.model.dto.CourseDto;
import example.day03.과제3.model.dto.StudentDto;
import example.day03.과제3.model.entity.CourseEntity;
import example.day03.과제3.model.entity.StudentEntity;
import example.day03.과제3.model.repository.CourseRepository;
import example.day03.과제3.model.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    // 과정 등록
    public boolean coursePost( CourseDto courseDto ){
        System.out.println("TaskService.coursePost");
        System.out.println("courseDto = " + courseDto);
        CourseEntity courseEntity = courseDto.toEntity();
        courseRepository.save( courseEntity );
        return true;
    } // f end
    
    // 과정 전체 조회
    public List<CourseDto> courseGet(){
        System.out.println("TaskService.courseGet");
        List< CourseEntity > courseEntityList = courseRepository.findAll();
        System.out.println("courseEntityList = " + courseEntityList);
        return courseEntityList.stream()
                .map( courseEntity -> courseEntity.toDto() )
                .collect(Collectors.toList() );
    } // f end
    
    // 특정 과정에 수강생 등록
    public boolean studentPost( StudentDto studentDto ){
        System.out.println("TaskService.studentPost");
        System.out.println("studentDto = " + studentDto);
        StudentEntity studentEntity = studentDto.tiEntity();
        studentRepository.save( studentEntity );
        return true;
    } // f end
    
    // 특정 과정에 수강생 전체 조회
    public List<StudentDto> studentGet(){
        System.out.println("TaskService.studentGet");
        List< StudentEntity > studentEntityList = studentRepository.findAll();
        return studentEntityList.stream()
                .map( studentEntity -> studentEntity.toDto() )
                .collect(Collectors.toList() );
    } //f end
    
} // c end
