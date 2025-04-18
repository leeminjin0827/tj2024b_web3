package example._능력단위평가8.service;

import example._능력단위평가8.model.dto.ReviewDto;
import example._능력단위평가8.model.entity.BookEntity;
import example._능력단위평가8.model.entity.ReviewEntity;
import example._능력단위평가8.model.repository.BookRepository;
import example._능력단위평가8.model.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    // 리뷰 등록
    public boolean reviewWrite(ReviewDto reviewDto){
        System.out.println("ReviewService.reviewWrite");
        System.out.println("reviewDto = " + reviewDto);
        ReviewEntity reviewEntity = reviewDto.toEntity();
        ReviewEntity save = reviewRepository.save( reviewEntity );
        System.out.println("[1]save = " + save);
        Optional<BookEntity> optional = bookRepository.findById( reviewDto.getBno() );
        System.out.println("optional = " + optional);
        if( optional.isPresent() ){
            BookEntity bookEntity = optional.get();
            save.setBookEntity( bookEntity );
            System.out.println("save = " + save );
            boolean result = bookRepository.existsById( reviewDto.getBno() );
            if( result ){
                if( save.getRno() > 0 ){ return true; }
            } // if end
        } // if end
        return false;
    } // f end

    // 리뷰 조회
    public List<ReviewDto> reviewList( int bno ){
        System.out.println("ReviewService.reviewList");
        List<ReviewEntity> reviewEntityList = reviewRepository.findAll();
        System.out.println("reviewEntityList = " + reviewEntityList);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for( int i = 0; i < reviewEntityList.size(); i++ ){
            ReviewDto reviewDto = reviewEntityList.get(i).toDto();
            reviewDto.setBno(reviewEntityList.get(i).getBookEntity().getBno());
            System.out.println("reviewDto = " + reviewDto);
            if( reviewDto.getBno() == bno ){
                reviewDtoList.add( reviewDto );
            } // if end
        } // for end
        return reviewDtoList;
    } // f end

    // 리뷰 삭제
    public boolean reviewDelete( int rno , String rpassword ){
        System.out.println("ReviewService.reviewDelete");
        System.out.println("rno = " + rno + ", rpassword = " + rpassword);
        Optional<ReviewEntity> optional = reviewRepository.findById( rno );
        if( optional.isPresent() ){
            if( optional.get().getRpassword() == rpassword ){
                reviewRepository.deleteById( rno );
                return true;
            } // if end
        } // if end
        return false;
    } // f end


} // c end
