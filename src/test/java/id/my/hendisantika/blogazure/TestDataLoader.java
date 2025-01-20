package id.my.hendisantika.blogazure;

import id.my.hendisantika.blogazure.model.Author;
import id.my.hendisantika.blogazure.model.Comment;
import id.my.hendisantika.blogazure.model.Post;
import id.my.hendisantika.blogazure.repository.AuthorRepository;
import id.my.hendisantika.blogazure.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 12.10
 * To change this template use File | Settings | File Templates.
 */
@Component
@ActiveProfiles("test")
public class TestDataLoader implements CommandLineRunner {

    private final AuthorRepository authors;
    private final PostRepository posts;

    public TestDataLoader(AuthorRepository authors, PostRepository posts) {
        this.authors = authors;
        this.posts = posts;
    }

    @Override
    public void run(String... args) throws Exception {
        AggregateReference<Author,Integer> author = AggregateReference.to(authors.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());
        Post post = new Post("Hello, World!","Welcome to my Spring Blog", author);
        post.addComment(new Comment( "Itadori Yuji", "This is a comment"));
        post.addComment(new Comment( "Ryoumen Sukuna", "This is another comment"));
        posts.save(post);
    }
}
