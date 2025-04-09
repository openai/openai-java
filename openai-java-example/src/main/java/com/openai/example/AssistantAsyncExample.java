package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.ChatModel;
import com.openai.models.beta.assistants.Assistant;
import com.openai.models.beta.assistants.AssistantCreateParams;
import com.openai.models.beta.assistants.AssistantDeleteParams;
import com.openai.models.beta.assistants.CodeInterpreterTool;
import com.openai.models.beta.threads.messages.Message;
import com.openai.models.beta.threads.messages.MessageCreateParams;
import com.openai.models.beta.threads.messages.MessageListPageAsync;
import com.openai.models.beta.threads.messages.MessageListParams;
import com.openai.models.beta.threads.runs.Run;
import com.openai.models.beta.threads.runs.RunCreateParams;
import com.openai.models.beta.threads.runs.RunRetrieveParams;
import com.openai.models.beta.threads.runs.RunStatus;
import java.util.concurrent.CompletableFuture;

public final class AssistantAsyncExample {
    private AssistantAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        CompletableFuture<Assistant> assistantFuture = client.beta()
                .assistants()
                .create(AssistantCreateParams.builder()
                        .name("Math Tutor")
                        .instructions("You are a personal math tutor. Write and run code to answer math questions.")
                        // TODO: Update this example once we support `addCodeInterpreterTool()` or similar.
                        .addTool(CodeInterpreterTool.builder().build())
                        .model(ChatModel.GPT_4O_MINI)
                        .build());
        CompletableFuture<String> threadIdFuture = client.beta()
                .threads()
                .create()
                .thenComposeAsync(thread -> client.beta()
                        .threads()
                        .messages()
                        .create(MessageCreateParams.builder()
                                .threadId(thread.id())
                                .role(MessageCreateParams.Role.USER)
                                .content("I need to solve the equation `3x + 11 = 14`. Can you help me?")
                                .build()))
                .thenApply(Message::threadId);

        CompletableFuture<Run> runFuture = CompletableFuture.allOf(assistantFuture, threadIdFuture)
                .thenComposeAsync(unused -> client.beta()
                        .threads()
                        .runs()
                        .create(RunCreateParams.builder()
                                .threadId(threadIdFuture.join())
                                .assistantId(assistantFuture.join().id())
                                .instructions("Please address the user as Jane Doe. The user has a premium account.")
                                .build()));
        CompletableFuture<Run> polledRunFuture = runFuture.thenComposeAsync(run -> pollRun(client, run));

        polledRunFuture
                .thenComposeAsync(run -> {
                    if (!run.status().equals(RunStatus.COMPLETED)) {
                        return CompletableFuture.completedFuture(null);
                    }

                    return listThreadMessages(client, run.threadId())
                            .thenComposeAsync(unused -> client.beta()
                                    .assistants()
                                    .delete(AssistantDeleteParams.builder()
                                            .assistantId(assistantFuture.join().id())
                                            .build()))
                            .thenAccept(assistantDeleted ->
                                    System.out.println("Assistant deleted: " + assistantDeleted.deleted()));
                })
                .join();
    }

    private static CompletableFuture<Run> pollRun(OpenAIClientAsync client, Run run) {
        if (!run.status().equals(RunStatus.QUEUED) && !run.status().equals(RunStatus.IN_PROGRESS)) {
            System.out.println("Run completed with status: " + run.status() + "\n");
            return CompletableFuture.completedFuture(run);
        }

        System.out.println("Polling run...");
        try {
            java.lang.Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return client.beta()
                .threads()
                .runs()
                .retrieve(RunRetrieveParams.builder()
                        .threadId(run.threadId())
                        .runId(run.id())
                        .build())
                .thenComposeAsync(newRun -> pollRun(client, newRun));
    }

    private static CompletableFuture<Void> listThreadMessages(OpenAIClientAsync client, String threadId) {
        CompletableFuture<MessageListPageAsync> pageFuture = client.beta()
                .threads()
                .messages()
                .list(MessageListParams.builder()
                        .threadId(threadId)
                        .order(MessageListParams.Order.ASC)
                        .build());
        return pageFuture.thenComposeAsync(page -> page.autoPager()
                .forEach(
                        currentMessage -> {
                            System.out.println(currentMessage.role().toString().toUpperCase());
                            currentMessage.content().stream()
                                    .flatMap(content -> content.text().stream())
                                    .forEach(textBlock ->
                                            System.out.println(textBlock.text().value()));
                            System.out.println();

                            // Keep iterating
                            return true;
                        },
                        pageFuture.defaultExecutor()));
    }
}
