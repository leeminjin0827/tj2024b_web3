package example.day03.과제3.model.entity;

import example.day03.과제3.model.dto.StudentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table( name = "task3Student")
@Data
@Builder
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int sno; // 학생번호[PK]
    @Column
    private String sname; // 학생명
    @Column
    private int cno; // 과정번호[FK]

    public StudentDto toDto(){
        return StudentDto.builder()
                .sno( this.sno )
                .sname( this.sname )
                .cno( this.cno )
                .build();
    } // f end
    
    // 단방향
    @ManyToOne
    private CourseEntity courseEntity;

} // c end
