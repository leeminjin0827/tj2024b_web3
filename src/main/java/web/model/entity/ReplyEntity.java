package web.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long rno; // 댓글 식별 번호
    @Column( nullable = false )
    private String rcontent; // 댓글 내용

    // * 단방향
    @ManyToOne @JoinColumn( name = "pno" )
    private ProductEntity productEntity; // 제품

    @ManyToOne @JoinColumn( name = "mno" )
    private MemberEntity memberEntity; // 작성자

} // c end
