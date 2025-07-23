package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionContentPart;
import com.openai.models.chat.completions.ChatCompletionContentPartText;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class CompletionsFileExample {
    private CompletionsFileExample() {}

    public static void main(String[] args) throws URISyntaxException, InterruptedException, IOException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path pdfPath = Paths.get(classloader.getResource("pdflatex-image.pdf").toURI());

        FileObject logoFileObject = client.files()
                .create(FileCreateParams.builder()
                        .file(pdfPath)
                        .purpose(FilePurpose.USER_DATA)
                        .build());

        ChatCompletionContentPart.File logoFile = ChatCompletionContentPart.File.builder()
                .file(ChatCompletionContentPart.File.FileObject.builder()
                        .fileId(logoFileObject.id())
                        .build())
                .build();
        ChatCompletionContentPart logoContentPart = ChatCompletionContentPart.ofFile(logoFile);

        ChatCompletionContentPart questionContentPart =
                ChatCompletionContentPart.ofText(ChatCompletionContentPartText.builder()
                        .text("Describe this image.")
                        .build());
        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4O_MINI)
                .maxCompletionTokens(2048)
                .addUserMessageOfArrayOfContentParts(List.of(questionContentPart, logoContentPart))
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }
}
