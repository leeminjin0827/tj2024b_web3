package web.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;

@Entity
@Table( name = "member" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    private String memail;
    private String mpwd;
    private String mname;

    public MemberDto toDto(){
        return MemberDto.builder()
                .mno( this.mno )
                .memail( this.memail )
                .mname( this.mname )
                .build();
    }
} // c end
