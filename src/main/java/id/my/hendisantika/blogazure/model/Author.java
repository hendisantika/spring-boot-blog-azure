package id.my.hendisantika.blogazure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 11.58
 * To change this template use File | Settings | File Templates.
 */
public record Author(
        @Id @JsonIgnore Integer id,
        String firstName,
        String lastName,
        String email,
        String username
) {
}
