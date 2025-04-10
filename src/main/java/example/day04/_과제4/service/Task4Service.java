package example.day04._과제4.service;

import example.day04._과제4.model.dto.Task4Dto;
import example.day04._과제4.model.entity.Task4Entity;
import example.day04._과제4.model.repository.Task4Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class Task4Service {
    private final Task4Repository task4Repository;

    // 비품 등록
    public boolean task4Write( Task4Dto task4Dto ){
        System.out.println("Task4Service.task4Write");
        System.out.println("task4Dto = " + task4Dto);
        Task4Entity task4Entity = task4Dto.toEntity();
        Task4Entity write = task4Repository.save( task4Entity );
        if (write.getTno() > 0) { return true; }
        else{ return false; }
    } // f end
    
    // 비품 전체 조회
    public List<Task4Dto>task4List(){
        System.out.println("Task4Service.task4List");
        List<Task4Entity> task4EntityList = task4Repository.findAll();
        List<Task4Dto> task4DtoList = task4EntityList.stream()
                .map( entity -> entity.toDto() )
                .collect(Collectors.toList() );
        return task4DtoList;
    } // f end

    // 비품 개별 조회
    public Task4Dto task4View( int tno ){
        System.out.println("Task4Service.task4View");
        System.out.println("tno = " + tno);
        Optional< Task4Entity > optional = task4Repository.findById( tno );
        System.out.println("optional = " + optional);
        System.out.println("optional.get = " + optional.get() );
        if( optional.isPresent() ){
            Task4Entity task4Entity = optional.get();
            Task4Dto task4Dto = task4Entity.toDto();
            return task4Dto;
        } // if end
        return null;
    } // f end
    
    // 비품 수정
    public boolean Task4Update ( Task4Dto task4Dto ){
        System.out.println("Task4Service.Task4Update");
        System.out.println("task4Dto = " + task4Dto);
        Optional< Task4Entity > optional
                = task4Repository.findById( task4Dto.getTno() );
        if( optional.isPresent() ){
            Task4Entity task4Entity = optional.get();
            task4Entity.setName( task4Dto.getName() );
            task4Entity.setDescription( task4Dto.getDescription() );
            task4Entity.setQuantity( task4Dto.getQuantity() );
            return true;
        }
        return false;
    } // f end
    
    // 비품 삭제
    public boolean task4Delete( int tno ) {
        System.out.println("Task4Service.task4Delete");
        System.out.println("tno = " + tno);
        boolean result = task4Repository.existsById( tno );
        if( result == true ){
            task4Repository.deleteById( tno );
            return true;
        }
        return false;
    } // f end
    
    // 비품 목록 페이징 조회
    public List<Task4Dto> Task4Page( int page , int size ){
        System.out.println("Task4Service.Task4Page");
        System.out.println("page = " + page + ", size = " + size);
        PageRequest pageRequest = PageRequest.of( page-1 , size , Sort.by( Sort.Direction.DESC , "tno" ) );
        return task4Repository.findAll( pageRequest ).stream()
                .map( Task4Entity :: toDto )
                .collect( Collectors.toList() );
    } // f end

} // c end
