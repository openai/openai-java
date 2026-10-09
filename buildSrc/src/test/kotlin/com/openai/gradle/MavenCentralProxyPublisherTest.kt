package com.openai.gradle

import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodySubscribers
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.Flow
import java.util.concurrent.TimeUnit
import java.util.zip.ZipFile
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import org.gradle.api.GradleException
import org.junit.jupiter.api.io.TempDir

class MavenCentralProxyPublisherTest {
    @TempDir lateinit var temporary: Path
    private val deployment = "11111111-1111-4111-8111-111111111111"
    private val environment =
        mapOf(
            "MAVEN_CENTRAL_AUTH_PROXY_URL" to "https://proxy.example.invalid",
            "MAVEN_CENTRAL_AUTH_PROXY_TOKEN" to "fake-entra",
            "MAVEN_CENTRAL_AUTH_PROXY_TOKEN_EXPIRES_AT" to Long.MAX_VALUE.toString(),
        )

    private fun body(publisher: HttpRequest.BodyPublisher): String {
        val subscriber = BodySubscribers.ofByteArray()
        publisher.subscribe(
            object : Flow.Subscriber<ByteBuffer> {
                override fun onSubscribe(subscription: Flow.Subscription) =
                    subscriber.onSubscribe(subscription)

                override fun onNext(item: ByteBuffer) = subscriber.onNext(listOf(item))

                override fun onError(error: Throwable) = subscriber.onError(error)

                override fun onComplete() = subscriber.onComplete()
            }
        )
        return String(subscriber.body.toCompletableFuture().get(5, TimeUnit.SECONDS))
    }

    private fun client(
        receipts: MutableList<String> = mutableListOf(),
        clock: () -> Long = { 0 },
        central: (URI, HttpRequest.BodyPublisher?) -> String,
    ) =
        MavenCentralProxyPublisher(
            environment,
            { uri, token, data, _ ->
                assertEquals("fake-entra", token)
                central(uri, data)
            },
            receipts::add,
            clock,
            {},
        )

    private fun archive() =
        temporary.resolve("bundle.zip").also { Files.writeString(it, "ZIP-CONTENT") }

    @Test
    fun `upload is streamed once and validated before publishing`() {
        val states = listOf("VALIDATING", "VALIDATED", "PUBLISHING", "PUBLISHED").iterator()
        val calls = mutableListOf<String>()
        val receipts = mutableListOf<String>()
        client(receipts) { uri, data ->
                calls.add(uri.path)
                when {
                    uri.path.endsWith("/upload") -> {
                        assertEquals("publishingType=USER_MANAGED", uri.query)
                        val content = body(requireNotNull(data))
                        assertEquals(content.toByteArray().size.toLong(), data.contentLength())
                        assertContains(content, "ZIP-CONTENT")
                        deployment
                    }
                    uri.path.endsWith("/status") -> """{"deploymentState":"${states.next()}"}"""
                    else -> ""
                }
            }
            .publish(archive())
        assertEquals(1, calls.count { it.endsWith("/upload") })
        assertEquals(1, calls.count { "/deployment/" in it })
        assertContains(receipts, "Maven Central deployment ID: $deployment")
    }

    @Test
    fun `unknown upload outcome is sanitized and never retried`() {
        var calls = 0
        val publisher = client { _, _ ->
            calls++
            error("fake-secret")
        }
        val error = assertFailsWith<GradleException> { publisher.publish(archive()) }
        assertContains(error.message.orEmpty(), "outcome unknown")
        assertFalse(error.toString().contains("fake-secret"))
        assertEquals(null, error.cause)
        assertEquals(1, calls)
    }

    @Test
    fun `failed validation does not publish`() {
        val calls = mutableListOf<String>()
        val publisher = client { uri, _ ->
            calls.add(uri.path)
            if (uri.path.endsWith("/upload")) deployment else """{"deploymentState":"FAILED"}"""
        }
        assertFailsWith<GradleException> { publisher.publish(archive()) }
        assertEquals(2, calls.size)
        assertFalse(calls.any { "/deployment/" in it })
    }

    @Test
    fun `poll timeout retains receipt without reuploading`() {
        var now = 0L
        val receipts = mutableListOf<String>()
        var uploads = 0
        val publisher =
            client(receipts, { now.also { now += 1000 } }) { _, _ ->
                uploads++
                deployment
            }
        assertFailsWith<GradleException> { publisher.publish(archive()) }
        assertEquals(1, uploads)
        assertContains(receipts, "Maven Central deployment ID: $deployment")
    }

