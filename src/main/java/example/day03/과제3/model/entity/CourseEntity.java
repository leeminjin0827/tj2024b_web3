package example.day03.과제3.model.entity;

import example.day02._BaseTime.BaseTime;
import example.day03.과제3.model.dto.CourseDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "task3Course" )
@Data
@NoArgsConstructor
// @Builder
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int cno; // 과정번호[PK]
    @Column
    private String cname; // 과정명

    public CourseDto toDto(){
        return CourseDto.builder()
                .cno( this.cno )
                .cname( this.cname )
                .build();
    } // f end
    
    // 양방향
    @ToString.Exclude
    //@Builder.Default // 해당 엔티티를 빌더 패턴으로 생성할 경우 초기값 사용
    @OneToMany( mappedBy = "courseEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    private List<StudentEntity> studentList = new ArrayList<>();

} // c end
