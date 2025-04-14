package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.model.entity.MemberEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private int mno;
    private String memail;
    private String mpwd;
    private String mname;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno( this.mno )
                .memail( this.memail )
                .mpwd( this.mpwd )
                .mname( this.mname )
                .build();
    }
} // c end
