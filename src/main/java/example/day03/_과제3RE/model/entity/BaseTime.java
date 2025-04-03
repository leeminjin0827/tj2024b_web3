package example.day03._과제3RE.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class)
@Getter
public class BaseTime {

    // 생성날짜
    @CreatedDate // 엔티티의 생성 날짜/시간 주입
    private LocalDateTime postTime;
    // 수정날짜
    @LastModifiedDate // 엔티티의 수정 날짜/시간 주입
    private LocalDateTime putTime;
}
