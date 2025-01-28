package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.*;
import com.openai.models.Thread;

public final class AssistantExample {
    private AssistantExample() {}

    public static void main(String[] args) throws InterruptedException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        Assistant assistant = client.beta()
                .assistants()
                .create(BetaAssistantCreateParams.builder()
                        .name("Math Tutor")
                        .instructions("You are a personal math tutor. Write and run code to answer math questions.")
                        // TODO: Update this example once we support `addCodeInterpreterTool()` or similar.
                        .addTool(CodeInterpreterTool.builder().build())
                        .model(ChatModel.GPT_4O_MINI)
                        .build());
        Thread thread =
                // TODO: Update this example once we support `.create()` without arguments.
                client.beta().threads().create(BetaThreadCreateParams.builder().build());
        client.beta()
                .threads()
                .messages()
                .create(BetaThreadMessageCreateParams.builder()
                        .threadId(thread.id())
                        .role(BetaThreadMessageCreateParams.Role.USER)
                        .content("I need to solve the equation `3x + 11 = 14`. Can you help me?")
                        .build());

        Run run = client.beta()
                .threads()
                .runs()
                .create(BetaThreadRunCreateParams.builder()
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
                    .retrieve(BetaThreadRunRetrieveParams.builder()
                            .threadId(thread.id())
                            .runId(run.id())
                            .build());
        }
        System.out.println("Run completed with status: " + run.status() + "\n");

        if (!run.status().equals(RunStatus.COMPLETED)) {
            return;
        }

        BetaThreadMessageListPage page = client.beta()
                .threads()
                .messages()
                .list(BetaThreadMessageListParams.builder()
                        .threadId(thread.id())
                        .order(BetaThreadMessageListParams.Order.ASC)
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
                .delete(BetaAssistantDeleteParams.builder()
                        .assistantId(assistant.id())
                        .build());
        System.out.println("Assistant deleted: " + assistantDeleted.deleted());
    }
}
