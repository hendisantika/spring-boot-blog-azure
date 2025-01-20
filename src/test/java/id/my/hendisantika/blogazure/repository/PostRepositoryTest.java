package id.my.hendisantika.blogazure.repository;

import id.my.hendisantika.blogazure.model.Author;
import id.my.hendisantika.blogazure.model.Comment;
import id.my.hendisantika.blogazure.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @Test
    void shouldSaveValidPost() {
        Post post = new Post( "TEST", "...",author);
        assertNull(post.getId());
        Post reloaded = posts.save(post);
        assertNotNull(reloaded.getId());
    }

    @Test
    void shouldSaveValidPostWithoutAuthor() {
        Post post = new Post( "TEST", "...",null);
        assertNull(post.getId());
        Post reloaded = posts.save(post);
        assertNotNull(reloaded.getId());
        assertNull(reloaded.getAuthor());
    }

    @Test
    void shouldPostWithComments() {
        Post post = new Post( "TEST", "...",null);
        post.addComments(List.of(new Comment("Yuji","test comment"),new Comment("Gojo","test comment 2")));
        posts.save(post);

        Post p = posts.findById(post.getId()).orElse(null);
        assertNotNull(p);
        assertNotNull(p.getId());
        assertEquals(2,p.getComments().size());
        assertEquals("Dan",p.getComments().iterator().next().getName());
    }
}
