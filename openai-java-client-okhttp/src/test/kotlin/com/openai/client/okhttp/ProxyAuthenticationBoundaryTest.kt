package com.openai.client.okhttp

import com.openai.core.http.ProxyAuthenticator
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.ProxySelector
import javax.net.SocketFactory
import javax.net.ssl.SSLSocketFactory
import okhttp3.Address
import okhttp3.Authenticator
import okhttp3.ConnectionSpec
import okhttp3.Dns
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.Route
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProxyAuthenticationBoundaryTest {

    private val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", 8080))

    @Test
    fun originChallengeInsideHttpsTunnelDoesNotReceiveProxyCredentials() {
        val request = Request.Builder().url("https://example.test/resource").build()

        assertThat(authenticate(request, proxy)).isNull()
    }

    @Test
    fun connectRequestInsideHttpsTunnelDoesNotReceiveProxyCredentials() {
        val request =
            Request.Builder().url("https://example.test/resource").method("CONNECT", null).build()
        val handshake =
            okhttp3.Handshake.get(
                okhttp3.TlsVersion.TLS_1_2,
                okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                emptyList(),
                emptyList(),
            )
        assertThat(authenticate(request, proxy, handshake)).isNull()
    }

    @Test
    fun directOriginChallengeDoesNotReceiveProxyCredentials() {
        val request = Request.Builder().url("http://example.test/resource").build()

        assertThat(authenticate(request, Proxy.NO_PROXY)).isNull()
        assertThat(authenticate(request, null)).isNull()
    }

    @Test
    fun httpProxyChallengeStillReceivesCredentials() {
        val request = Request.Builder().url("http://example.test/resource").build()

        assertThat(authenticate(request, proxy)?.header("Proxy-Authorization"))
            .isEqualTo("Basic dGVzdC11c2VyOnRlc3QtcGFzc3dvcmQ=")
    }

    @Test
    fun connectHandshakeStillReceivesProxyCredentials() {
        val request = Request.Builder().url("https://example.test/").method("CONNECT", null).build()

        assertThat(authenticate(request, proxy)?.header("Proxy-Authorization"))
            .isEqualTo("Basic dGVzdC11c2VyOnRlc3QtcGFzc3dvcmQ=")
    }

    private fun authenticate(
        request: Request,
        configuredProxy: Proxy?,
        handshake: okhttp3.Handshake? = null,
    ): Request? {
        val route =
            configuredProxy?.let {
                Route(
                    Address(
                        request.url.host,
                        request.url.port,
                        Dns.SYSTEM,
                        SocketFactory.getDefault(),
                        if (request.url.isHttps) SSLSocketFactory.getDefault() as SSLSocketFactory
                        else null,
                        null,
                        null,
                        Authenticator.NONE,
                        it,
                        listOf(Protocol.HTTP_1_1),
                        listOf(ConnectionSpec.CLEARTEXT),
                        ProxySelector.getDefault(),
                    ),
                    it,
                    InetSocketAddress("127.0.0.1", 8080),
                )
            }
        val challenge =
            Response.Builder()
                .request(request)
                .handshake(handshake)
                .protocol(Protocol.HTTP_1_1)
                .code(407)
                .message("Proxy Authentication Required")
                .header("Proxy-Authenticate", "Basic realm=\"test\"")
                .body("".toResponseBody())
                .build()
        return OkHttpClient.builder()
            .proxyAuthenticator(ProxyAuthenticator.basic("test-user", "test-password"))
            .build()
            .use { client -> client.okHttpClient.proxyAuthenticator.authenticate(route, challenge) }
    }
}
