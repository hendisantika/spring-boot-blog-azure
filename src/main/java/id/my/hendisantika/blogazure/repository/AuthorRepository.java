package id.my.hendisantika.blogazure.repository;

import id.my.hendisantika.blogazure.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 12.00
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorRepository extends CrudRepository<Author,Integer> {
    Author findByUsername(String username);
}
