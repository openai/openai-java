package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * Configures mTLS through Java's native JSSE APIs and the SDK's existing OkHttp TLS hooks.
 *
 * <p>The PKCS#12 key store must contain the client private key and its certificate chain, ordered
 * leaf first followed by any intermediate certificates. The OpenAI API key is still required.
 */
public final class MutualTlsExample {
    private static final String MTLS_BASE_URL = "https://mtls.api.openai.com/v1";

    private MutualTlsExample() {}

    public static void main(String[] args) throws Exception {
        Path keyStorePath = Paths.get(requireEnv("OPENAI_MTLS_KEYSTORE"));
        char[] password = requireEnv("OPENAI_MTLS_KEYSTORE_PASSWORD").toCharArray();

        KeyStore clientKeyStore = KeyStore.getInstance("PKCS12");
        KeyManagerFactory keyManagers = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        try {
            try (InputStream input = Files.newInputStream(keyStorePath)) {
                clientKeyStore.load(input, password);
            }
            keyManagers.init(clientKeyStore, password);
        } finally {
            Arrays.fill(password, '\0');
        }

        OpenAIClient client = null;
        try {
            // Client identity and server trust are separate. A null KeyStore retains the JVM's
            // normal server-trust configuration.
            TrustManagerFactory trustManagers =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagers.init((KeyStore) null);
            X509TrustManager trustManager = findX509TrustManager(trustManagers);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagers.getKeyManagers(), new TrustManager[] {trustManager}, null);

            client = OpenAIOkHttpClient.builder()
                    .fromEnv()
                    // Native TLS configuration does not select an mTLS endpoint automatically.
                    .baseUrl(MTLS_BASE_URL)
                    // Avoid presenting the client identity to a redirect target.
                    .followRedirects(false)
                    .sslSocketFactory(sslContext.getSocketFactory())
                    .trustManager(trustManager)
                    .build();

            client.files().list();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    private static X509TrustManager findX509TrustManager(TrustManagerFactory trustManagerFactory) {
        return Arrays.stream(trustManagerFactory.getTrustManagers())
                .filter(X509TrustManager.class::isInstance)
                .map(X509TrustManager.class::cast)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "The default TrustManagerFactory did not provide an X509TrustManager"));
    }

    private static String requireEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(name + " must be set");
        }
        return value;
    }
}
