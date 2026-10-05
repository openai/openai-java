package com.openai.client.okhttp

import com.openai.core.http.ResponseWebSocketOptions
import com.openai.core.http.WebSocketHandshakeException
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsesClientEvent
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.ServerSocket
import java.net.Socket
import java.time.Duration
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.SocketPolicy
import okhttp3.tls.HandshakeCertificates
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(30)
internal class X509WebSocketTest {
    @Test
    fun `sync and async public clients use the attested identity and custom headers`() {
        for (async in listOf(false, true)) for (host in
            listOf(API_HOST, "mtls-eu.api.openai.com")) {
            Harness(host).use { h ->
                h.auth.enqueue(token("test-access-token"))
                val closed = CountDownLatch(1)
                h.api.enqueue(upgrade(closed))
                h.client().useClient { client ->
                    val options =
                        ResponseWebSocketOptions.builder().putHeader("X-Test", "custom").build()
                    if (async) {
                        client.async().responses().connect(options).get(5, TimeUnit.SECONDS).use {
                            it.send(command())
                            assertThat(it.finalResponse().get(5, TimeUnit.SECONDS).id())
                                .isEqualTo("resp_test")
                        }
                    } else {
                        client.responses().connect(options).use {
                            it.send(command())
                            assertThat(it.finalResponse().id()).isEqualTo("resp_test")
                        }
                    }
                    assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
                    assertThat(h.auth.takeRequest().requestLine)
                        .startsWith("CONNECT mtls.auth.openai.com:443 ")
                    val auth = h.auth.takeRequest()
                    val api = h.api.takeRequest()
                    assertThat(auth.handshake!!.peerCertificates.first())
                        .isEqualTo(h.identity.leaf.certificate)
                    assertThat(api.handshake!!.peerCertificates.first())
                        .isEqualTo(h.identity.leaf.certificate)
                    assertThat(api.path).isEqualTo("/v1/responses")
                    assertThat(api.getHeader("Authorization")).isEqualTo("Bearer test-access-token")
                    assertThat(api.getHeader("X-Test")).isEqualTo("custom")
                    assertThat(h.api.requestedServerNames).contains(host)
                    assertThat(h.auth.requestedServerNames).contains("mtls.auth.openai.com")
                }
            }
        }
    }

    @Test
    fun `a rejected handshake invalidates only its bearer and does not retry the upgrade`() {
        Harness().use { h ->
            h.auth.enqueue(token("test-rejected-token"))
            h.auth.server.enqueue(token("test-fresh-token"))
            h.api.enqueue(MockResponse().setResponseCode(401))
            h.api.enqueue(upgrade())
            h.client().useClient { client ->
                assertThatThrownBy { client.responses().connect() }
                    .isInstanceOf(WebSocketHandshakeException::class.java)
                assertThat(h.api.server.requestCount).isEqualTo(1)
                client.responses().connect().use {
                    it.send(command())
                    assertThat(it.finalResponse().id()).isEqualTo("resp_test")
                }
                assertThat(h.api.takeRequest().getHeader("Authorization"))
                    .isEqualTo("Bearer test-rejected-token")
                assertThat(h.api.takeRequest().getHeader("Authorization"))
                    .isEqualTo("Bearer test-fresh-token")
                assertThat(h.auth.server.requestCount).isEqualTo(3) // CONNECT and two exchanges.
            }
        }
    }

    @Test
    fun `cloned client cannot obtain credentials for an unauthorized origin`() {
        Harness().use { h ->
            h.client().useClient { client ->
                for (url in
                    listOf(
                        "https://example.invalid/v1",
                        "http://$API_HOST/v1",
                        "https://$API_HOST:444/v1",
                        "https://user@$API_HOST/v1",
                    )) {
                    val changed = client.withOptions { it.baseUrl(url) }
                    assertThatThrownBy { changed.responses().connect() }
                        .hasMessageContaining("not authorized")
                }
                assertThat(h.auth.server.requestCount).isZero()
                assertThat(h.api.server.requestCount).isZero()
            }
        }
    }

