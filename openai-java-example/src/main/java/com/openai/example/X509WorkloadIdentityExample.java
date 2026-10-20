package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.client.okhttp.X509Transport;
import com.openai.client.okhttp.X509WorkloadIdentity;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.time.Duration;
import java.util.Arrays;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;

public final class X509WorkloadIdentityExample {
    private X509WorkloadIdentityExample() {}

    public static void main(String[] args) throws Exception {
        char[] password = requiredEnvironment("OPENAI_X509_KEYSTORE_PASSWORD").toCharArray();
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            try (InputStream input =
                    Files.newInputStream(Paths.get(requiredEnvironment("OPENAI_X509_KEYSTORE_PATH")))) {
                keyStore.load(input, password);
            }

            KeyManagerFactory keyManagers = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagers.init(keyStore, password);
            X509ExtendedKeyManager keyManager = Arrays.stream(keyManagers.getKeyManagers())
                    .filter(X509ExtendedKeyManager.class::isInstance)
                    .map(X509ExtendedKeyManager.class::cast)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("No X.509 key manager available"));

            TrustManagerFactory trustManagers =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagers.init((KeyStore) null);
            X509TrustManager trustManager = Arrays.stream(trustManagers.getTrustManagers())
                    .filter(X509TrustManager.class::isInstance)
                    .map(X509TrustManager.class::cast)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("No X.509 trust manager available"));

            X509Transport transport = X509Transport.builder()
                    .keyManager(keyManager)
                    .certificateAlias(requiredEnvironment("OPENAI_X509_CERTIFICATE_ALIAS"))
                    .trustManager(trustManager)
                    .build();
            X509WorkloadIdentity identity = X509WorkloadIdentity.builder()
                    .identityProviderId(requiredEnvironment("OPENAI_IDENTITY_PROVIDER_ID"))
                    .serviceAccountId(requiredEnvironment("OPENAI_SERVICE_ACCOUNT_ID"))
                    .transport(transport)
                    .refreshBuffer(Duration.ofMinutes(10))
                    .build();

            OpenAIClient client =
                    OpenAIOkHttpClient.builder().x509WorkloadIdentity(identity).build();
            try {
                client.files().list();
            } finally {
                client.close();
            }
        } finally {
            Arrays.fill(password, '\0');
        }
    }

    private static String requiredEnvironment(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing required environment variable: " + name);
        }
        return value;
    }
}
