package example._능력단위평가8.model.dto;

import example._능력단위평가8.model.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    // 식별번호
    private int rno;
    // 리뷰내용
    private String rcontent;
    // 삭제 할 때 사용하는 비밀번호
    private int rpassword;
    // 등록날짜
    private LocalDateTime createAt;
    // 책 식별번호
    private int bno;

    public ReviewEntity toEntity(){
        return ReviewEntity.builder()
                .rno( this.rno )
                .rcontent( this.rcontent )
                .rpassword( this.rpassword )
                .build();
    }

} // c end