    @Test
    fun `replacement transport cannot obtain the bound bearer`() {
        Harness().use { h ->
            val requests =
                java.util.concurrent.LinkedBlockingQueue<com.openai.core.http.HttpRequest>()
            val replacement =
                object : com.openai.core.http.HttpClient, com.openai.core.http.WebSocketClient {
                    override fun execute(
                        request: com.openai.core.http.HttpRequest,
                        requestOptions: com.openai.core.RequestOptions,
                    ): com.openai.core.http.HttpResponse = error("Unexpected HTTP request")

                    override fun executeAsync(
                        request: com.openai.core.http.HttpRequest,
                        requestOptions: com.openai.core.RequestOptions,
                    ): java.util.concurrent.CompletableFuture<com.openai.core.http.HttpResponse> =
                        error("Unexpected HTTP request")

                    override fun close() {}

                    override fun connectWebSocket(
                        request: com.openai.core.http.HttpRequest,
                        options: com.openai.core.RequestOptions,
                        maxMessageBytes: Int,
                        listener: com.openai.core.http.WebSocketClient.Listener,
                    ): java.util.concurrent.CompletableFuture<
                        com.openai.core.http.WebSocketClient.Connection
                    > {
                        requests.add(request)
                        return java.util.concurrent
                            .CompletableFuture<com.openai.core.http.WebSocketClient.Connection>()
                            .apply {
                                completeExceptionally(IllegalStateException("test transport"))
                            }
                    }
                }
            h.client().useClient { client ->
                val changed = client.withOptions { it.httpClient(replacement) }
                assertThatThrownBy { changed.responses().connect() }
                    .hasMessageContaining("test transport")
                assertThat(requests.remove().headers.values("Authorization")).isEmpty()
                assertThat(h.auth.server.requestCount).isZero()
            }
        }
    }

    @Test
    fun `redirected upgrades are not followed`() {
        Harness().use { h ->
            h.auth.enqueue(token("test-access-token"))
            h.api.enqueue(
                MockResponse()
                    .setResponseCode(307)
                    .setHeader("Location", "https://example.invalid/v1/responses")
            )
            h.client().useClient { client ->
                assertThatThrownBy { client.responses().connect() }
                    .isInstanceOf(WebSocketHandshakeException::class.java)
                    .hasMessageContaining("307")
                assertThat(h.api.server.requestCount).isEqualTo(1)
            }
        }
    }

    @Test
    fun `canceling one exchange waiter does not open its socket or cancel another waiter`() {
        Harness().use { h ->
            val release = CountDownLatch(1)
            h.auth.enqueue(token("test-access-token"))
            val exchangeDispatcher = h.auth.server.dispatcher
            h.auth.server.dispatcher =
                object : okhttp3.mockwebserver.Dispatcher() {
                    override fun peek() = exchangeDispatcher.peek()

                    override fun dispatch(
                        request: okhttp3.mockwebserver.RecordedRequest
                    ): MockResponse {
                        if (request.method != "CONNECT") check(release.await(5, TimeUnit.SECONDS))
                        return exchangeDispatcher.dispatch(request)
                    }
                }
            h.api.enqueue(upgrade())
            h.client().useClient { client ->
                val canceled = client.async().responses().connect()
                h.auth.takeRequest()
                h.auth.takeRequest()
                val survivor = client.async().responses().connect()
                assertThat(canceled.cancel(true)).isTrue()
                release.countDown()
                survivor.get(5, TimeUnit.SECONDS).use {
                    it.send(command())
                    assertThat(it.finalResponse().get(5, TimeUnit.SECONDS).id())
                        .isEqualTo("resp_test")
                }
                assertThat(h.auth.server.requestCount).isEqualTo(2)
                assertThat(h.api.server.requestCount).isEqualTo(1)
            }
        }
    }

