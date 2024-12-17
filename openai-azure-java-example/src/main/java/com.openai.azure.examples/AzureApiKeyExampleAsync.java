package com.openai.azure.examples;

import com.openai.azure.credential.AzureApiKeyCredential;
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.JsonValue;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionMessageParam;
import com.openai.models.ChatCompletionUserMessageParam;
import java.util.List;

/**
 * This example demonstrates how to use the Azure API key to authenticate with the OpenAI API, asynchronously.
 */
public final class AzureApiKeyExampleAsync {

    private AzureApiKeyExampleAsync() {}

    public static void main(String[] args) {
        OpenAIOkHttpClientAsync.Builder asyncClientBuilder = OpenAIOkHttpClientAsync.builder();

        /* Azure-specific code starts here */
        // You can either set 'endpoint' or 'apiKey' directly in the builder.
        // or set same two env vars and use fromEnv() method instead
        asyncClientBuilder
            .baseUrl(System.getenv("AZURE_OPENAI_ENDPOINT"))
            .credential(AzureApiKeyCredential.create(System.getenv("AZURE_OPENAI_KEY")));
        /* Azure-specific code ends here */

        // All code from this line down is general-purpose OpenAI code
        OpenAIClientAsync client = asyncClientBuilder.build();

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addMessage(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(
                        ChatCompletionUserMessageParam.builder()
                                .role(ChatCompletionUserMessageParam.Role.USER)
                                .content(ChatCompletionUserMessageParam.Content.ofTextContent("Who won the world series in 2020?"))
                                .build()))
                .model("gpt-4o")
                .build();

        ChatCompletion chatCompletion =
                client.chat().completions().create(params).join();

        List<ChatCompletion.Choice> choices = chatCompletion.choices();
        for (ChatCompletion.Choice choice : choices) {
            System.out.println("Choice content: " + choice.message().content().get());
        }

        JsonValue filterResult = chatCompletion._additionalProperties().get("prompt_filter_results");
        System.out.println("Content filter results: " + filterResult);
    }
}
