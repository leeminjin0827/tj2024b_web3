package example._능력단위평가8.controller;

import example._능력단위평가8.model.dto.ReviewDto;
import example._능력단위평가8.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test8/review")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReviewController {
    private final ReviewService reviewService;
    
    // 리뷰 등록
    @PostMapping("")
    // [POST] : http://localhost:8080/test8/review
    // { "bno" : 1 , "rcontent" : "책찢고싶다" , "rpassword" : 1234 }
    public boolean reviewWrite(@RequestBody ReviewDto reviewDto){
        System.out.println("ReviewController.reviewWrite");
        System.out.println("reviewDto = " + reviewDto);
        return reviewService.reviewWrite( reviewDto );
    } // f end

    // 리뷰 조회
    @GetMapping("")
    // [GET] : http://localhost:8080/test8/review
    public List<ReviewDto> reviewList( @RequestParam("bno") int bno ){
        System.out.println("ReviewController.reviewList");
        return reviewService.reviewList( bno );
    } // f end
    
    // 리뷰 삭제
    @DeleteMapping("")
    // [DELETE] : http://localhost:8080/test8/review?rno=#&rpassword=#
    public boolean reviewDelete( @RequestParam("rno") int rno, @RequestParam("rpassword") String rpassword ){
        System.out.println("ReviewController.reviewDelete");
        System.out.println("rno = " + rno + ", rpassword = " + rpassword);
        return reviewService.reviewDelete( rno , rpassword );
    } // f end

} // c end
