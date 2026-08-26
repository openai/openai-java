package com.openai.example;

import com.openai.auth.X509WorkloadIdentity;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.client.okhttp.X509Transport;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;

/** Uses a PKCS#12 client identity for direct-only X.509 workload identity federation. */
public final class X509WorkloadIdentityExample {
    private X509WorkloadIdentityExample() {}

    public static void main(String[] args) throws Exception {
        char[] password = requireEnv("OPENAI_X509_KEYSTORE_PASSWORD").toCharArray();
        OpenAIClient client = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            Path keyStorePath = Paths.get(requireEnv("OPENAI_X509_KEYSTORE_PATH"));
            try (InputStream input = Files.newInputStream(keyStorePath)) {
                keyStore.load(input, password);
            }

            KeyManagerFactory keyManagers = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagers.init(keyStore, password);
            X509ExtendedKeyManager keyManager = Arrays.stream(keyManagers.getKeyManagers())
                    .filter(X509ExtendedKeyManager.class::isInstance)
                    .map(X509ExtendedKeyManager.class::cast)
                    .findFirst()
                    .orElseThrow(() ->
                            new IllegalStateException("The PKCS#12 store did not provide an X509ExtendedKeyManager"));

            TrustManagerFactory trustManagers =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagers.init((KeyStore) null);
            X509TrustManager trustManager = Arrays.stream(trustManagers.getTrustManagers())
                    .filter(X509TrustManager.class::isInstance)
                    .map(X509TrustManager.class::cast)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("The JVM did not provide an X509TrustManager"));

            X509WorkloadIdentity identity = X509WorkloadIdentity.builder()
                    .identityProviderId(requireEnv("OPENAI_X509_IDENTITY_PROVIDER_ID"))
                    .serviceAccountId(requireEnv("OPENAI_X509_SERVICE_ACCOUNT_ID"))
                    .build();
            X509Transport transport = X509Transport.builder()
                    .keyManager(keyManager)
                    .certificateAlias(requireEnv("OPENAI_X509_CERTIFICATE_ALIAS"))
                    .trustManager(trustManager)
                    .build();

            client = OpenAIOkHttpClient.x509Builder(identity, transport).build();
            client.models().list();
        } finally {
            Arrays.fill(password, '\0');
            if (client != null) {
                client.close();
            }
        }
    }

    private static String requireEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(name + " must be set");
        }
        return value;
    }
}
