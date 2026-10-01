package com.openai.helpers.beta.agents

import com.openai.core.http.*
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.beta.agents.AgentTurnResult
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AgentArtifactDownloadsTest {
    @TempDir lateinit var directory: Path
    private val options = fileTestOptions
    private val mapper = jsonMapper()

    private fun artifact(
        id: String,
        turn: String = "root",
        path: String = "/workspace/outputs/report.txt",
    ) = """{"id":"$id","session_id":"s","turn_id":"$turn","path":"$path"}"""

    private fun page(vararg items: String, more: Boolean = false) =
        """{"object":"list","data":[${items.joinToString(",")}],"has_more":$more}"""

    private fun result() =
        AgentTurnResult(
            mapper.readValue(
                """{"id":"root","session_id":"s","status":"completed","subagent_id":null}""",
                Turn::class.java,
            ),
            emptyList(),
        )

    private fun file(name: String = "source.txt", text: String = "source") =
        directory.resolve(name).also { Files.write(it, text.toByteArray()) }

    private inner class Transport : AgentFileTestTransport() {
        var pages = mutableListOf(page(artifact("artifact-one")))
        var contentClosed = false
        val contentClosedSignal = CountDownLatch(1)
        var contentReads = 0
        var contentSize = 64 * 1024
        var onContent: () -> Unit = {}
        var onList: () -> Unit = {}

        override fun respond(request: HttpRequest): HttpResponse {
            val path = request.pathSegments
            return when {
                path.last() == "artifacts" -> {
                    onList()
                    response(if (pages.size > 1) pages.removeAt(0) else pages.single())
                }
                path.last() == "content" -> {
                    onContent()
                    response(
                        object : InputStream() {
                            var remaining = contentSize

                            override fun read(): Int {
                                contentReads++
                                return if (remaining-- > 0) 'x'.code else -1
                            }

                            override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
                                if (remaining == 0) return -1
                                contentReads++
                                val count = minOf(remaining, length, 4096)
                                java.util.Arrays.fill(
                                    buffer,
                                    offset,
                                    offset + count,
                                    'x'.code.toByte(),
                                )
                                remaining -= count
                                return count
                            }

                            override fun close() {
                                contentClosed = true
                                contentClosedSignal.countDown()
                            }
                        }
                    )
                }
                else -> throw AssertionError("Unexpected endpoint")
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `artifact download selects exact turn and path across pages and streams immutable bytes`(
        async: Boolean
    ) {
        val t =
            Transport().apply {
                pages =
                    mutableListOf(
                        page(artifact("old", "old"), more = true),
                        page(artifact("selected")),
                    )
            }
        val client = t.client()
        val destination = directory.resolve("downloaded.txt")
        try {
            val artifact =
                if (async)
                    AgentArtifactDownloads.forResult(
                            client.async().beta().agents().sessions().artifacts(),
                            result(),
                        )
                        .download("/workspace/outputs/report.txt", destination, options)
                        .join()
                else
                    AgentArtifactDownloads.forResult(
                            client.beta().agents().sessions().artifacts(),
                            result(),
                        )
                        .download("/workspace/outputs/report.txt", destination, options)
            assertThat(artifact.id()).isEqualTo("selected")
            assertThat(Files.size(destination)).isEqualTo(t.contentSize.toLong())
            assertThat(t.contentReads).isGreaterThan(1)
            assertThat(t.contentClosed).isTrue()
            assertThat(t.requests.last().pathSegments).contains("selected")
            assertThat(t.requestOptions).allSatisfy {
                assertThat(it.timeout).isEqualTo(options.timeout)
            }
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `content preserves exact scope options and caller ownership`(async: Boolean) {
        val t =
            Transport().apply {
                pages =
                    mutableListOf(
                        page(artifact("old", "old"), more = true),
                        page(artifact("selected")),
                    )
            }
        val client = t.client()
        try {
            val response =
                if (async)
                    AgentArtifactDownloads.forResult(
                            client.async().beta().agents().sessions().artifacts(),
                            result(),
                        )
                        .content("/workspace/outputs/report.txt", options)
                        .join()
                else
                    AgentArtifactDownloads.forResult(
                            client.beta().agents().sessions().artifacts(),
                            result(),
                        )
                        .content("/workspace/outputs/report.txt", options)
            assertThat(t.contentClosed).isFalse()
            assertThat(t.contentReads).isZero()
            response.use {
                val bytes = ByteArrayOutputStream()
                it.body().copyTo(bytes)
                assertThat(bytes.size()).isEqualTo(t.contentSize)
            }
            assertThat(t.contentClosed).isTrue()
            assertThat(t.requests).hasSize(3)
            assertThat(t.requests.last().pathSegments).contains("s", "selected")
            assertThat(t.requestOptions).allSatisfy {
                assertThat(it.timeout).isEqualTo(options.timeout)
            }
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `artifact lookup reports missing and ambiguous matches without touching destination`(
        async: Boolean
    ) {
        for (matches in listOf(page(), page(artifact("one"), artifact("two")))) {
            val t = Transport().apply { pages = mutableListOf(matches) }
            val client = t.client()
            val destination = file("existing.txt", "keep")
            try {
                assertThatThrownBy {
                    if (async)
                        AgentArtifactDownloads.forResult(
                                client.async().beta().agents().sessions().artifacts(),
                                result(),
                            )
                            .download("/workspace/outputs/report.txt", destination)
                            .join()
                    else
                        AgentArtifactDownloads.forResult(
                                client.beta().agents().sessions().artifacts(),
                                result(),
                            )
                            .download("/workspace/outputs/report.txt", destination)
                }
                assertThat(String(Files.readAllBytes(destination))).isEqualTo("keep")
                assertThat(t.requests).noneSatisfy {
                    assertThat(it.pathSegments.last()).isEqualTo("content")
                }
            } finally {
                client.close()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `download closes the response on destination failure`(async: Boolean) {
        val t = Transport()
        val client = t.client()
        try {
            val destination = directory.resolve("missing-parent/report.txt")
            assertThatThrownBy {
                if (async)
                    AgentArtifactDownloads.forResult(
                            client.async().beta().agents().sessions().artifacts(),
                            result(),
                        )
                        .download("/workspace/outputs/report.txt", destination)
                        .join()
                else
                    AgentArtifactDownloads.forResult(
                            client.beta().agents().sessions().artifacts(),
                            result(),
                        )
                        .download("/workspace/outputs/report.txt", destination)
            }
            assertThat(t.contentClosed).isTrue()
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `cancelling native async content closes a late response without writing`(
        inMemory: Boolean
    ) {
        val t = Transport()
        val client = t.client()
        val pending = CompletableFuture<HttpResponse>()
        var request: HttpRequest? = null
        val requested = CountDownLatch(1)
        t.asyncOverride = { candidate, _ ->
            if (candidate.pathSegments.last() == "content") {
                request = candidate
                requested.countDown()
                pending
            } else null
        }
        try {
            val destination = directory.resolve("cancelled.txt")
            val scoped =
                AgentArtifactDownloads.forResult(
                    client.async().beta().agents().sessions().artifacts(),
                    result(),
                )
            val download =
                if (inMemory) scoped.content("/workspace/outputs/report.txt")
                else scoped.download("/workspace/outputs/report.txt", destination)
            assertThat(requested.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(download.cancel(true)).isTrue()
            pending.complete(t.execute(requireNotNull(request), options))
            assertThat(t.contentClosedSignal.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(t.contentClosed).isTrue()
            assertThat(Files.exists(destination)).isFalse()
        } finally {
            client.close()
        }
    }

    @Test
    fun `cancelling async lookup prevents the next page and content request`() {
        val t =
            Transport().apply {
                pages =
                    mutableListOf(
                        page(artifact("old", "old"), more = true),
                        page(artifact("selected")),
                    )
            }
        val client = t.client()
        val pending = CompletableFuture<HttpResponse>()
        var request: HttpRequest? = null
        val requested = CountDownLatch(1)
        t.asyncOverride = { candidate, _ ->
            request = candidate
            requested.countDown()
            pending
        }
        try {
            val download =
                AgentArtifactDownloads.forResult(
                        client.async().beta().agents().sessions().artifacts(),
                        result(),
                    )
                    .download("/workspace/outputs/report.txt", directory.resolve("cancelled.txt"))
            assertThat(requested.await(5, TimeUnit.SECONDS)).isTrue()
            download.cancel(true)
            pending.complete(t.execute(requireNotNull(request), options))
            assertThat(t.requests).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun `asynchronous artifact lookup handles many immediately completed pages`() {
        val t =
            Transport().apply {
                pages =
                    (1..2000).map { page(artifact("old-$it", "old"), more = true) }.toMutableList()
                pages.add(page(artifact("selected")))
            }
        withClient(t) { client ->
            AgentArtifactDownloads.forResult(
                    client.async().beta().agents().sessions().artifacts(),
                    result(),
                )
                .content("/workspace/outputs/report.txt")
                .get(10, TimeUnit.SECONDS)
                .close()
            assertThat(t.requests).hasSize(2002)
        }
    }

    @Test
    fun `asynchronous artifact copying does not block transport completion`() {
        val t = Transport()
        val pending = CompletableFuture<HttpResponse>()
        val requested = CountDownLatch(1)
        t.asyncOverride = { request, _ ->
            if (request.pathSegments.last() == "content") {
                requested.countDown()
                pending
            } else null
        }
        val reading = CountDownLatch(1)
        val release = CountDownLatch(1)
        val content =
            object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() = Headers.builder().build()

                override fun body() =
                    object : InputStream() {
                        override fun read(): Int {
                            reading.countDown()
                            check(release.await(5, TimeUnit.SECONDS))
                            return -1
                        }
                    }

                override fun close() {}
            }
        withClient(t) { client ->
            val download =
                AgentArtifactDownloads.forResult(
                        client.async().beta().agents().sessions().artifacts(),
                        result(),
                    )
                    .download("/workspace/outputs/report.txt", directory.resolve("async.txt"))
            assertThat(requested.await(5, TimeUnit.SECONDS)).isTrue()
            try {
                val completion = CompletableFuture.runAsync { pending.complete(content) }
                assertThat(reading.await(5, TimeUnit.SECONDS)).isTrue()
                completion.get(1, TimeUnit.SECONDS)
                assertThat(download.isDone).isFalse()
            } finally {
                release.countDown()
            }
            download.get(5, TimeUnit.SECONDS)
        }
    }

    @Test
    fun `cancelling queued artifact consumption closes the completed response immediately`() {
        val t = Transport()
        val pending = CompletableFuture<HttpResponse>()
        val requested = CountDownLatch(1)
        var request: HttpRequest? = null
        t.asyncOverride = { candidate, _ ->
            if (candidate.pathSegments.last() == "content") {
                request = candidate
                requested.countDown()
                pending
            } else null
        }
        withClient(t) { client ->
            val destination = directory.resolve("cancelled.txt")
            val download =
                AgentArtifactDownloads.forResult(
                        client.async().beta().agents().sessions().artifacts(),
                        result(),
                    )
                    .download("/workspace/outputs/report.txt", destination)
            assertThat(requested.await(5, TimeUnit.SECONDS)).isTrue()
            var queued: Runnable? = null
            org.mockito.Mockito.mockStatic(CompletableFuture::class.java) { invocation ->
                    if (invocation.method.name == "runAsync") {
                        queued = invocation.getArgument(0)
                        CompletableFuture<Void>()
                    } else invocation.callRealMethod()
                }
                .use {
                    pending.complete(t.execute(requireNotNull(request), options))
                    assertThat(queued).isNotNull()
                    assertThat(download.cancel(true)).isTrue()
                    assertThat(t.contentClosed).isTrue()
                    assertThat(t.contentReads).isZero()
                    queued!!.run()
                    assertThat(t.contentReads).isZero()
                    assertThat(Files.exists(destination)).isFalse()
                }
        }
    }
}
