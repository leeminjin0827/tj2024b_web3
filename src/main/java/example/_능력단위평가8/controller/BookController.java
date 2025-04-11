package example._능력단위평가8.controller;

import example._능력단위평가8.model.dto.BookDto;
import example._능력단위평가8.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequiredArgsConstructor
@RequestMapping("/test8/book")
@CrossOrigin("*")
public class BookController {
    private final BookService bookService;

    // 책 등록
    @PostMapping("")
    // [POST] : http://localhost:8080/test8/book
    // { "btitle" : "방망이" , "bname" : "방망이입니다." , "bcontent" : "방망이로사람후리는내용입니다." , "bpassword" : 12344 }
    public boolean bookWrite(@RequestBody BookDto bookDto){
        System.out.println("BookController.bookWrite");
        return bookService.bookWrite( bookDto );
    } // f end
    
    // 책 전체 조회
    @GetMapping("")
    // [GET] : http://localhost:8080/test8/book
    public List<BookDto> bookList(){
        System.out.println("BookController.bookList");
        return bookService.bookList();
    } // f end
    
    // 책 개별 조회
    @GetMapping("/view")
    // [GET] : http://localhost:8080/test8/book/view?bno=#
    public BookDto bookView(@RequestParam("bno") int bno ){
        System.out.println("BookController.bookView");
        System.out.println("bno = " + bno);
        return bookService.bookView( bno );
    } // f end

    // 책 수정
    @PutMapping("")
    // [PUT] : http://localhost:8080/test8/book
    // { "bno" : 1 , "btitle" : "몽둥이" , "bname" : "몽둥이입니다." , "bcontent" : "몽둥이로사람후리는내용입니다." , "bpassword" : 12344 }
    public boolean bookUpdate( @RequestBody BookDto bookDto ){
        System.out.println("BookController.bookUpdate");
        System.out.println("bookDto = " + bookDto);
        return bookService.bookUpdate( bookDto );
    } // f end
    
    // 책 삭제
    @DeleteMapping("")
    // [DELETE] : http://localhost:8080/test8/book?bno=#&bpassword=#
    public boolean bookDelete(@RequestParam("bno") int bno , @RequestParam("bpassword") int bpassword ){
        System.out.println("BookController.bookDelete");
        System.out.println("bno = " + bno + ", bpassword = " + bpassword);
        return bookService.bookDelete( bno , bpassword );
    } // f end


} // c end
