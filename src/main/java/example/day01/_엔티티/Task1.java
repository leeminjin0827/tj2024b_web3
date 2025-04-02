package example.day01._엔티티;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Task1 {
    @Id // 식별키
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column( nullable = false , length = 100 ) // not null , varchar(100)
    private String title;

    @Column( nullable = false )
    private boolean state;

    @Column( nullable = false )
    private LocalDate createat;

    @Column( nullable = false )
    private LocalDateTime updateat;
} // c end
