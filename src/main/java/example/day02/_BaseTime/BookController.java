package example.day02._BaseTime;

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
@RequestMapping("/day02/book")
@RequiredArgsConstructor
public class BookController {
    // 1. 매핑 테스트 // 2. 매개변수 테스트 // 3. 리턴 테스트 // 4. 서비스 연동 테스트
    private final BookService bookService;

    // 1. 등록
    // [POST] : { "도서명" : "라라라" , "저자" : "아아아" , "출판사" : "아아아" , "출판연도" : 2000 }
    @PostMapping
    public boolean post(@RequestBody BookEntity bookEntity ){
        System.out.println("BookController.post");
        System.out.println("bookEntity = " + bookEntity);
        return bookService.post( bookEntity );
    } // f end

    // 2. 전체조회
    // [GET] : http://localhost:8080/day02/book
    @GetMapping
    public List<BookEntity> get() {
        System.out.println("BookController.get");
        return bookService.get();
    } // f end

    // 3. 수정
    // [PUT] : { "도서번호" : 2 , "도서명" : "라라라" , "저자" : "아아아" , "출판사" : "아아아" , "출판연도" : 2000 }
    @PutMapping
    public boolean put( @RequestBody BookEntity bookEntity ){
        System.out.println("BookController.put");
        System.out.println("bookEntity = " + bookEntity);
        return bookService.put( bookEntity );
    } // f end

    // 4. 삭제
    // [DELETE] : http://localhost:8080/day02/book?도서번호:#
    @DeleteMapping
    public boolean delete(@RequestParam int 도서번호 ){
        System.out.println("BookController.delete");
        System.out.println("도서번호 = " + 도서번호);
        return bookService.delete( 도서번호 );
    } //f end
} // c end
