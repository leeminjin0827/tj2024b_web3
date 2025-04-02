package example.day02._BaseTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEntityReposiroty
    extends JpaRepository< BookEntity , Integer > {
    // JpaRepository 클래스로부터 상속받아서 (*)CRUD 제공 받는다.
}
