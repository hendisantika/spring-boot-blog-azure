package id.my.hendisantika.blogazure.dto;

import id.my.hendisantika.blogazure.model.Author;
import id.my.hendisantika.blogazure.model.Post;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-blog-azure
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/01/25
 * Time: 11.59
 * To change this template use File | Settings | File Templates.
 */
public record PostDetails(Post post, Author author) { }
