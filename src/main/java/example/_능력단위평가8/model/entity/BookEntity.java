package example._능력단위평가8.model.entity;

import example._능력단위평가8.model.dto.BookDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test8book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno; // 고유번호
    @Column( nullable = false )
    private String btitle; // 책 제목
    @Column( nullable = false )
    private String bname; // 책 저자
    @Column( nullable = false )
    private String bcontent; // 책 소개
    @Column( nullable = false )
    private int bpassword; // 수정,삭제 를 위한 비밀번호

    public BookDto toDto(){
        return BookDto.builder()
                .bno( this.bno )
                .btitle( this.btitle )
                .bname( this.bname )
                .bcontent( this.bcontent )
                .bpassword( this.bpassword )
                .createAt( this.getCreateAt() )
                .updateAt( this.getUpdateAt() )
                .build();
    }

} // c end
