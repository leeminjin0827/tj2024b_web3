package web.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pno; // 제품 식별번호
    @Column( nullable = false )
    private String pname; // 제품명
    @Column( columnDefinition = "longtext" ) // mysql 네이티브 타입
    private String pcontent; // 제품설명

    @Column( nullable = false )
    @ColumnDefault("0") // default 0
    private int pprice; // 제품가격

    @Column( nullable = false )
    @ColumnDefault("0") // default 0
    private int pview; // 조회수
    
    // * 단방향 : 참조할 PK필드가 존재하는 엔티티 필드 생성 , 자바에서는 엔티티 이지만 db에서는 mno 표현
    @ManyToOne @JoinColumn( name = "mno" ) // fk 필드명 정의
    private MemberEntity memberEntity;
    
    @ManyToOne @JoinColumn( name = "cno" ) // fk 필드명 정의
    private CategoryEntity categoryEntity;

    // * 양방향
    @OneToMany( mappedBy = "productEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @ToString.Exclude @Builder.Default
    private List<ImgEntity> imgEntityList = new ArrayList<>();

    @OneToMany( mappedBy = "productEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude @Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();

    
} // c end
