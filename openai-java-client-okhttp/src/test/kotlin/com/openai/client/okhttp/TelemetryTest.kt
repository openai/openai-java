package com.openai.client.okhttp

import com.openai.azure.AzureUrlPathMode
import com.openai.azure.credential.AzureApiKeyCredential
import com.openai.client.OpenAIClient
import com.openai.core.RequestOptions
import com.openai.models.responses.ResponseCreateParams
import java.time.Duration
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test

internal class TelemetryTest {
    @Test
    fun telemetryContractInIsolatedJvm() {
        val loaderClasspath =
            generateSequence(javaClass.classLoader) { it.parent }
                .filterIsInstance<java.net.URLClassLoader>()
                .flatMap { it.urLs.asSequence() }
                .map { java.nio.file.Paths.get(it.toURI()).toString() }
                .joinToString(java.io.File.pathSeparator)
        val classpath =
            System.getProperty("java.class.path") + java.io.File.pathSeparator + loaderClasspath
        val output = java.nio.file.Files.createTempFile("telemetry-probe", ".log")
        try {
            val process =
                ProcessBuilder(
                        java.nio.file.Paths.get(System.getProperty("java.home"), "bin", "java")
                            .toString(),
                        "-Xmx256m",
                        "-cp",
                        classpath,
                        javaClass.name,
                    )
                    .redirectErrorStream(true)
                    .redirectOutput(output.toFile())
                    .start()
            try {
                assertThat(process.waitFor(90, TimeUnit.SECONDS)).isTrue()
                assertThat(process.exitValue())
                    .withFailMessage(
                        String(java.nio.file.Files.readAllBytes(output), Charsets.UTF_8)
                    )
                    .isZero()
            } finally {
                if (process.isAlive) process.destroyForcibly()
            }
        } finally {
            java.nio.file.Files.deleteIfExists(output)
        }
    }

