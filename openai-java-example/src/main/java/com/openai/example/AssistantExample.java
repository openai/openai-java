package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.beta.assistants.*;
import com.openai.models.beta.threads.Thread;
import com.openai.models.beta.threads.messages.MessageCreateParams;
import com.openai.models.beta.threads.messages.MessageListPage;
import com.openai.models.beta.threads.messages.MessageListParams;
import com.openai.models.beta.threads.runs.Run;
import com.openai.models.beta.threads.runs.RunCreateParams;
import com.openai.models.beta.threads.runs.RunRetrieveParams;
import com.openai.models.beta.threads.runs.RunStatus;

public final class AssistantExample {
    private AssistantExample() {}

    public static void main(String[] args) throws Exception {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        Assistant assistant = client.beta()
                .assistants()
                .create(AssistantCreateParams.builder()
                        .name("Math Tutor")
                        .instructions("You are a personal math tutor. Write and run code to answer math questions.")
                        // TODO: Update this example once we support `addCodeInterpreterTool()` or similar.
                        .addTool(CodeInterpreterTool.builder().build())
                        .model(ChatModel.GPT_4O_MINI)
                        .build());
        Thread thread = client.beta().threads().create();
        client.beta()
                .threads()
                .messages()
                .create(MessageCreateParams.builder()
                        .threadId(thread.id())
                        .role(MessageCreateParams.Role.USER)
                        .content("I need to solve the equation `3x + 11 = 14`. Can you help me?")
                        .build());

        Run run = client.beta()
                .threads()
                .runs()
                .create(RunCreateParams.builder()
                        .threadId(thread.id())
                        .assistantId(assistant.id())
                        .instructions("Please address the user as Jane Doe. The user has a premium account.")
                        .build());
        while (run.status().equals(RunStatus.QUEUED) || run.status().equals(RunStatus.IN_PROGRESS)) {
            System.out.println("Polling run...");
            java.lang.Thread.sleep(500);
            run = client.beta()
                    .threads()
                    .runs()
                    .retrieve(RunRetrieveParams.builder()
                            .threadId(thread.id())
                            .runId(run.id())
                            .build());
        }
        System.out.println("Run completed with status: " + run.status() + "\n");

        if (!run.status().equals(RunStatus.COMPLETED)) {
            return;
        }

        MessageListPage page = client.beta()
                .threads()
                .messages()
                .list(MessageListParams.builder()
                        .threadId(thread.id())
                        .order(MessageListParams.Order.ASC)
                        .build());
        page.autoPager().stream().forEach(currentMessage -> {
            System.out.println(currentMessage.role().toString().toUpperCase());
            currentMessage.content().stream()
                    .flatMap(content -> content.text().stream())
                    .forEach(textBlock -> System.out.println(textBlock.text().value()));
            System.out.println();
        });

        AssistantDeleted assistantDeleted = client.beta()
                .assistants()
                .delete(AssistantDeleteParams.builder()
                        .assistantId(assistant.id())
                        .build());
        System.out.println("Assistant deleted: " + assistantDeleted.deleted());
    }
}
