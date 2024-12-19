package com.openai.azure.examples;

import com.azure.identity.AuthenticationUtil;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.JsonValue;
import com.openai.credential.BearerTokenCredential;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionMessageParam;
import com.openai.models.ChatCompletionUserMessageParam;
import java.util.List;

/**
 * This example demonstrates how to use the Azure Entra ID to authenticate with the OpenAI API, asynchronously.
 */
public final class AzureEntraIDExampleAsync {

    private AzureEntraIDExampleAsync() {}

    public static void main(String[] args) {
        OpenAIOkHttpClientAsync.Builder asyncClientBuilder = OpenAIOkHttpClientAsync.builder();

        /* Azure-specific code starts here */
        // You can either set 'endpoint' directly in the builder.
        // or set the env var "AZURE_OPENAI_ENDPOINT" and use fromEnv() method instead
        asyncClientBuilder
            .baseUrl(System.getenv("AZURE_OPENAI_ENDPOINT"))
            .credential(BearerTokenCredential.create(
                AuthenticationUtil.getBearerTokenSupplier(
                    new DefaultAzureCredentialBuilder().build(), "https://cognitiveservices.azure.com/.default")
            ));
        /* Azure-specific code ends here */

        // All code from this line down is general-purpose OpenAI code
        OpenAIClientAsync asyncClient = asyncClientBuilder.build();

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addMessage(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(
                        ChatCompletionUserMessageParam.builder()
                                .role(ChatCompletionUserMessageParam.Role.USER)
                                .content(ChatCompletionUserMessageParam.Content.ofTextContent("Who won the world series in 2020?"))
                                .build()))
                .model("gpt-4o")
                .build();

        ChatCompletion chatCompletion =
                asyncClient.chat().completions().create(params).join();

        List<ChatCompletion.Choice> choices = chatCompletion.choices();
        for (ChatCompletion.Choice choice : choices) {
            System.out.println("Choice content: " + choice.message().content().get());
        }

        JsonValue filterResult = chatCompletion._additionalProperties().get("prompt_filter_results");
        System.out.println("Content filter results: " + filterResult);
    }
}
