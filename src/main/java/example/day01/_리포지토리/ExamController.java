package example.day01._리포지토리;

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
@RequestMapping("day01/jpa")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;
    
    // 1. C : 등록
    @PostMapping
    public boolean post(@RequestBody ExamEntity examEntity ){
        // (영속 전 / 매핑 전) examEntity
        System.out.println("ExamController.post");
        System.out.println("examEntity = " + examEntity);
        return examService.post( examEntity );
    } // f end
    
    // 2. R : 전체 조회
    @GetMapping
    public List< ExamEntity > get (){
        System.out.println("ExamController.get");
        // (영속 전 / 매핑 전) examEntity
        return examService.get();
    } // f end
    
    // 3. U : 수정
    @PutMapping
    public boolean put( @RequestBody ExamEntity examEntity ){
        System.out.println("ExamController.put");
        System.out.println("examEntity = " + examEntity);
        return examService.put2( examEntity );
    } // f end
    
    // 4. D : 삭제
    @DeleteMapping
    public boolean delete(@RequestParam String id ){
        System.out.println("ExamController.delete");
        System.out.println("id = " + id);
        return examService.delete( id );
    } // f end

} // c end