    @Test
    fun `proxy origin must be HTTPS without path query userinfo or fragment`() {
        listOf(
                "http://proxy.invalid",
                "https://user:pass@proxy.invalid",
                "https://proxy.invalid/path",
                "https://proxy.invalid?query",
                "https://proxy.invalid#fragment",
            )
            .forEach { url ->
                val publisher =
                    MavenCentralProxyPublisher(
                        environment + ("MAVEN_CENTRAL_AUTH_PROXY_URL" to url),
                        { _, _, _, _ -> error("must not request") },
                        {},
                    )
                assertFails { publisher.publish(archive()) }
            }
    }

    @Test
    fun `Azure token must have enough lifetime and no header whitespace`() {
        val publisher =
            MavenCentralProxyPublisher(
                environment + ("MAVEN_CENTRAL_AUTH_PROXY_TOKEN_EXPIRES_AT" to "1100"),
                epochSeconds = { 1000 },
            )
        assertEquals("fake-entra", publisher.token())
        assertFailsWith<GradleException> { publisher.token(1200) }
        for (value in listOf("", "fake\nheader")) {
            val invalid =
                MavenCentralProxyPublisher(
                    environment + ("MAVEN_CENTRAL_AUTH_PROXY_TOKEN" to value)
                )
            assertFailsWith<GradleException> { invalid.token() }
        }
    }

    @Test
    fun `short lived token fails before sending upload`() {
        var requested = false
        val publisher =
            MavenCentralProxyPublisher(
                environment + ("MAVEN_CENTRAL_AUTH_PROXY_TOKEN_EXPIRES_AT" to "1100"),
                { _, _, _, _ ->
                    requested = true
                    ""
                },
                {},
                epochSeconds = { 1000 },
            )
        assertFailsWith<GradleException> { publisher.publish(archive()) }
        assertFalse(requested)
    }

    private fun staged(): Path {
        val staging = temporary.resolve("staging")
        val prefix = staging.resolve("com/openai/openai-java/1.2.3/openai-java-1.2.3")
        Files.createDirectories(prefix.parent)
        listOf(".jar", ".pom", "-sources.jar", "-javadoc.jar").forEach {
            Files.writeString(Path.of("$prefix$it"), "synthetic")
            Files.writeString(Path.of("$prefix$it.asc"), "fake-signature")
        }
        val digest = MavenCentralProxyPublisher.digest(Path.of("$prefix.jar"))
        Files.writeString(
            temporary.resolve("manifest"),
            "$digest  openai-java/build/libs/openai-java-1.2.3.jar\n",
        )
        return staging
    }

    private fun bundle(staging: Path, verify: (Path) -> Boolean = { true }): Path {
        val output = temporary.resolve("output.zip")
        MavenCentralProxyPublisher.bundle(
            staging,
            output,
            "1.2.3",
            listOf("openai-java"),
            temporary.resolve("manifest"),
            verify,
        )
        return output
    }

    @Test
    fun `bundle verifies all signatures and excludes Maven metadata`() {
        val staging = staged()
        Files.writeString(staging.resolve("maven-metadata.xml"), "metadata")
        var verified = 0
        ZipFile(
                bundle(staging) {
                        verified++
                        true
                    }
                    .toFile()
            )
            .use {
                assertEquals(8, it.size())
                assertFalse(it.entries().asSequence().any { entry -> "metadata" in entry.name })
            }
        assertEquals(4, verified)
    }

    @Test
    fun `tampered attested jar and invalid signatures are rejected`() {
        val staging = staged()
        assertFails { bundle(staging) { false } }
        Files.writeString(
            staging.resolve("com/openai/openai-java/1.2.3/openai-java-1.2.3.jar"),
            "tampered",
        )
        assertFails { bundle(staging) }
    }

    @Test
    fun `missing signature corrupt checksum unsigned module and symlink are rejected`() {
        val staging = staged()
        val base = staging.resolve("com/openai/openai-java/1.2.3")
        val signature = base.resolve("openai-java-1.2.3.jar.asc")
        Files.delete(signature)
        assertFails { bundle(staging) }
        Files.writeString(signature, "fake-signature")
        val checksum = base.resolve("openai-java-1.2.3.jar.sha256")
        Files.writeString(checksum, "0".repeat(64))
        assertFails { bundle(staging) }
        Files.delete(checksum)
        val module = base.resolve("openai-java-1.2.3.module")
        Files.writeString(module, "{}")
        assertFails { bundle(staging) }
        Files.delete(module)
        Files.createSymbolicLink(base.resolve("link"), temporary.resolve("manifest"))
        assertFails { bundle(staging) }
    }
}
