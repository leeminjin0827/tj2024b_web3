package example.day03._과제3RE.model.entity;

import example.day03._과제3RE.model.dto.CourseDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity @Table( name = "day03courseRE" )
@Data
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체매개변수생성자
@Builder
public class CourseEntity {
    
    @Id // pk
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int cno; // 과정번호
    @Column
    private String cname; // 과정명

    // 양방향
    @ToString.Exclude // 순환 방지
    @Builder.Default // 해당 엔티티를 빌더패턴 생성할경우 초기값 사용
    @OneToMany(mappedBy = "courseEntity" , cascade = CascadeType.ALL )
    private List<StudentEntity> studentEntityList = new ArrayList<>();

    // toDto
    public CourseDto toDto(){
        return CourseDto.builder()
                .cno( this.cno )
                .cname( this.cname )
                .build();
    }
}
