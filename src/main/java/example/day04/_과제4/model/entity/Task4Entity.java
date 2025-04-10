package example.day04._과제4.model.entity;

import example.day04._과제4.model.dto.Task4Dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "task4table" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task4Entity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int tno;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int quantity;

    public Task4Dto toDto(){
        return Task4Dto.builder()
                .tno( this.tno )
                .name( this.name )
                .description( this.description )
                .quantity( this.quantity )
                .createAt( this.getCreateAt() )
                .updateAt( this.getUpdateAt() )
                .build();
    }

} // c end
