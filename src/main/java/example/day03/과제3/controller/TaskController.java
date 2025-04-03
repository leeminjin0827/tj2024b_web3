package example.day03.과제3.controller;

import example.day03.과제3.model.dto.CourseDto;
import example.day03.과제3.model.dto.StudentDto;
import example.day03.과제3.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("day03/task1")
public class TaskController {

    private final TaskService taskService;
    
    // 과정 등록
    @PostMapping()
    public boolean coursePost(@RequestBody CourseDto courseDto){
        System.out.println("TaskController.coursePost");
        System.out.println("courseDto = " + courseDto);
        return taskService.coursePost( courseDto );
    } // f end
    
    // 과정 전체 조회
    @GetMapping()
    public List<CourseDto> courseGet(){
        System.out.println("TaskController.courseGet");
        return taskService.courseGet();
    } // f end
    
    // 특정 과정에 수강생 등록
    @PostMapping("/param")
    public boolean studentPost( @RequestBody StudentDto studentDto ){
        System.out.println("TaskController.studentPost");
        System.out.println("studentDto = " + studentDto);
        return taskService.studentPost( studentDto );
    } // f end
    
    // 특정 과정에 수강생 전체 조회
    @GetMapping("/param")
    public List<StudentDto> studentGet(){
        System.out.println("TaskController.studentGet");
        return taskService.studentGet();
    } // f end
    
} // c end
