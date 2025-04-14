package web.model.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.entity.MemberEntity;

@Repository // Spring MVC2 repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
    // 상속 하므로써 JPA 기본적인 CRUD 제공
} // i end
