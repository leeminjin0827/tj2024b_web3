package example.day02._영속성;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA 영속성 감지 기능 활성화
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class );
    } // f end
} // c end
