package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

    // 가입 // { "memail" : "qwe@naver.com" , "mpwd" : "qwe" , "mname" : "유재석" }
    @PostMapping("/signup") // http://localhost:8080/member/signup
    public ResponseEntity<Boolean> MemberWrite(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.MemberWrite");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.MemberWrite( memberDto );
        if( result ){ // * 개발자 마음대로 원하는 응답 코드를 반환 할 수 있다.
            return ResponseEntity.status( 201 ).body( true ); // 201(create ok 뜻) true(반환값)
        }else{
            return ResponseEntity.status( 400 ).body( false ); // 400( bad request 잘못된 요청 뜻 )
        }
    } // f end

    // 로그인 // { "memail" : "qwe@naver.com" , "mpwd" : "qwe" }
    @PostMapping("/login") // http://localhost:8080/member/login
    public ResponseEntity<String> login( @RequestBody MemberDto memberDto ){
        String token = memberService.login( memberDto );
        // 만약에 토큰이 존재하면(로그인성공)
        if( token != null ){ return ResponseEntity.status( 200 ).body( token ); }
        else{ return ResponseEntity.status( 401 ).body( "로그인실패" ); } // 인증 실패 : 401
    } // f end

    // 로그인된 회원 검증 / 내정보 조회
    // @RequestHeader : HTTP 헤더 정보를 매핑 하는 어노테이션 , JWT 정보는 HTTP 헤더 에 담을 수 있다.
    // Authorization : 인증 속성 , { Authorization : token 값 }
    // @RequestParam : HTTP 헤더의 경로 쿼리스트링 매핑 하는 어노테이션
    // @RequestBody : HTTP 본문의 객체를 매핑 하는 어노테이션
    // @PathVariable : HTTP 헤더의 경로 값 매핑하는 어노테이션
    @GetMapping("/info") // http://localhost:8080/member/info
    // headers : { 'Authorization' : 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJxd2VAbmF2ZXIuY29tIiwiaWF0IjoxNzQ0NzcxNTM0LCJleHAiOjE3NDQ4NTc5MzR9.g8sM_lX31AgbILTQMJXGEzX5K2F6Z6ak-mBweZmpM-I'}
    public ResponseEntity<MemberDto> info(@RequestHeader("Authorization") String token ){
        System.out.println( token );
        MemberDto memberDto = memberService.info( token );
        if( memberDto != null ){return ResponseEntity.status( 200 ).body( memberDto ); } //  200 ok
        else { return ResponseEntity.status( 403 ).build(); } // 403 과 NoContent(자료없음)
    } // f end

    // 로그아웃 , 로그아웃 할 토큰 가져오기.
    @GetMapping("/logout") // http://localhost:8080/member/logout
    public ResponseEntity<Void> logout( @RequestHeader("Authorization") String token ){
        memberService.logout( token );
        return ResponseEntity.status( 204 ).build(); // 204 : 성공 했지만 반환할 값이 없다 뜻
    } // f end

    // 실시간 최근 24시간내 로그인 한 접속자 수
    @GetMapping("/login/count")
    public ResponseEntity<Integer> loginCount(){
        int result = memberService.loginCount();
        return ResponseEntity.status( 200 ).body( result ); // 200 : 요청 성공 뜻 과 응답 값 반환
    } // f end

} // c end
