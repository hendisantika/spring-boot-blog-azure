package id.my.hendisantika.blogazure.controller;

import id.my.hendisantika.blogazure.dto.PostDetails;
import id.my.hendisantika.blogazure.model.Post;
import id.my.hendisantika.blogazure.repository.AuthorRepository;
import id.my.hendisantika.blogazure.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 12.02
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository posts;
    private final AuthorRepository authors;

    @GetMapping
    public Iterable<Post> findAll() {
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Post post) {
        return post;
    }

    @GetMapping("/{id}/details")
    public PostDetails getPostDetails(@PathVariable("id") Post post) {
        log.info("Post Details called for: {}", post.getId());
        return new PostDetails(post,authors.findById(post.getAuthor().getId()).get());
    }
}
