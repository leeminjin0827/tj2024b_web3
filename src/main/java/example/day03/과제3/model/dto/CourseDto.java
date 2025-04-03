package example.day03.과제3.model.dto;

import example.day03.과제3.model.entity.CourseEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {
    private int cno; // 과정번호(PK)
    private String cname; // 과정명

    public CourseEntity toEntity(){
//        return CourseEntity.builder()
//                .cno( this.cno )
//                .cname( this.cname )
//                .build();
    CourseEntity courseEntity = new CourseEntity();
    courseEntity.setCname( this.cname );
    return courseEntity;

    } // f end
} // c end
