import com.openai.core.ObjectMappers;
import com.openai.models.chat.completions.ChatCompletionContentPart;
import tools.jackson.databind.json.JsonMapper;

public class Jackson3Application {
    public static void main(String[] args) throws Exception {
        JsonMapper application = JsonMapper.builder().build();
        if (!application.version().toString().equals(args[0])) {
            throw new AssertionError("Unexpected application mapper: " + application.version());
        }
        byte[] payload = application.writeValueAsBytes(
                application.createObjectNode().put("type", "text").put("text", "probe"));
        ChatCompletionContentPart part = ObjectMappers.jsonMapper().readValue(payload, ChatCompletionContentPart.class);
        byte[] encoded = ObjectMappers.jsonMapper().writeValueAsBytes(part);
        if (!part.asText().textOrThrow().equals("probe")
                || !application
                        .readTree(encoded)
                        .path("text")
                        .asString()
                        .equals(part.asText().textOrThrow())) {
            throw new AssertionError("SDK model did not round trip through JSON");
        }
    }
}
