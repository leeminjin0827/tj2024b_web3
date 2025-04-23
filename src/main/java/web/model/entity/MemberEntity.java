package web.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import web.model.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "member" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    private String memail;
    private String mpwd;
    private String mname;
    
    // * 양방향 : FK 엔티티를 여러개 가지므로 List 타입으로 만든다.
    @OneToMany( mappedBy = "memberEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @ToString.Exclude // 양방향 설계시 toString 롬복의 순환참조 방지
    @Builder.Default // 엔티티 객체 생성시 빌더메소드 사용하면 기본값
    private List<ProductEntity> productEntityList = new ArrayList<>();

    // @OneToMany( mappedBy = "FK엔티티자바필드명" )
    @OneToMany( mappedBy = "memberEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @ToString.Exclude @Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();


    public MemberDto toDto(){
        return MemberDto.builder()
                .mno( this.mno )
                .memail( this.memail )
                .mname( this.mname )
                .build();
    }
    
} // c end
