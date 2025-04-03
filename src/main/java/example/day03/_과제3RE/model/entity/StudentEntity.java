package example.day03._과제3RE.model.entity;

import example.day03._과제3RE.model.dto.StudentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "day03studentRE" )
@Data
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체매개변수생성자
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int sno;
    @Column
    private String sname;

    @ManyToOne
    private CourseEntity courseEntity;

    public StudentDto toDto(){
        return StudentDto.builder()
                .sno( this.sno )
                .sname( this.sname )
                .build();
    }

}
