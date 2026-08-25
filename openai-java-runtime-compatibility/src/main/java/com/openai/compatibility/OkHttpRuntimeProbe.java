package com.openai.compatibility;

import com.openai.auth.X509WorkloadIdentity;
import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.client.okhttp.X509Transport;
import java.math.BigInteger;
import java.net.Socket;
import java.net.URISyntaxException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;

public final class OkHttpRuntimeProbe {
    private OkHttpRuntimeProbe() {}

    public static void main(String[] args) {
        assertLoadedFromJar(OpenAIOkHttpClient.class);
        assertLoadedFromJar(X509WorkloadIdentity.class);
        assertLoadedFromJar(X509Transport.class);
        X509WorkloadIdentity identity = X509WorkloadIdentity.builder()
                .identityProviderId("idp_runtime_probe")
                .serviceAccountId("svc_runtime_probe")
                .build();
        X509Transport transport = X509Transport.builder()
                .keyManager(new ProbeKeyManager())
                .certificateAlias(ProbeKeyManager.ALIAS)
                .trustManager(new ProbeTrustManager())
                .build();

        OpenAIClient x509Client =
                OpenAIOkHttpClient.x509Builder(identity, transport).build();
        x509Client.close();
        OpenAIClientAsync x509AsyncClient =
                OpenAIOkHttpClientAsync.x509Builder(identity, transport).build();
        x509AsyncClient.close();

        OpenAIClient client =
                OpenAIOkHttpClient.builder().apiKey("runtime-probe").build();
        try {
            if (client.models() == null) {
                throw new IllegalStateException("OkHttp client did not create its model service");
            }
        } finally {
            client.close();
        }

        System.out.printf("Exercised an OkHttp SDK client on Java %s.%n", System.getProperty("java.version"));
    }

    private static void assertLoadedFromJar(Class<?> type) {
        try {
            String location = type.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();
            if (!location.endsWith(".jar")) {
                throw new IllegalStateException(type.getName() + " was not loaded from an installed JAR");
            }
        } catch (URISyntaxException exception) {
            throw new IllegalStateException("Could not inspect installed artifact location", exception);
        }
    }

    /** Concrete protocol objects exercise TLS/client linkage without opening a network socket. */
    private static final class ProbeKeyManager extends X509ExtendedKeyManager {
        private static final String ALIAS = "runtime-probe";
        private final X509Certificate certificate = new ProbeCertificate();
        private final PrivateKey privateKey = new ProbePrivateKey();

        @Override
        public String[] getClientAliases(String keyType, Principal[] issuers) {
            return new String[] {ALIAS};
        }

        @Override
        public String chooseClientAlias(String[] keyTypes, Principal[] issuers, Socket socket) {
            return ALIAS;
        }

        @Override
        public String chooseEngineClientAlias(String[] keyTypes, Principal[] issuers, SSLEngine engine) {
            return ALIAS;
        }

        @Override
        public String[] getServerAliases(String keyType, Principal[] issuers) {
            return null;
        }

        @Override
        public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
            return null;
        }

        @Override
        public X509Certificate[] getCertificateChain(String alias) {
            return ALIAS.equals(alias) ? new X509Certificate[] {certificate} : null;
        }

        @Override
        public PrivateKey getPrivateKey(String alias) {
            return ALIAS.equals(alias) ? privateKey : null;
        }
    }

    private static final class ProbeTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {}

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static final class ProbePrivateKey implements PrivateKey {
        @Override
        public String getAlgorithm() {
            return "RSA";
        }

        @Override
        public String getFormat() {
            return "PKCS#8";
        }

        @Override
        public byte[] getEncoded() {
            return new byte[] {0};
        }
    }

    private static final class ProbeCertificate extends X509Certificate {
        @Override
        public void checkValidity() {}

        @Override
        public void checkValidity(Date date) {}

        @Override
        public int getVersion() {
            return 3;
        }

        @Override
        public BigInteger getSerialNumber() {
            return BigInteger.ONE;
        }

        @Override
        public Principal getIssuerDN() {
            return () -> "CN=runtime-probe";
        }

        @Override
        public Principal getSubjectDN() {
            return () -> "CN=runtime-probe";
        }

        @Override
        public Date getNotBefore() {
            return new Date(0);
        }

        @Override
        public Date getNotAfter() {
            return new Date(Long.MAX_VALUE);
        }

        @Override
        public byte[] getTBSCertificate() throws CertificateEncodingException {
            return new byte[] {0};
        }

        @Override
        public byte[] getSignature() {
            return new byte[] {0};
        }

        @Override
        public String getSigAlgName() {
            return "NONEwithRSA";
        }

        @Override
        public String getSigAlgOID() {
            return "1.2.840.113549.1.1.1";
        }

        @Override
        public byte[] getSigAlgParams() {
            return null;
        }

        @Override
        public boolean[] getIssuerUniqueID() {
            return null;
        }

        @Override
        public boolean[] getSubjectUniqueID() {
            return null;
        }

        @Override
        public boolean[] getKeyUsage() {
            return null;
        }

        @Override
        public int getBasicConstraints() {
            return -1;
        }

        @Override
        public byte[] getEncoded() throws CertificateEncodingException {
            return new byte[] {0};
        }

        @Override
        public void verify(PublicKey key) throws CertificateException {}

        @Override
        public void verify(PublicKey key, String provider) throws CertificateException {}

        @Override
        public String toString() {
            return "runtime-probe-certificate";
        }

        @Override
        public PublicKey getPublicKey() {
            return null;
        }

        @Override
        public Set<String> getCriticalExtensionOIDs() {
            return null;
        }

        @Override
        public Set<String> getNonCriticalExtensionOIDs() {
            return null;
        }

        @Override
        public byte[] getExtensionValue(String oid) {
            return null;
        }

        @Override
        public boolean hasUnsupportedCriticalExtension() {
            return false;
        }
    }
}
