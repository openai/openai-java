package com.openai.client.okhttp

import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.ProxyAuthenticator
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.ProxySelector
import java.net.SocketAddress
import java.net.URI
import java.nio.file.Path
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import javax.net.SocketFactory
import javax.net.ssl.SSLSocketFactory
import okhttp3.Address
import okhttp3.Authenticator
import okhttp3.ConnectionSpec
import okhttp3.Credentials
import okhttp3.Dns
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.Route
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import okhttp3.tls.HandshakeCertificates
import okhttp3.tls.HeldCertificate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.io.TempDir

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

    @TestFactory
    fun proxyConnectAuthenticatesButTunneledOriginCannot() =
        listOf(false, true).map { borrowed ->
            dynamicTest("borrowed=$borrowed") {
                val certificate =
                    HeldCertificate.Builder()
                        .commonName("localhost")
                        .addSubjectAlternativeName("localhost")
                        .build()
                val serverTls = HandshakeCertificates.Builder().heldCertificate(certificate).build()
                val clientTls =
                    HandshakeCertificates.Builder()
                        .addTrustedCertificate(certificate.certificate)
                        .build()
                val challenges = AtomicInteger()
                MockWebServer().use { server ->
                    server.useHttps(serverTls.sslSocketFactory(), true)
                    server.enqueue(
                        MockResponse()
                            .setResponseCode(407)
                            .setHeader("Proxy-Authenticate", "Basic realm=\"proxy\"")
                    )
                    server.enqueue(
                        MockResponse().setSocketPolicy(SocketPolicy.UPGRADE_TO_SSL_AT_END)
                    )
                    server.enqueue(
                        MockResponse()
                            .setResponseCode(407)
                            .setHeader("Proxy-Authenticate", "Basic realm=\"origin\"")
                    )
                    // A vulnerable adapter retries the tunneled request with proxy credentials.
                    server.enqueue(MockResponse().setBody("unexpected retry"))
                    server.start()
                    val native =
                        okhttp3.OkHttpClient.Builder()
                            .proxy(server.toProxyAddress())
                            .sslSocketFactory(clientTls.sslSocketFactory(), clientTls.trustManager)
                            .proxyAuthenticator { _, response ->
                                if (response.header("Proxy-Authenticate") == "OkHttp-Preemptive")
                                    null
                                else {
                                    challenges.incrementAndGet()
                                    response.request
                                        .newBuilder()
                                        .header(
                                            "Proxy-Authorization",
                                            Credentials.basic("test-user", "test-password"),
                                        )
                                        .build()
                                }
                            }
                            .build()
                    native.useTestClient {
                        val client =
                            if (borrowed) OkHttpClient.borrow(native, emptyList())
                            else
                                OkHttpClient.builder()
                                    .proxy(server.toProxyAddress())
                                    .sslSocketFactory(clientTls.sslSocketFactory())
                                    .trustManager(clientTls.trustManager)
                                    .proxyAuthenticator(
                                        ProxyAuthenticator.basic("test-user", "test-password")
                                    )
                                    .build()
                        client.use {
                            it.execute(
                                    HttpRequest.builder()
                                        .method(HttpMethod.GET)
                                        .baseUrl(server.url("/").toString())
                                        .putHeader(
                                            "Proxy-Authorization",
                                            "Basic synthetic-proxy-credential",
                                        )
                                        .build()
                                )
                                .use { response ->
                                    assertThat(response.statusCode()).isEqualTo(407)
                                }
                        }
                        val initial = server.takeRequest(5, TimeUnit.SECONDS)!!
                        assertThat(initial.method).isEqualTo("CONNECT")
                        val authenticated = server.takeRequest(5, TimeUnit.SECONDS)!!
                        assertThat(authenticated.method).isEqualTo("CONNECT")
                        assertThat(authenticated.getHeader("Proxy-Authorization"))
                            .isEqualTo(Credentials.basic("test-user", "test-password"))
                        val origin = server.takeRequest(5, TimeUnit.SECONDS)!!
                        assertThat(origin.method).isEqualTo("GET")
                        assertThat(origin.getHeader("Proxy-Authorization")).isNull()
                        assertThat(server.requestCount).isEqualTo(3)
                        if (borrowed) assertThat(challenges.get()).isEqualTo(1)
                    }
                }
            }
        }

    @TestFactory
    fun proxyCredentialsStayWithTheSelectedProxy() =
        listOf("direct", "same-proxy", "other-proxy").flatMap { destinationRoute ->
            listOf(
                    "challenge",
                    "header",
                    "interceptor",
                    "rebuilt-application",
                    "rebuilt-network",
                    "rebuilt-authenticator",
                )
                .flatMap { authentication ->
                    listOf(false, true).map { async ->
                        dynamicTest(
                            "destination=$destinationRoute authentication=$authentication async=$async"
                        ) {
                            MockWebServer().use { originProxy ->
                                MockWebServer().use { destination ->
                                    originProxy.start()
                                    destination.start()
                                    val initialProxy = originProxy.toProxyAddress()
                                    val redirectUrl =
                                        if (destinationRoute == "same-proxy")
                                            "http://destination.test/resource"
                                        else destination.url("/resource").toString()
                                    fun challenge() =
                                        MockResponse()
                                            .setResponseCode(407)
                                            .setHeader(
                                                "Proxy-Authenticate",
                                                "Basic realm=\"test proxy\"",
                                            )
                                    if (authentication == "challenge")
                                        originProxy.enqueue(challenge())
                                    if (authentication == "rebuilt-authenticator") {
                                        originProxy.enqueue(
                                            MockResponse()
                                                .setResponseCode(401)
                                                .setHeader(
                                                    "WWW-Authenticate",
                                                    "Basic realm=\"origin\"",
                                                )
                                        )
                                    }
                                    originProxy.enqueue(
                                        MockResponse()
                                            .setResponseCode(302)
                                            .setHeader("Location", redirectUrl)
                                    )
                                    when (destinationRoute) {
                                        "same-proxy" ->
                                            originProxy.enqueue(MockResponse().setBody("ok"))
                                        "other-proxy" -> {
                                            destination.enqueue(challenge())
                                            destination.enqueue(MockResponse().setBody("ok"))
                                        }
                                        else -> destination.enqueue(MockResponse().setBody("ok"))
                                    }
                                    val initialCredentials =
                                        Credentials.basic("initial-proxy", "fake-secret")
                                    val otherCredentials =
                                        Credentials.basic("other-proxy", "other-fake-secret")
                                    val native =
                                        okhttp3.OkHttpClient.Builder()
                                            .callTimeout(5, TimeUnit.SECONDS)
                                            .proxySelector(
                                                object : ProxySelector() {
                                                    override fun select(uri: URI): List<Proxy> =
                                                        listOf(
                                                            if (
                                                                uri.host == "origin.test" ||
                                                                    destinationRoute == "same-proxy"
                                                            )
                                                                initialProxy
                                                            else if (
                                                                destinationRoute == "other-proxy"
                                                            )
                                                                destination.toProxyAddress()
                                                            else Proxy.NO_PROXY
                                                        )

                                                    override fun connectFailed(
                                                        uri: URI,
                                                        address: SocketAddress,
                                                        failure: IOException,
                                                    ) = Unit
                                                }
                                            )
                                            .proxyAuthenticator { route, response ->
                                                val credentials =
                                                    if (route!!.proxy == initialProxy)
                                                        initialCredentials
                                                    else otherCredentials
                                                if (
                                                    response.request.header(
                                                        "Proxy-Authorization"
                                                    ) != null
                                                )
                                                    null
                                                else
                                                    response.request
                                                        .newBuilder()
                                                        .header("Proxy-Authorization", credentials)
                                                        .build()
                                            }
                                            .apply {
                                                if (
                                                    authentication in
                                                        listOf(
                                                            "rebuilt-application",
                                                            "rebuilt-network",
                                                        )
                                                ) {
                                                    val rebuild =
                                                        okhttp3.Interceptor { chain ->
                                                            chain.proceed(
                                                                Request.Builder()
                                                                    .url(chain.request().url)
                                                                    .headers(
                                                                        chain.request().headers
                                                                    )
                                                                    .build()
                                                            )
                                                        }
                                                    if (authentication == "rebuilt-application")
                                                        addInterceptor(rebuild)
                                                    else addNetworkInterceptor(rebuild)
                                                }
                                                if (authentication == "rebuilt-authenticator") {
                                                    authenticator { _, response ->
                                                        if (
                                                            response.request.header(
                                                                "Authorization"
                                                            ) != null
                                                        )
                                                            null
                                                        else
                                                            Request.Builder()
                                                                .url(response.request.url)
                                                                .headers(response.request.headers)
                                                                .header(
                                                                    "Authorization",
                                                                    "Basic synthetic-origin-credential",
                                                                )
                                                                .build()
                                                    }
                                                }
                                                if (authentication == "interceptor") {
                                                    addInterceptor { chain ->
                                                        chain.proceed(
                                                            chain
                                                                .request()
                                                                .newBuilder()
                                                                .header(
                                                                    "Proxy-Authorization",
                                                                    initialCredentials,
                                                                )
                                                                .build()
                                                        )
                                                    }
                                                }
                                            }
                                            .build()
                                    native.useTestClient {
                                        OkHttpClient.borrow(native, emptyList()).use { client ->
                                            val request =
                                                HttpRequest.builder()
                                                    .method(HttpMethod.GET)
                                                    .baseUrl("http://origin.test/resource")
                                                    .apply {
                                                        if (
                                                            authentication == "header" ||
                                                                authentication.startsWith(
                                                                    "rebuilt-"
                                                                )
                                                        ) {
                                                            putHeader(
                                                                "Proxy-Authorization",
                                                                initialCredentials,
                                                            )
                                                        }
                                                    }
                                                    .build()
                                            val response =
                                                if (async)
                                                    client
                                                        .executeAsync(request)
                                                        .get(5, TimeUnit.SECONDS)
                                                else client.execute(request)
                                            response.use {
                                                assertThat(it.statusCode()).isEqualTo(200)
                                            }
                                        }
                                        if (authentication == "rebuilt-authenticator") {
                                            val unauthenticated =
                                                originProxy.takeRequest(5, TimeUnit.SECONDS)!!
                                            assertThat(unauthenticated.getHeader("Authorization"))
                                                .isNull()
                                            assertThat(
                                                    unauthenticated.getHeader("Proxy-Authorization")
                                                )
                                                .isEqualTo(initialCredentials)
                                        }
                                        if (authentication == "challenge") {
                                            assertThat(
                                                    originProxy
                                                        .takeRequest(5, TimeUnit.SECONDS)!!
                                                        .getHeader("Proxy-Authorization")
                                                )
                                                .isNull()
                                        }
                                        val originRequest =
                                            originProxy.takeRequest(5, TimeUnit.SECONDS)!!
                                        assertThat(originRequest.getHeader("Proxy-Authorization"))
                                            .isEqualTo(initialCredentials)
                                        if (authentication == "rebuilt-authenticator") {
                                            assertThat(originRequest.getHeader("Authorization"))
                                                .isEqualTo("Basic synthetic-origin-credential")
                                        }
                                        if (destinationRoute == "same-proxy") {
                                            assertThat(
                                                    originProxy
                                                        .takeRequest(5, TimeUnit.SECONDS)!!
                                                        .getHeader("Proxy-Authorization")
                                                )
                                                .isEqualTo(initialCredentials)
                                        } else {
                                            assertThat(
                                                    destination
                                                        .takeRequest(5, TimeUnit.SECONDS)!!
                                                        .getHeader("Proxy-Authorization")
                                                )
                                                .isNull()
                                            if (destinationRoute == "other-proxy") {
                                                assertThat(
                                                        destination
                                                            .takeRequest(5, TimeUnit.SECONDS)!!
                                                            .getHeader("Proxy-Authorization")
                                                    )
                                                    .isEqualTo(otherCredentials)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        }

    @TestFactory
    fun strippedProxyCredentialsAreNotRestoredOnRedirect() =
        listOf("direct", "https-proxy").flatMap { initialRoute ->
            listOf(false, true).map { async ->
                dynamicTest("initialRoute=$initialRoute async=$async") {
                    val certificate =
                        HeldCertificate.Builder()
                            .commonName("localhost")
                            .addSubjectAlternativeName("localhost")
                            .build()
                    val serverTls =
                        HandshakeCertificates.Builder().heldCertificate(certificate).build()
                    val clientTls =
                        HandshakeCertificates.Builder()
                            .addTrustedCertificate(certificate.certificate)
                            .build()
                    MockWebServer().use { initial ->
                        MockWebServer().use { destinationProxy ->
                            if (initialRoute == "https-proxy") {
                                initial.useHttps(serverTls.sslSocketFactory(), true)
                                initial.enqueue(
                                    MockResponse()
                                        .setSocketPolicy(SocketPolicy.UPGRADE_TO_SSL_AT_END)
                                )
                            }
                            initial.enqueue(
                                MockResponse()
                                    .setResponseCode(302)
                                    .setHeader("Location", "http://destination.test/resource")
                            )
                            destinationProxy.enqueue(MockResponse().setBody("ok"))
                            initial.start()
                            destinationProxy.start()
                            val native =
                                okhttp3.OkHttpClient.Builder()
                                    .callTimeout(5, TimeUnit.SECONDS)
                                    .sslSocketFactory(
                                        clientTls.sslSocketFactory(),
                                        clientTls.trustManager,
                                    )
                                    .proxySelector(
                                        object : ProxySelector() {
                                            override fun select(uri: URI): List<Proxy> =
                                                listOf(
                                                    if (uri.host == "destination.test")
                                                        destinationProxy.toProxyAddress()
                                                    else if (initialRoute == "https-proxy")
                                                        initial.toProxyAddress()
                                                    else Proxy.NO_PROXY
                                                )

                                            override fun connectFailed(
                                                uri: URI,
                                                address: SocketAddress,
                                                failure: IOException,
                                            ) = Unit
                                        }
                                    )
                                    .build()
                            native.useTestClient {
                                OkHttpClient.borrow(native, emptyList()).use { client ->
                                    val request =
                                        HttpRequest.builder()
                                            .method(HttpMethod.GET)
                                            .baseUrl(initial.url("/resource").toString())
                                            .putHeader(
                                                "Proxy-Authorization",
                                                "Basic synthetic-proxy-credential",
                                            )
                                            .build()
                                    val response =
                                        if (async)
                                            client.executeAsync(request).get(5, TimeUnit.SECONDS)
                                        else client.execute(request)
                                    response.use { assertThat(it.statusCode()).isEqualTo(200) }
                                }
                                if (initialRoute == "https-proxy") {
                                    assertThat(initial.takeRequest(5, TimeUnit.SECONDS)!!.method)
                                        .isEqualTo("CONNECT")
                                }
                                assertThat(
                                        initial
                                            .takeRequest(5, TimeUnit.SECONDS)!!
                                            .getHeader("Proxy-Authorization")
                                    )
                                    .isNull()
                                assertThat(
                                        destinationProxy
                                            .takeRequest(5, TimeUnit.SECONDS)!!
                                            .getHeader("Proxy-Authorization")
                                    )
                                    .isNull()
                            }
                        }
                    }
                }
            }
        }

    @TestFactory
    fun cachedRedirectDoesNotBindPreemptiveCredentialsToAnotherProxy(@TempDir directory: Path) =
        listOf(false, true).map { async ->
            dynamicTest("async=$async") {
                MockWebServer().use { initialProxy ->
                    MockWebServer().use { destinationProxy ->
                        initialProxy.enqueue(
                            MockResponse()
                                .setResponseCode(302)
                                .setHeader("Location", "http://destination.test/resource")
                                .setHeader("Cache-Control", "public, max-age=3600")
                        )
                        repeat(2) {
                            destinationProxy.enqueue(
                                MockResponse()
                                    .setResponseCode(407)
                                    .setHeader(
                                        "Proxy-Authenticate",
                                        "Basic realm=\"destination proxy\"",
                                    )
                            )
                            destinationProxy.enqueue(
                                MockResponse().setHeader("Cache-Control", "no-store").setBody("ok")
                            )
                        }
                        initialProxy.start()
                        destinationProxy.start()
                        val native =
                            okhttp3.OkHttpClient.Builder()
                                .callTimeout(5, TimeUnit.SECONDS)
                                .cache(
                                    okhttp3.Cache(
                                        directory.resolve("cache-$async").toFile(),
                                        1024 * 1024,
                                    )
                                )
                                .proxySelector(
                                    object : ProxySelector() {
                                        override fun select(uri: URI): List<Proxy> =
                                            listOf(
                                                if (uri.host == "origin.test")
                                                    initialProxy.toProxyAddress()
                                                else destinationProxy.toProxyAddress()
                                            )

                                        override fun connectFailed(
                                            uri: URI,
                                            address: SocketAddress,
                                            failure: IOException,
                                        ) = Unit
                                    }
                                )
                                .proxyAuthenticator { _, response ->
                                    if (response.request.header("Proxy-Authorization") != null) null
                                    else
                                        response.request
                                            .newBuilder()
                                            .header(
                                                "Proxy-Authorization",
                                                "Basic synthetic-destination-credential",
                                            )
                                            .build()
                                }
                                .build()
                        native.useTestClient {
                            OkHttpClient.borrow(native, emptyList()).use { client ->
                                repeat(2) {
                                    val request =
                                        HttpRequest.builder()
                                            .method(HttpMethod.GET)
                                            .baseUrl("http://origin.test/resource")
                                            .putHeader(
                                                "Proxy-Authorization",
                                                "Basic synthetic-proxy-credential",
                                            )
                                            .build()
                                    val response =
                                        if (async)
                                            client.executeAsync(request).get(5, TimeUnit.SECONDS)
                                        else client.execute(request)
                                    response.use { assertThat(it.statusCode()).isEqualTo(200) }
                                }
                            }
                            assertThat(initialProxy.requestCount).isEqualTo(1)
                            assertThat(
                                    initialProxy
                                        .takeRequest(5, TimeUnit.SECONDS)!!
                                        .getHeader("Proxy-Authorization")
                                )
                                .isEqualTo("Basic synthetic-proxy-credential")
                            repeat(2) {
                                assertThat(
                                        destinationProxy
                                            .takeRequest(5, TimeUnit.SECONDS)!!
                                            .getHeader("Proxy-Authorization")
                                    )
                                    .isNull()
                                assertThat(
                                        destinationProxy
                                            .takeRequest(5, TimeUnit.SECONDS)!!
                                            .getHeader("Proxy-Authorization")
                                    )
                                    .isEqualTo("Basic synthetic-destination-credential")
                            }
                        }
                    }
                }
            }
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
