package id.my.hendisantika.blogazure.json;

import id.my.hendisantika.blogazure.model.Author;
import org.springframework.boot.jackson.JacksonComponent;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

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
@JacksonComponent
public class AuthorDeserializer extends ValueDeserializer<AggregateReference<Author,Integer>> {

    @Override
    public AggregateReference<Author, Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonNode jsonNode = deserializationContext.readTree(jsonParser);
        return AggregateReference.to(jsonNode.get("id").asInt());
    }
}
