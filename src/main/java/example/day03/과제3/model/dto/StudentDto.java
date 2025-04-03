package example.day03.과제3.model.dto;

import example.day03.과제3.model.entity.StudentEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private int sno; // 학생번호(PK)
    private String sname; // 학생명
    private int cno; // 과정번호(FK)

    public StudentEntity tiEntity(){
        return StudentEntity.builder()
                .sno( this.sno )
                .sname( this.sname )
                .cno( this.cno )
                .build();
    } // f end

} // c end
