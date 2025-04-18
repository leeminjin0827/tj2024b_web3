package example._능력단위평가8.service;

import example._능력단위평가8.model.dto.BookDto;
import example._능력단위평가8.model.entity.BookEntity;
import example._능력단위평가8.model.repository.BookRepository;
import example._능력단위평가8.model.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    // 책 등록
    public boolean bookWrite( BookDto bookDto ){
        System.out.println("BookService.bookWrite");
        System.out.println("bookDto = " + bookDto);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPwd = passwordEncoder.encode( bookDto.getBpassword() );
        bookDto.setBpassword( hashedPwd );
        BookEntity bookEntity = bookDto.toEntity();
        BookEntity save = bookRepository.save( bookEntity );
        if( save.getBno() > 0 ){ return true; }
        return false;
    } // f end

    // 책 전체조회
    public List<BookDto> bookList(){
        System.out.println("BookService.bookList");
        // eneity로 전체 조회
        List<BookEntity> bookEntityList = bookRepository.findAll();
        System.out.println("bookEntityList = " + bookEntityList);
        // List 객체 생성
        List<BookDto> bookDtoList = new ArrayList<>();
        // entity를 순회해서 인덱스로 구분해서 List에 저장
        for( int i = 0; i < bookEntityList.size(); i++ ){
            BookDto bookDto = bookEntityList.get(i).toDto();
            bookDtoList.add( bookDto );
        } // for end
        // 리턴
        return bookDtoList;
    } // f end

    // 책 개별조회
    public BookDto bookView( int bno ){
        System.out.println("BookService.bookView");
        System.out.println("bno = " + bno);
        Optional<BookEntity> bOptional = bookRepository.findById( bno );
        if( bOptional.isPresent() ){
            BookEntity bookEntity = bOptional.get();
            BookDto bookDto = bookEntity.toDto();
            return bookDto;
        } // if end
        return null;
    } // f end

    // 책 수정
    public boolean bookUpdate( BookDto bookDto ){
        System.out.println("BookService.bookUpdate");
        System.out.println("bookDto = " + bookDto);
        Optional< BookEntity > optional =
                bookRepository.findById( bookDto.getBno() );
        if( optional.isPresent() ){
            BookEntity bookEntity = optional.get();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean inMath
                = passwordEncoder.matches( bookDto.getBpassword() , bookEntity.getBpassword() );
            if( inMath == true ) {
                bookEntity.setBtitle(bookDto.getBtitle());
                bookEntity.setBname(bookDto.getBname());
                bookEntity.setBcontent(bookDto.getBcontent());
                return true;
            } // if end
        } // if end
        return false;
    } // f end

    // 책 삭제
    public boolean bookDelete( int bno , String bpassword ){
        System.out.println("BookService.bookDelete");
        System.out.println("bno = " + bno + ", bpassword = " + bpassword);
        Optional< BookEntity > optional
                = bookRepository.findById( bno );
        if( optional.isPresent() ){
            BookEntity bookEntity = optional.get();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean inMath
                    = passwordEncoder.matches( bpassword , bookEntity.getBpassword() );
            if( inMath == true ){
                bookRepository.deleteById( bno );
                return true;
            } // if end
        } // if end
        return false;
    } // f end

} // c end
