package web.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.entity.MemberEntity;
import web.model.repository.MemberRepository;

@Service // Spring MVC2 service
@RequiredArgsConstructor // final 필드의 생성자 자동 생성
@Transactional // 트랜잭션 : 여러개의 SQL 명령어 를 하나의 논리 단위 묶음
// 트랙잭션은 성공 또는 실패 , 부분 성공은 없다.
// 메소드 안에서 여러가지 SQL 실행할 경우 하나라도 오류가 발생하면 롤백(취소) * JPA 엔티티 수정 필수!
public class MemberService {
    private final MemberRepository memberRepository;

    // 가입
    public boolean MemberWrite(MemberDto memberDto ){
        System.out.println("MemberService.MemberWrite");
        System.out.println("memberDto = " + memberDto);
        // 1. 암호화
        // 암호화 비크립트 객체 생성
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 암호화 지원하는 함수 .encode( 암호화할데이터);
        String hashedPwd = passwordEncoder.encode( memberDto.getMpwd() );
        memberDto.setMpwd( hashedPwd );
        // 2. DTO 를 entity 변환하기
        MemberEntity memberEntity = memberDto.toEntity();
        // 3. 리포지토리 이용한 entity 영속화하기
        MemberEntity saveEntity = memberRepository.save( memberEntity );
        // 4. 영속된 엔티티의 (자동생성된) pk 확인
        if( saveEntity.getMno() >= 1 ){ return true; }
        return false;
    } // f end
} // c end
