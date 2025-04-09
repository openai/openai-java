package com.openai.example;

import static java.util.stream.Collectors.toList;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.EasyInputMessage;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseInputItem;
import com.openai.models.responses.ResponseOutputMessage;
import java.util.ArrayList;
import java.util.List;

public final class ResponsesConversationExample {
    private ResponsesConversationExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        List<ResponseInputItem> inputItems = new ArrayList<>();
        inputItems.add(ResponseInputItem.ofEasyInputMessage(EasyInputMessage.builder()
                .role(EasyInputMessage.Role.USER)
                .content("Tell me a story about building the best SDK!")
                .build()));

        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .inputOfResponse(inputItems)
                .model(ChatModel.GPT_4O)
                .build();

        for (int i = 0; i < 4; i++) {
            List<ResponseOutputMessage> messages = client.responses().create(createParams).output().stream()
                    .flatMap(item -> item.message().stream())
                    .collect(toList());

            messages.stream()
                    .flatMap(message -> message.content().stream())
                    .flatMap(content -> content.outputText().stream())
                    .forEach(outputText -> System.out.println(outputText.text()));

            System.out.println("\n-----------------------------------\n");

            messages.forEach(message -> inputItems.add(ResponseInputItem.ofResponseOutputMessage(message)));
            inputItems.add(ResponseInputItem.ofEasyInputMessage(EasyInputMessage.builder()
                    .role(EasyInputMessage.Role.USER)
                    .content("But why?" + "?".repeat(i))
                    .build()));
            createParams = createParams.toBuilder().inputOfResponse(inputItems).build();
        }
    }
}
