package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseInputFile;
import com.openai.models.responses.ResponseInputItem;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public final class ResponsesInputFileExample {

    private ResponsesInputFileExample() {}

    public static void main(String[] args) throws IOException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String filename = "pdflatex-image.pdf";
        byte[] pdfBytes = classloader.getResource(filename).openStream().readAllBytes();
        String pdfBase64Url =
                "data:application/pdf;base64," + Base64.getEncoder().encodeToString(pdfBytes);

        ResponseInputFile inputFile = ResponseInputFile.builder()
                .filename(filename)
                .fileData(pdfBase64Url)
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
