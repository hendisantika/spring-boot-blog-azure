package id.my.hendisantika.blogazure.repository;

import id.my.hendisantika.blogazure.model.Post;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 12.01
 * To change this template use File | Settings | File Templates.
 */
public interface PostRepository extends CrudRepository<Post,Integer> {

    @Query("SELECT * FROM POST WHERE author = :id")
    List<Post> findByAuthor(Integer id);
}
