package example._능력단위평가8.model.entity;

import example._능력단위평가8.model.dto.ReviewDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test8review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewEntity extends BaseTime{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno; // 식별번호
    @Column( nullable = false )
    private String rcontent; // 리뷰 내용
    @Column( nullable = false )
    private String rpassword; // 삭제할 때 필요한 비밀번호
    @ManyToOne
    private BookEntity bookEntity;

    public ReviewDto toDto(){
        return ReviewDto.builder()
                .rno( this.rno )
                .rcontent( this.rcontent )
                .rpassword( this.rpassword )
                .createAt( this.getCreateAt() )
                .build();
    }
    
} // c end



