package id.my.hendisantika.blogazure.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import id.my.hendisantika.blogazure.model.Author;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.io.IOException;

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
@JsonComponent
public class AuthorDeserializer extends JsonDeserializer<AggregateReference<Author,Integer>> {

    @Override
    public AggregateReference<Author, Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        return AggregateReference.to(Integer.parseInt( treeNode.get("id").toString() ));
    }
}
