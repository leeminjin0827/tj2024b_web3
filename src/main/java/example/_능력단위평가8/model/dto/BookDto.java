package example._능력단위평가8.model.dto;

import example._능력단위평가8.model.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    // 고유번호
    private int bno;
    // 책 제목
    private String btitle;
    // 책 저자
    private String bname;
    // 책 소개
    private String bcontent;
    // 수정,삭제 를 위한 비밀번호
    private String bpassword;
    // 등록날짜
    private LocalDateTime createAt;
    // 수정날짜
    private LocalDateTime updateAt;

    public BookEntity toEntity(){
        return BookEntity.builder()
                .bno( this.bno )
                .btitle( this.btitle )
                .bname( this.bname )
                .bcontent( this.bcontent )
                .bpassword( this.bpassword )
                .build();
    }

} // c end
