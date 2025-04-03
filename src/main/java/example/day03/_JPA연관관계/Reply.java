package example.day03._JPA연관관계;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data @Builder
@Entity @Table( name = "day03reply" )
public class Reply {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int rno; // 댓글번호
    private String rcontent; // 댓글내용

    // + 단항먕 , 게시물 참조 , FK 필드
    @ManyToOne // FK필드 선언 방법
    private Board board;
} // c end
