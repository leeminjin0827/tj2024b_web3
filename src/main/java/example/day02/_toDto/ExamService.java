package example.day02._toDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ExamService {

    private final ExamEntity1Repository examEntity1Repository;
    
    // dto --> entity 변환
    public boolean post( ExamDto examDto ){
        // 1. DTO를 영속성(자바개체<-->DB 매핑 상태) 을 부여 할수 없고 DTO를 ENTITY 변환하기.
        // * 비영속성
        ExamEntity1 examEntity1 = examDto.toEntity();
        // * 영속성
        examEntity1Repository.save( examEntity1 );
        return true;
    } // f end
    // entity --> dto 변환
    public List< ExamDto > get(){
        // 1. 모든 영속된/레코드 조회한다.
        List< ExamEntity1 > entityList =
        examEntity1Repository.findAll();
        // 2. (스트림방법) 모든 영속된 엔티티 대신에 DTO를 반환한다. 스트림
        return entityList.stream() // 스트림 생성
                .map( entity -> entity.toDto() ) // map
                .collect( Collectors.toList() ); // 결과
        // 2. (일반방법) 심플
//        List< ExamDto > examDtos = new ArrayList<>();
//        for( int i = 0; i < entityList.size() -1; i++ ){
//            ExamEntity1 entity1 = entityList.get(i);
//            ExamDto examDto = entity1.toDto();
//            examDtos.add( examDto );
//        }
//        return examDtos;
    } // f end
} // c end