    @Test
    fun `closing the client cancels an in-flight exchange without opening an API socket`() {
        Harness().use { h ->
            h.auth.enqueue(MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE))
            val client = h.client()
            val opening = client.async().responses().connect()
            h.auth.takeRequest()
            h.auth.takeRequest()
            client.close()
            assertThatThrownBy { opening.get(1, TimeUnit.SECONDS) }
                .isNotInstanceOf(java.util.concurrent.TimeoutException::class.java)
            assertThat(h.api.server.requestCount).isZero()
        }
    }

    @Test
    fun `late rejection of an old bearer does not invalidate a refreshed token`() {
        Harness().use { h ->
            h.auth.enqueue(token("test-old-token"))
            h.auth.server.enqueue(token("test-new-token"))
            val first = CountDownLatch(1)
            val release = CountDownLatch(1)
            val attempts = java.util.concurrent.atomic.AtomicInteger()
            h.api.server.dispatcher =
                object : okhttp3.mockwebserver.Dispatcher() {
                    override fun dispatch(
                        request: okhttp3.mockwebserver.RecordedRequest
                    ): MockResponse {
                        return when (attempts.incrementAndGet()) {
                            1 -> {
                                first.countDown()
                                check(release.await(5, TimeUnit.SECONDS))
                                MockResponse().setResponseCode(401)
                            }
                            2 -> MockResponse().setResponseCode(401)
                            else -> upgrade()
                        }
                    }
                }
            h.client().useClient { client ->
                val stale = client.async().responses().connect()
                assertThat(first.await(5, TimeUnit.SECONDS)).isTrue()
                assertThatThrownBy { client.responses().connect() }
                    .isInstanceOf(WebSocketHandshakeException::class.java)
                client.responses().connect().use {
                    it.send(command())
                    it.finalResponse()
                }
                release.countDown()
                assertThatThrownBy { stale.get(5, TimeUnit.SECONDS) }
                    .hasCauseInstanceOf(WebSocketHandshakeException::class.java)
                client.responses().connect().use {
                    it.send(command())
                    it.finalResponse()
                }
                assertThat(h.auth.server.requestCount).isEqualTo(3)
                val headers = (1..4).map { h.api.takeRequest().getHeader("Authorization") }
                assertThat(headers)
                    .containsExactly(
                        "Bearer test-old-token",
                        "Bearer test-old-token",
                        "Bearer test-new-token",
                        "Bearer test-new-token",
                    )
            }
        }
    }

    @Test
    fun `canceling or closing an opening connection releases the TLS socket`() {
        for (closeClient in listOf(false, true)) {
            Harness().use { h ->
                h.auth.enqueue(token("test-access-token"))
                h.api.enqueue(MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE))
                h.client().useClient { client ->
                    val opening = client.async().responses().connect()
                    h.api.takeRequest()
                    if (closeClient) client.close() else assertThat(opening.cancel(true)).isTrue()
                    assertThatThrownBy { opening.get(1, TimeUnit.SECONDS) }
                        .isNotInstanceOf(java.util.concurrent.TimeoutException::class.java)
                    assertThat(h.relay.disconnected.await(1, TimeUnit.SECONDS)).isTrue()
                }
            }
        }
    }

    @Test
    fun `API TLS rejects an untrusted certificate and an incorrect hostname before headers`() {
        for (wrongHost in listOf(false, true)) {
            Harness(peerHost = if (wrongHost) "wrong.invalid" else API_HOST, trustApi = wrongHost)
                .use { h ->
                    h.auth.enqueue(token("test-access-token"))
                    h.api.enqueue(upgrade())
                    h.client().useClient { client ->
                        assertThatThrownBy { client.responses().connect() }
                            .isInstanceOf(Exception::class.java)
                        assertThat(h.api.server.requestCount).isZero()
                    }
                }
        }
    }

    private inline fun <T> com.openai.client.OpenAIClient.useClient(
        block: (com.openai.client.OpenAIClient) -> T
    ): T =
        try {
            block(this)
        } finally {
            close()
        }

    private class Harness(
        val host: String = API_HOST,
        peerHost: String = host,
        val trustApi: Boolean = true,
    ) : AutoCloseable {
        val identity = X509TestIdentity.create("WebSocket identity")
        val auth = X509TestPeer("mtls.auth.openai.com", identity.root.certificate)
        val api = X509TestPeer(peerHost, identity.root.certificate, tunnelProxy = false)
        val relay = SocksRelay(api.server.port)

        fun client() =
            OpenAIOkHttpClient.builder()
                .baseUrl("https://$host/v1")
                .x509WorkloadIdentity(
                    X509WorkloadIdentity.builder()
                        .identityProviderId("test-provider")
                        .serviceAccountId("test-account")
                        .transport(
                            X509Transport.builder()
                                .keyManager(x509TestKeyManager(mapOf("identity" to identity)))
                                .certificateAlias("identity")
                                .trustManager(
                                    HandshakeCertificates.Builder()
                                        .addTrustedCertificate(auth.serverRootCertificate)
                                        .apply {
                                            if (trustApi)
                                                addTrustedCertificate(api.serverRootCertificate)
                                        }
                                        .build()
                                        .trustManager
                                )
                                .build()
                        )
                        .build()
                        .withTestProxies(auth.proxy, relay.proxy)
                )
                .timeout(Duration.ofSeconds(5))
                .build()

        override fun close() {
            relay.close()
            api.close()
            auth.close()
        }
    }

    /** Routes sockets to loopback without changing the TLS hostname or client identity. */
    private class SocksRelay(private val targetPort: Int) : AutoCloseable {
        val disconnected = CountDownLatch(1)
        private val server = ServerSocket(0)
        private val sockets = ConcurrentHashMap.newKeySet<Socket>()
        private val executor = Executors.newCachedThreadPool()
        val proxy = Proxy(Proxy.Type.SOCKS, InetSocketAddress("127.0.0.1", server.localPort))

        init {
            executor.submit {
                while (!server.isClosed) {
                    val incoming =
                        try {
                            server.accept()
                        } catch (_: java.net.SocketException) {
                            break
                        }
                    sockets.add(incoming)
                    executor.submit {
                        incoming.use {
                            val input = DataInputStream(incoming.getInputStream())
                            val output = DataOutputStream(incoming.getOutputStream())
                            check(input.readUnsignedByte() == 5)
                            input.readFully(ByteArray(input.readUnsignedByte()))
                            output.write(byteArrayOf(5, 0))
                            output.flush()
                            check(
                                input.readUnsignedByte() == 5 &&
                                    input.readUnsignedByte() == 1 &&
                                    input.readUnsignedByte() == 0
                            )
                            val size =
                                when (input.readUnsignedByte()) {
                                    1 -> 4
                                    3 -> input.readUnsignedByte()
                                    4 -> 16
                                    else -> error("Invalid SOCKS address")
                                }
                            input.readFully(ByteArray(size))
                            check(input.readUnsignedShort() == 443)
                            Socket("127.0.0.1", targetPort).use { upstream ->
                                sockets.add(upstream)
                                output.write(byteArrayOf(5, 0, 0, 1, 127, 0, 0, 1, 0, 0))
                                output.flush()
                                val upload =
                                    executor.submit {
                                        try {
                                            input.copyTo(upstream.getOutputStream())
                                            upstream.shutdownOutput()
                                        } finally {
                                            disconnected.countDown()
                                        }
                                    }
                                upstream.getInputStream().copyTo(output)
                                upload.get(5, TimeUnit.SECONDS)
                                sockets.remove(upstream)
                            }
                        }
                        sockets.remove(incoming)
                    }
                }
            }
        }

        override fun close() {
            server.close()
            sockets.forEach { it.close() }
            executor.shutdownNow()
            check(executor.awaitTermination(5, TimeUnit.SECONDS))
        }
    }

    companion object {
        private const val API_HOST = "mtls.api.openai.com"

        private fun token(value: String) =
            MockResponse()
                .setHeader("Content-Type", "application/json")
                .setBody(
                    """{"access_token":"$value","token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","expires_in":3600}"""
                )

        private fun command() =
            jsonMapper()
                .readValue(
                    """{"type":"response.create","model":"gpt-4o-mini","input":"hello"}""",
                    ResponsesClientEvent::class.java,
                )

        private fun upgrade(closed: CountDownLatch = CountDownLatch(0)) =
            MockResponse()
                .withWebSocketUpgrade(
                    object : WebSocketListener() {
                        override fun onMessage(webSocket: WebSocket, text: String) {
                            assertThat(jsonMapper().readTree(text)["type"].asText())
                                .isEqualTo("response.create")
                            webSocket.send(
                                """{"type":"response.completed","sequence_number":1,"response":{"id":"resp_test","created_at":0,"object":"response","model":"gpt-4o-mini","output":[],"parallel_tool_calls":false,"tool_choice":"auto","tools":[],"status":"completed"}}"""
                            )
                        }

                        override fun onFailure(
                            webSocket: WebSocket,
                            t: Throwable,
                            response: Response?,
                        ) {
                            closed.countDown()
                        }

                        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                            closed.countDown()
                        }
                    }
                )
    }
}
