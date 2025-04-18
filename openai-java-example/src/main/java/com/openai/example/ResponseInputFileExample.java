package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseInputFile;
import com.openai.models.responses.ResponseInputItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

public final class ResponseInputFileExample {

    private ResponseInputFileExample() {}

    public static void main(String[] args) throws IOException {
        // Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        // Read file content and construct data URI String
        File file = new File("/absolute/path/to/your/file.pdf");
        byte[] fileContent = Files.readAllBytes(file.toPath());
        String base64String = Base64.getEncoder().encodeToString(fileContent);
        String dataUri = "data:application/pdf;base64," + base64String;

        ResponseInputFile inputFile = ResponseInputFile.builder()
                .filename(file.getName())
                .fileData(dataUri)
                .build();

        ResponseInputItem messageInputItem = ResponseInputItem.ofMessage(ResponseInputItem.Message.builder()
                .role(ResponseInputItem.Message.Role.USER)
                .addInputTextContent("Describe this file.")
                .addContent(inputFile)
                .build());

        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .inputOfResponse(List.of(messageInputItem))
                .model(ChatModel.GPT_4O)
                .build();

        client.responses().create(createParams).output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .forEach(outputText -> System.out.println(outputText.text()));
    }

}