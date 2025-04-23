package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import web.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

@ToString @Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProductDto {

    // * 제품 등록할때 필요한 필드
    private String pname;       // - 제품명
    private String pcontent;    // - 제품설명
    private int pprice;         // - 제품가격
    private List<MultipartFile> files = new ArrayList<>(); // - 업로드할 제품이미지들
    private long cno; // 제품카테고리 번호
    
    // * toEntity : 제품 등록시 사용
    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .pname( this.pname )
                .pcontent( this.pcontent )
                .pprice( this.pprice )
                // cno 대신 CategoryEntity 넣기
                // mno 대신 MemberEntity 넣기
                .build();
    } // f end

    // * toDto : 제품전체조회 , 제품개별 조회 사용
    public static ProductDto toDto( ProductEntity productEntity ){
        return ProductDto.builder()
                .pname( productEntity.getPname() )
                .pcontent( productEntity.getPcontent() )
                .pprice( productEntity.getPprice() )
                .build();

    } // f end

} // c end
