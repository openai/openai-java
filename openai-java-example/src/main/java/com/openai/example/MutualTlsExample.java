package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * Configures mTLS through Java's native JSSE APIs and the SDK's existing OkHttp TLS hooks.
 *
 * <p>The PKCS#12 key store must contain the client private key and its certificate chain, ordered
 * leaf first followed by any intermediate certificates. The OpenAI API key is still required.
 * OpenAI certificate-chain verification requires separate enablement; without it, the leaf must be
 * directly signed by an active CA certificate uploaded to OpenAI.
 */
public final class MutualTlsExample {
    private static final String DEFAULT_MTLS_BASE_URL = "https://mtls.api.openai.com/v1";

    private MutualTlsExample() {}

    public static void main(String[] args) throws Exception {
        String apiKey = requireConfiguredValue("openai.apiKey", "OPENAI_API_KEY");
        String baseUrl = configuredValue("openai.baseUrl", "OPENAI_BASE_URL");
        if (baseUrl == null) {
            baseUrl = DEFAULT_MTLS_BASE_URL;
        } else if (baseUrl.isEmpty()) {
            throw new IllegalStateException("openai.baseUrl or OPENAI_BASE_URL must not be empty for OpenAI mTLS");
        }
        requireHttpsBaseUrl(baseUrl);
        String organization = configuredValue("openai.orgId", "OPENAI_ORG_ID");
        String project = configuredValue("openai.projectId", "OPENAI_PROJECT_ID");
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
            sslContext.init(keyManagers.getKeyManagers(), null, null);

            client = OpenAIOkHttpClient.builder()
                    // Select an OpenAI bearer credential explicitly; do not fall back to Azure.
                    .apiKey(apiKey)
                    // Retain the organization and project scope from normal SDK configuration.
                    .organization(organization)
                    .project(project)
                    // An explicit system property or environment variable preserves EU/custom routing.
                    .baseUrl(baseUrl)
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

    private static String requireConfiguredValue(String propertyName, String environmentVariable) {
        String value = configuredValue(propertyName, environmentVariable);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(
                    propertyName + " or " + environmentVariable + " must be set for OpenAI mTLS");
        }
        return value;
    }

    private static String configuredValue(String propertyName, String environmentVariable) {
        String value = System.getProperty(propertyName);
        return value != null ? value : System.getenv(environmentVariable);
    }

    private static void requireHttpsBaseUrl(String baseUrl) {
        URI baseUri;
        try {
            baseUri = URI.create(baseUrl);
        } catch (IllegalArgumentException ignored) {
            // URI parse exceptions include the rejected value, which may contain credentials.
            throw new IllegalStateException("OpenAI mTLS requires a valid HTTPS base URL");
        }
        if (!"https".equalsIgnoreCase(baseUri.getScheme()) || baseUri.getRawAuthority() == null) {
            throw new IllegalStateException("OpenAI mTLS requires a valid HTTPS base URL");
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
