package com.openai.example;

import com.openai.auth.WorkloadIdentity;
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
 * Selects API-key or X.509 workload identity authentication with {@code OPENAI_AUTH_MODE}.
 *
 * <p>The PKCS#12 key store must contain the client private key and its certificate chain, ordered
 * leaf first followed by every required intermediate. JSSE owns all certificate and private-key
 * handling; the workload identity object contains only OpenAI resource identifiers.
 *
 * <p>This example configures HTTP API calls only. Realtime/WebSocket support is outside the scope of
 * X.509 workload identity phase 1.
 */
public final class X509WorkloadIdentityExample {
    private X509WorkloadIdentityExample() {}

    public static void main(String[] args) throws Exception {
        String authMode = System.getenv("OPENAI_AUTH_MODE");
        if (authMode == null || authMode.isEmpty()) {
            authMode = "api_key";
        }

        OpenAIOkHttpClient.Builder builder = OpenAIOkHttpClient.builder()
                .organization(configuredValue("openai.orgId", "OPENAI_ORG_ID"))
                .project(configuredValue("openai.projectId", "OPENAI_PROJECT_ID"));

        String baseUrl = configuredValue("openai.baseUrl", "OPENAI_BASE_URL");
        if (baseUrl != null) {
            if (baseUrl.isEmpty()) {
                throw new IllegalStateException("openai.baseUrl or OPENAI_BASE_URL must not be empty");
            }
            builder.baseUrl(baseUrl);
        }

        if ("api_key".equals(authMode)) {
            builder.apiKey(requireConfiguredValue("openai.apiKey", "OPENAI_API_KEY"));
        } else if ("x509".equals(authMode)) {
            if (baseUrl != null) {
                requireHttpsBaseUrl(baseUrl);
            }
            configureX509(builder);
        } else {
            throw new IllegalStateException("OPENAI_AUTH_MODE must be 'api_key' or 'x509'");
        }

        OpenAIClient client = builder.build();
        try {
            client.files().list();
        } finally {
            client.close();
        }
    }

    private static void configureX509(OpenAIOkHttpClient.Builder builder) throws Exception {
        Path keyStorePath = Paths.get(requireEnv("OPENAI_MTLS_KEYSTORE"));
        String configuredPassword = System.getenv("OPENAI_MTLS_KEYSTORE_PASSWORD");
        char[] password = configuredPassword == null ? new char[0] : configuredPassword.toCharArray();

        KeyManagerFactory keyManagers = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        try {
            KeyStore clientKeyStore = KeyStore.getInstance("PKCS12");
            try (InputStream input = Files.newInputStream(keyStorePath)) {
                clientKeyStore.load(input, password);
            }
            keyManagers.init(clientKeyStore, password);
        } finally {
            Arrays.fill(password, '\0');
        }

        // A null trust-manager array keeps JVM default server trust independent of the client key
        // managers. OkHttp separately needs the corresponding default X509TrustManager.
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers.getKeyManagers(), null, null);
        X509TrustManager trustManager = defaultTrustManager();

        builder.followRedirects(false)
                .sslSocketFactory(sslContext.getSocketFactory())
                .trustManager(trustManager)
                .workloadIdentity(WorkloadIdentity.x509Builder()
                        .identityProviderId(requireEnv("OPENAI_IDENTITY_PROVIDER_ID"))
                        .serviceAccountId(requireEnv("OPENAI_SERVICE_ACCOUNT_ID"))
                        .build());
    }

    private static X509TrustManager defaultTrustManager() throws Exception {
        TrustManagerFactory trustManagers = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagers.init((KeyStore) null);
        return Arrays.stream(trustManagers.getTrustManagers())
                .filter(X509TrustManager.class::isInstance)
                .map(X509TrustManager.class::cast)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "The default TrustManagerFactory did not provide an X509TrustManager"));
    }

    private static String requireConfiguredValue(String propertyName, String environmentVariable) {
        String value = configuredValue(propertyName, environmentVariable);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(propertyName + " or " + environmentVariable + " must be set");
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
            throw new IllegalStateException("X.509 workload identity requires a valid HTTPS base URL");
        }
        if (!"https".equalsIgnoreCase(baseUri.getScheme()) || baseUri.getRawAuthority() == null) {
            throw new IllegalStateException("X.509 workload identity requires a valid HTTPS base URL");
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
