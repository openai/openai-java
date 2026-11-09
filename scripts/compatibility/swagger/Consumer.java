import com.fasterxml.jackson.databind.JsonNode;
import com.openai.core.ObjectMappers;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.StructuredResponseTextConfig;
import java.util.Collections;

public class Consumer {
    public static void main(String[] args) throws Exception {
        boolean annotated = !args[0].equals("none");
        int providers = Collections.list(Consumer.class
                        .getClassLoader()
                        .getResources("io/swagger/v3/oas/annotations/media/Schema.class"))
                .size();
        if (providers != (annotated ? 1 : 0)) {
            throw new AssertionError("Unexpected number of Swagger providers: " + providers);
        }
        checkSchemas(Class.forName(annotated ? "Annotated" : "Plain"), annotated);
    }

    private static <T> void checkSchemas(Class<T> model, boolean annotated) {
        Object responseSchema = StructuredResponseTextConfig.<T>builder()
                .format(model)
                .build()
                .rawConfig()
                .format()
                .get()
                .asJsonSchema()
                ._schema()
                .asObject()
                .get();
        Object toolSchema = ResponseCreateParams.builder()
                .addTool(model)
                .build()
                .tools()
                .get()
                .get(0)
                .asFunction()
                ._parameters()
                .asObject()
                .get();
        for (Object schema : new Object[] {responseSchema, toolSchema}) {
            JsonNode root = ObjectMappers.jsonMapper().valueToTree(schema);
            JsonNode properties = root.path("properties");
            JsonNode code = properties.path("country_code");
            if (!root.path("additionalProperties").isBoolean()
                    || root.path("additionalProperties").booleanValue()
                    || !"string".equals(code.path("type").textValue())
                    || properties.size() != (annotated ? 2 : 1)
                    || (annotated
                            && (!"[A-Z]{2}".equals(code.path("pattern").textValue())
                                    || properties
                                                    .path("aliases")
                                                    .path("minItems")
                                                    .intValue()
                                            != 2))) {
                throw new AssertionError("Unexpected schema: " + root);
            }
        }
    }
}
