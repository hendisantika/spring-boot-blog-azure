package id.my.hendisantika.blogazure.repository;

import id.my.hendisantika.blogazure.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 12.12
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
@ActiveProfiles("test")
class PostRepositoryTest {

    @Autowired
    PostRepository posts;

    @Autowired
    AuthorRepository authors;

    AggregateReference<Author,Integer> author;

    @BeforeEach
    void setUp() {
        author = AggregateReference.to(authors.save(new Author(null, "Megumi", "Fushiguro", "megumi@yopmail.com", "megumi")).id());
    }
}
