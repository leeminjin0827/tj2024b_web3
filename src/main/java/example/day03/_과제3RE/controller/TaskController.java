package example.day03._과제3RE.controller;

import example.day03._과제3RE.model.dto.CourseDto;
import example.day03._과제3RE.model.dto.StudentDto;
import example.day03._과제3RE.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day03/taskRE")
public class TaskController {
    private final TaskService taskService;
    // 1. 과정 등록
    @PostMapping("/course")
    // http://localhost:8080/day03/taskRE/course
    // { "cname" : "수학" }
    public boolean saveCourse(@RequestBody CourseDto courseDto ){
        System.out.println("TaskController.saveCourse");
        System.out.println("courseDto = " + courseDto);
        return taskService.saveCourse( courseDto );
    }
    // 2. 과정 전체조회
    @GetMapping("/course")
    // http://localhost:8080/day03/taskRE/course
    public List<CourseDto> findAllCourse(){
        System.out.println("TaskController.findAll");
        return taskService.findAllCourse();
    }

    // 3. 특정한 과정에 학생 등록
    @PostMapping("/student")
    public boolean saveStudent(@RequestBody StudentDto studentDto ){
        return taskService.saveStudent( studentDto );
    }

    // 4. 특정한 과정에 학생 전체조회
    @GetMapping("/student")
    public List<StudentDto> findAllStudent(@RequestParam int cno ){
        return taskService.findAllStudent( cno );
    }



}