    fun propertyAndExplicitOverrideApplyToEveryAttempt() =
        listOf(false, true).flatMap { async ->
            listOf(null, "true", "false").flatMap { property ->
                listOf(null, true, false).flatMap { override ->
                    listOf(false, true).map { azure ->
                        dynamicTest(
                            "async=$async property=$property override=$override azure=$azure"
                        ) {
                            withProperty(property) {
                                MockWebServer().use { server ->
                                    server.start()
                                    client(server, async, override, azure).useClient { client ->
                                        server.enqueue(
                                            MockResponse()
                                                .setResponseCode(500)
                                                .setHeader("retry-after-ms", "1")
                                        )
                                        server.enqueue(response())
                                        request(client, async)
                                        val disabled = override ?: (property == "true")
                                        repeat(2) { attempt ->
                                            val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                                            assertTelemetry(request, disabled, attempt)
                                            if (azure) {
                                                assertThat(request.getHeader("api-key"))
                                                    .isEqualTo("test-key")
                                                assertThat(
                                                        request.requestUrl!!.queryParameter(
                                                            "api-version"
                                                        )
                                                    )
                                                    .isNotBlank()
                                            } else {
                                                assertThat(request.getHeader("Authorization"))
                                                    .isEqualTo("Bearer test-key")
                                            }
                                            assertThat(request.getHeader("OpenAI-Organization"))
                                                .isEqualTo("test-org")
                                            assertThat(request.getHeader("OpenAI-Project"))
                                                .isEqualTo("test-project")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    fun clonesCanToggleTelemetryWithoutChangingOriginalOrCallerHeaders() =
        listOf(false, true).map { async ->
            dynamicTest("async=$async") {
                withProperty("false") {
                    MockWebServer().use { server ->
                        server.start()
                        client(server, async, null, false).useClient { original ->
                            // A later global change affects new clients, not existing clients or
                            // clones.
                            System.setProperty(PROPERTY, "true")
                            val disabled = original.withOptions { it.disableTelemetry(true) }
                            val unchanged = original.withOptions { it.maxRetries(0) }
                            val enabled = disabled.withOptions { it.disableTelemetry(false) }
                            for ((client, off) in
                                listOf(
                                    original to false,
                                    disabled to true,
                                    unchanged to false,
                                    enabled to false,
                                )) {
                                server.enqueue(response())
                                request(client, async)
                                assertTelemetry(server.takeRequest(5, TimeUnit.SECONDS)!!, off)
                            }
                            // Services clone options that already contain a generated User-Agent.
                            server.enqueue(response())
                            val params =
                                ResponseCreateParams.builder()
                                    .model("test-model")
                                    .input("test")
                                    .build()
                            if (async) {
                                original
                                    .async()
                                    .responses()
                                    .withOptions { it.disableTelemetry(true) }
                                    .create(params)
                                    .get(5, TimeUnit.SECONDS)
                            } else {
                                original
                                    .responses()
                                    .withOptions { it.disableTelemetry(true) }
                                    .create(params)
                            }
                            assertTelemetry(server.takeRequest(5, TimeUnit.SECONDS)!!, true)

                            val custom =
                                disabled
                                    .withOptions {
                                        it.putHeader("x-StAiNlEsS-LaNg", "caller")
                                            .putHeader("X-Stainless-Retry-Count", "caller")
                                            .putHeader("X-Stainless-Read-Timeout", "caller")
                                            .putHeader("X-Stainless-Timeout", "caller")
                                            .putHeader("user-agent", "caller")
                                    }
                                    .withOptions { it.maxRetries(0) }
                            server.enqueue(response())
                            request(custom, async)
                            val captured = server.takeRequest(5, TimeUnit.SECONDS)!!
                            for (name in
                                listOf(
                                    "X-Stainless-Lang",
                                    "X-Stainless-Retry-Count",
                                    "X-Stainless-Read-Timeout",
                                    "X-Stainless-Timeout",
                                    "User-Agent",
                                )) {
                                assertThat(captured.getHeader(name)).isEqualTo("caller")
                            }
                        }
                    }
                }
            }
        }

    fun propertyIsReadAtBuildTimeAndNewClientsObserveChanges() {
        withProperty("false") {
            MockWebServer().use { server ->
                server.start()
                val builder =
                    OpenAIOkHttpClient.builder()
                        .apiKey("test-key")
                        .baseUrl(server.url("/").toString())
                System.setProperty(PROPERTY, "true")
                builder.build().useClient { disabled ->
                    System.setProperty(PROPERTY, "false")
                    server.enqueue(response())
                    request(disabled, false)
                    assertTelemetry(server.takeRequest(5, TimeUnit.SECONDS)!!, true)
                    builder.build().useClient { enabled ->
                        server.enqueue(response())
                        request(enabled, false)
                        assertTelemetry(server.takeRequest(5, TimeUnit.SECONDS)!!, false)
                    }
                }
            }
        }
    }

    fun websocketClonesHonorTelemetryPolicy() =
        listOf(false, true).map { async ->
            dynamicTest("async=$async") {
                withProperty("false") {
                    MockWebServer().use { server ->
                        server.start()
                        client(server, async, false, false).useClient { original ->
                            server.enqueue(
                                MockResponse()
                                    .withWebSocketUpgrade(object : okhttp3.WebSocketListener() {})
                            )
                            val disabled = original.withOptions { it.disableTelemetry(true) }
                            if (async)
                                disabled
                                    .async()
                                    .responses()
                                    .connect()
                                    .get(5, TimeUnit.SECONDS)
                                    .close()
                            else disabled.responses().connect().close()
                            val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                            assertTelemetry(request, true)
                            assertThat(request.getHeader("Authorization"))
                                .isEqualTo("Bearer test-key")
                        }
                    }
                }
            }
        }

    private fun serviceOptionsCanRemoveGeneratedStainlessHeader() {
        withProperty("false") {
            MockWebServer().use { server ->
                server.start()
                client(server, false, false, false).useClient { client ->
                    server.enqueue(response())
                    client
                        .responses()
                        .withOptions { it.removeHeaders("x-StAiNlEsS-lAnG") }
                        .withOptions { it.maxRetries(0) }
                        .create(
                            ResponseCreateParams.builder().model("test-model").input("test").build()
                        )
                    val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                    assertThat(request.getHeader("X-Stainless-Lang")).isNull()
                    assertThat(request.getHeader("X-Stainless-Runtime")).isEqualTo("JRE")
                    assertThat(request.getHeader("Authorization")).isEqualTo("Bearer test-key")
                }
            }
        }
    }

    private fun serviceOptionsCanRemoveGeneratedUserAgent() {
        withProperty("false") {
            MockWebServer().use { server ->
                server.start()
                client(server, false, false, false).useClient { client ->
                    val edits: List<(com.openai.core.ClientOptions.Builder) -> Unit> =
                        listOf(
                            { it.removeHeaders("uSeR-aGeNt") },
                            { it.replaceHeaders("uSeR-aGeNt", emptyList()) },
                            { it.replaceAllHeaders(mapOf("uSeR-aGeNt" to emptyList())) },
                            { it.headers(emptyMap()) },
                            { it.headers(com.openai.core.http.Headers.builder().build()) },
                        )
                    for (edit in edits) {
                        server.enqueue(response())
                        client
                            .responses()
                            .withOptions(edit)
                            .create(
                                ResponseCreateParams.builder()
                                    .model("test-model")
                                    .input("test")
                                    .build()
                            )
                        assertThat(
                                server
                                    .takeRequest(5, TimeUnit.SECONDS)!!
                                    .getHeader("User-Agent")
                                    .orEmpty()
                            )
                            .doesNotContain("OpenAIClient")
                    }
                }
            }
        }
    }

    private fun OpenAIClient.useClient(block: (OpenAIClient) -> Unit) {
        try {
            block(this)
        } finally {
            close()
        }
    }

    private fun client(
        server: MockWebServer,
        async: Boolean,
        override: Boolean?,
        azure: Boolean,
    ): OpenAIClient {
        val baseUrl = server.url("/").toString()
        return if (async) {
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(baseUrl)
                .organization("test-org")
                .project("test-project")
                .apply {
                    if (azure) credential(AzureApiKeyCredential.create("test-key"))
                    else apiKey("test-key")
                    override?.let { disableTelemetry(it) }
                }
                .build()
                .sync()
                .withOptions { if (azure) it.azureUrlPathMode(AzureUrlPathMode.LEGACY) }
        } else {
            OpenAIOkHttpClient.builder()
                .baseUrl(baseUrl)
                .organization("test-org")
                .project("test-project")
                .apply {
                    if (azure)
                        credential(AzureApiKeyCredential.create("test-key"))
                            .azureUrlPathMode(AzureUrlPathMode.LEGACY)
                    else apiKey("test-key")
                    override?.let { disableTelemetry(it) }
                }
                .build()
        }
    }

    private fun request(client: OpenAIClient, async: Boolean) {
        val params = ResponseCreateParams.builder().model("test-model").input("test").build()
        val options = RequestOptions.builder().timeout(Duration.ofSeconds(4)).build()
        if (async) client.async().responses().create(params, options).get(5, TimeUnit.SECONDS)
        else client.responses().create(params, options)
    }

    private fun assertTelemetry(request: RecordedRequest, disabled: Boolean, attempt: Int = 0) {
        val telemetry =
            request.headers.names().filter { it.startsWith("X-Stainless-", ignoreCase = true) }
        if (disabled) {
            assertThat(telemetry).isEmpty()
            // OkHttp may supply its own transport User-Agent; the SDK must not supply its identity.
            assertThat(request.getHeader("User-Agent").orEmpty()).doesNotContain("OpenAIClient")
        } else {
            assertThat(telemetry).hasSize(11)
            assertThat(request.getHeader("X-Stainless-Lang")).isEqualTo("java")
            assertThat(request.getHeader("X-Stainless-Retry-Count")).isEqualTo(attempt.toString())
            assertThat(request.getHeader("X-Stainless-Timeout")).isEqualTo("4")
            assertThat(request.getHeader("User-Agent")).contains("OpenAIClient")
        }
    }

    private fun response() =
        MockResponse().setHeader("Content-Type", "application/json").setBody("{}")

    private fun withProperty(value: String?, block: () -> Unit) {
        val previous = System.getProperty(PROPERTY)
        try {
            if (value == null) System.clearProperty(PROPERTY)
            else System.setProperty(PROPERTY, value)
            block()
        } finally {
            if (previous == null) System.clearProperty(PROPERTY)
            else System.setProperty(PROPERTY, previous)
        }
    }

    companion object {
        private const val PROPERTY = "openai.disableTelemetry"

        @JvmStatic
        fun main(args: Array<String>) {
            val test = TelemetryTest()
            val cases =
                test.propertyAndExplicitOverrideApplyToEveryAttempt() +
                    test.clonesCanToggleTelemetryWithoutChangingOriginalOrCallerHeaders() +
                    test.websocketClonesHonorTelemetryPolicy()
            for (case in cases) {
                println(case.displayName)
                case.executable.execute()
            }
            test.propertyIsReadAtBuildTimeAndNewClientsObserveChanges()
            test.serviceOptionsCanRemoveGeneratedUserAgent()
            test.serviceOptionsCanRemoveGeneratedStainlessHeader()
        }
    }
}
