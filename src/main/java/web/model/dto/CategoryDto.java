package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import web.model.entity.CategoryEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private long cno;
    private String cname;
    
    // * toEntity : 주로 저장 용도

    // * toDto : 주로 호출 용도
    public static CategoryDto toDto(CategoryEntity categoryEntity){
        return CategoryDto.builder()
                .cno( categoryEntity.getCno() )
                .cname( categoryEntity.getCname() )
                .build();
    }
}
