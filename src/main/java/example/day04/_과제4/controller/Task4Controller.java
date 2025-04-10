package example.day04._과제4.controller;

import example.day04._과제4.model.dto.Task4Dto;
import example.day04._과제4.service.Task4Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day04/task4")
public class Task4Controller {

    private final Task4Service task4Service;

    // 비품 등록
    @PostMapping("")
    // [POST] : http://localhost:8080/day04/task4
    // { "name" : "몽둥이" , "description" : "몽둥이입니다." , "quantity" : 100 }
    public boolean task4Write(@RequestBody Task4Dto task4Dto){
        System.out.println("Task4Controller.task4Write");
        System.out.println("task4Dto = " + task4Dto);
        return task4Service.task4Write( task4Dto );
    } // f end

    // 전체 비품 조회
    @GetMapping("")
    // [GET] : http://localhost:8080/day04/task4
    public List<Task4Dto> task4List(){
        System.out.println("Task4Controller.task4List");
        return task4Service.task4List();
    } // f end

    // 개별 비품 조회
    @GetMapping("/view")
    // [GET] : http://localhost:8080/day04/task4/view?tno=#
    public Task4Dto task4View(@RequestParam("tno") int tno){
        System.out.println("Task4Controller.task4View");
        System.out.println("tno = " + tno);
        return task4Service.task4View( tno );
    } // f end

    // 비품 수정
    @PutMapping("")
    // [PUT] : http://localhost:8080/day04/task4
    // { "tno" : 1 , "name" : "방망이" , "description" : "방망이입니다." , "quantity" : 100 }
    public boolean task4Update( @RequestBody Task4Dto task4Dto ){
        System.out.println("Task4Controller.task4Update");
        System.out.println("task4Dto = " + task4Dto);
        return task4Service.Task4Update( task4Dto );
    } // f end

    // 비품 삭제
    @DeleteMapping("")
    public boolean task4Delete(@RequestParam("tno") int tno ){
        System.out.println("Task4Controller.task4Delete");
        System.out.println("tno = " + tno);
        return task4Service.task4Delete( tno );
    } // f end
    
    // 페이징 기능 비품 목록 조회
    @GetMapping("/page")
    public List<Task4Dto> Task4Page(
            @RequestParam( defaultValue = "1" ) int page ,
            @RequestParam( defaultValue = "10") int size ){
        System.out.println("Task4Controller.Task4Page");
        return task4Service.Task4Page(page , size );
    } // f end

} // c end
