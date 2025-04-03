package example.day03._과제3RE.model.dto;

import example.day03._과제3RE.model.entity.StudentEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private int sno;
    private String sname;
    // + 학생 등록시 측정한 과정의 pk번호
    private int cno;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
                .sno( this.sno )
                .sname( this.sname )
                .build();
    }
}
