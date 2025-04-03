package example.day03._JPA연관관계;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data @Builder
@Entity
@Table( name = "day03board" )
public class Board {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int bno; // 게시물번호
    private String btitle; // 게시물제목
    private String bcontent; // 게시물내용

    // + 단방향 , 카테고리 참조 , FK필드
    @ManyToOne // fk필드 선언 방법
    private Category category;

    // + 양방향
    @ToString.Exclude // 순환참조 방지
    @Builder.Default // 빌더패턴 사용시 초기값 대입
    @OneToMany( mappedBy = "board" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    private List<Reply> replyList
            = new ArrayList<>();

} // c end
