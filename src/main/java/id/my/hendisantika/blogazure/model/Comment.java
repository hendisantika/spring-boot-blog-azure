package id.my.hendisantika.blogazure.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

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
public final class Comment {

    @Transient
    Post post;
    private String name;
    private String content;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;

    public Comment(String name, String content) {
        this.name = name;
        this.content = content;
        this.publishedOn = LocalDateTime.now();
    }

    @PersistenceCreator
    @JsonCreator
    public Comment(String name, String content, LocalDateTime publishedOn, LocalDateTime updatedOn) {
        this.name = name;
        this.content = content;
        this.publishedOn = publishedOn;
        this.updatedOn = updatedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDateTime publishedOn) {
        this.publishedOn = publishedOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", publishedOn=" + publishedOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
