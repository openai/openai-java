package example.legacy;

import com.openai.client.okhttp.*;
import java.net.Proxy;
import java.nio.file.*;
import java.security.KeyStore;
import java.time.Duration;
import javax.net.ssl.*;

public class Legacy {
    public static void main(String[] args) throws Exception {
        if (!"openai.java.client.okhttp".equals(OkHttpClient.class.getModule().getName())) throw new AssertionError();
        try (OkHttpClient transport = OkHttpClient.Companion.builder().proxy(Proxy.NO_PROXY)
                .maxIdleConnections(1).keepAliveDuration(Duration.ofSeconds(1)).build()) {}
        var nativeClient = new okhttp3.OkHttpClient();
        try (OkHttpClient transport = new OkHttpClient(nativeClient)) {}
        var keys = KeyStore.getInstance("PKCS12");
        char[] password = "fixture".toCharArray();
        try (var file = Files.newInputStream(Path.of(args[0]))) { keys.load(file, password); }
        var km = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        km.init(keys, password);
        var tm = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tm.init(keys);
        var tls = X509Transport.builder().keyManager((X509ExtendedKeyManager) km.getKeyManagers()[0])
                .trustManager((X509TrustManager) tm.getTrustManagers()[0]).certificateAlias("fixture").build();
        var id = X509WorkloadIdentity.builder().transport(tls).identityProviderId("idp")
                .serviceAccountId("account").refreshBuffer(Duration.ZERO).build();
        if (id.transport() != tls || !id.identityProviderId().equals("idp") || !id.serviceAccountId().equals("account")
                || !id.refreshBuffer().equals(Duration.ZERO)) throw new AssertionError();
        var sync = OpenAIOkHttpClient.builder().x509WorkloadIdentity(id).build();
        try { sync.chat().completions(); } finally { sync.close(); }
        var async = OpenAIOkHttpClientAsync.builder().apiKey("test").okHttpClient(new okhttp3.OkHttpClient()).build();
        try { async.responses(); } finally { async.close(); }
        System.out.println("Original named-module binary linked, including both factories and X509 identity.");
    }
}
