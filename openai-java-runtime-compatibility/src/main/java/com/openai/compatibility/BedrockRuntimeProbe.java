package com.openai.compatibility;

import com.openai.bedrock.BedrockOpenAIOkHttpClient;
import com.openai.client.OpenAIClient;

public final class BedrockRuntimeProbe {
    private static final String[] RUNTIME_PROVIDER_CLASSES = {
        "software.amazon.awssdk.services.sts.StsClient",
        "software.amazon.awssdk.services.sso.SsoClient",
        "software.amazon.awssdk.services.ssooidc.SsoOidcClient",
        "software.amazon.awssdk.services.signin.SigninClient",
        "software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient",
    };

    private BedrockRuntimeProbe() {}

    public static void main(String[] args) throws ClassNotFoundException {
        for (String providerClass : RUNTIME_PROVIDER_CLASSES) {
            Class.forName(providerClass);
        }

        OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
                .awsRegion("us-east-1")
                .baseUrl("https://example.com/openai/v1")
                .skipAuth(true)
                .build();
        try {
            if (client.models() == null) {
                throw new IllegalStateException("Bedrock client did not create its model service");
            }
        } finally {
            client.close();
        }

        System.out.printf(
                "Exercised openai-java-bedrock and %d runtime providers on Java %s.%n",
                RUNTIME_PROVIDER_CLASSES.length, System.getProperty("java.version"));
    }
}
