package id.my.hendisantika.blogazure.controller;

import id.my.hendisantika.blogazure.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 12.14
 * To change this template use File | Settings | File Templates.
 */
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldFindAllPosts() {
        ResponseEntity<List<Post>> exchange = restTemplate.exchange("/api/posts", HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {});
        assertNotNull(exchange);
        List<Post> posts = exchange.getBody();
        assertEquals(1,posts.size());
        assertEquals( 1,posts.get(0).getAuthor().getId());
        assertEquals(2,posts.get(0).getComments().size());
    }

    @Test
    void shouldFindOneValidPost() {
        ResponseEntity<Post> entity = restTemplate.getForEntity("/api/posts/1", Post.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        Post post = entity.getBody();
        assertEquals("Hello, World!",post.getTitle());
    }

}
