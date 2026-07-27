package com.openai.compatibility;

import com.openai.core.JsonValue;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams;
import java.util.Collections;
import java.util.Map;

public final class CoreRuntimeProbe {
    private CoreRuntimeProbe() {}

    public static void main(String[] args) {
        Map<String, String> input = Collections.singletonMap("probe", "runtime");
        Map<?, ?> converted = JsonValue.from(input).convert(Map.class);

        if (converted == null || !"runtime".equals(converted.get("probe"))) {
            throw new IllegalStateException("Core JSON round trip failed");
        }

        StructuredChatCompletionCreateParams<RuntimeResponse> params = ChatCompletionCreateParams.builder()
                .addUserMessage("runtime probe")
                .model("runtime-probe")
                .responseFormat(RuntimeResponse.class)
                .build();
        if (!params.rawParams().responseFormat().isPresent()) {
            throw new IllegalStateException("Core structured-output schema generation failed");
        }

        System.out.printf("Exercised openai-java-core on Java %s.%n", System.getProperty("java.version"));
    }

    public static final class RuntimeResponse {
        public String value;
    }
}
