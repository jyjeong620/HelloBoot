package jeongjy.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("jeongjy")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("jeongjy")).isEqualTo(0);

        helloRepository.increaseCount("jeongjy");
        assertThat(helloRepository.countOf("jeongjy")).isEqualTo(1);

        helloRepository.increaseCount("jeongjy");
        assertThat(helloRepository.countOf("jeongjy")).isEqualTo(2);
    }
}
