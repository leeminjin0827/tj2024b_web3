package example.day04._과제4.model.dto;

import example.day04._과제4.model.entity.Task4Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task4Dto {
    
    // 비품번호
    private int tno;
    // 비품명
    private String name;
    // 비품 설명
    private String description;
    // 수량
    private int quantity;
    // 등록시간
    private LocalDateTime createAt;
    // 수정시간
    private LocalDateTime updateAt;

    public Task4Entity toEntity(){
        return Task4Entity.builder()
                .tno( this.tno )
                .name( this.name )
                .description( this.description )
                .quantity( this.quantity )
                .build();
    }
    
} // c end
