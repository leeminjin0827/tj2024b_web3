package web.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "img")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long ino; // 이미지 식별번호
    @Column( nullable = false )
    private String iname; // 이미지 명

    // * 단방향
    @ManyToOne @JoinColumn( name = "pno" )
    private ProductEntity productEntity;

} // c end
