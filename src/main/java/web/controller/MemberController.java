package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController // Spring MVC2 controller
@RequestMapping("/member") // 공통 url 정의
@RequiredArgsConstructor // final(상수) 필드의 생성자 자동 생성
@CrossOrigin("*")
// -> 관례적으로 클래스 내부에서 사용하는 모든 필드들을 다른 수정불가능 상태로 사용한다.
public class MemberController {
    // -> 관례적으로 다른곳에 해당하는 필드를 수정 못하도록 final 사용한다.
    // -> 즉 final 사용시 @RequiredArgsConstructor 때문에 @Autowired 안해도 된다.
    private final MemberService memberService;

    // 가입
    @PostMapping("/post")
    public boolean MemberWrite(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.MemberWrite");
        System.out.println("memberDto = " + memberDto);
        return memberService.MemberWrite( memberDto );
    } // f end

} // c end
