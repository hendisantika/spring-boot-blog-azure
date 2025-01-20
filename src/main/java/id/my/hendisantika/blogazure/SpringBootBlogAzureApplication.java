package id.my.hendisantika.blogazure;

import id.my.hendisantika.blogazure.model.Author;
import id.my.hendisantika.blogazure.model.Comment;
import id.my.hendisantika.blogazure.model.Post;
import id.my.hendisantika.blogazure.repository.AuthorRepository;
import id.my.hendisantika.blogazure.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class SpringBootBlogAzureApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBlogAzureApplication.class, args);
    }

    @Profile({"dev","prod"})
    @Bean
    CommandLineRunner run(PostRepository postRepository, AuthorRepository authorRepository) {
        return args -> {
            AggregateReference<Author,Integer> author = AggregateReference.to(authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());

            Post post = new Post( "Yuji's First Post", "This is Yuji's First Post",author);
            post.addComment(new Comment( "Itadori Yuji", "This is a comment"));
            post.addComment(new Comment( "Ryoumen Sukuna", "This is another comment"));
            postRepository.save(post);
        };
    }
}
