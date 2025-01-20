package id.my.hendisantika.blogazure;

import id.my.hendisantika.blogazure.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Testcontainers
@SpringBootTest(
        properties = {
                "management.endpoint.health.show-details=always",
                "spring.datasource.url=jdbc:tc:postgresql:17-alpine3.21:///blogs"
        },
        webEnvironment = RANDOM_PORT
)
class SpringBootBlogAzureApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    void deleteAll() {
        authorRepository.deleteAll();
    }

}
