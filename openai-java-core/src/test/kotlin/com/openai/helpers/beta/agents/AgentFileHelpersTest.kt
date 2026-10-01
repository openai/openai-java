package com.openai.helpers.beta.agents

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.*
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.beta.agents.AgentTurnResult
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AgentFileHelpersTest {
    @TempDir lateinit var directory: Path
    private val mapper = jsonMapper()
    private val options =
        RequestOptions.builder().timeout(Duration.ofSeconds(9)).responseValidation(false).build()

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

    private fun unwrap(error: Throwable): Throwable =
        if ((error is CompletionException || error is ExecutionException) && error.cause != null)
            unwrap(error.cause!!)
        else error

    private inner class Transport : HttpClient {
        val requests = mutableListOf<HttpRequest>()
        val requestOptions = mutableListOf<RequestOptions>()
        val bodies = mutableListOf<String>()
        var uploads = 0
        var discardUploadBody = false
        var uploadFailureAt = 0
        var beforeUpload: () -> Unit = {}
        var stageFailure = false
        var pages = mutableListOf(page(artifact("artifact-one")))
        var contentClosed = false
        val contentClosedSignal = CountDownLatch(1)
        var contentReads = 0
        var contentSize = 64 * 1024
        var onContent: () -> Unit = {}
        var onList: () -> Unit = {}
        var asyncOverride: ((HttpRequest, RequestOptions) -> CompletableFuture<HttpResponse>?)? =
            null

        private fun response(text: String, status: Int = 200): HttpResponse =
            response(ByteArrayInputStream(text.toByteArray()), status)

        private fun response(input: InputStream, status: Int = 200): HttpResponse =
            object : HttpResponse {
                override fun statusCode() = status

                override fun headers() =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body() = input

                override fun close() = input.close()
            }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            this.requestOptions.add(requestOptions)
            val path = request.pathSegments
            return when {
                request.method == HttpMethod.POST -> {
                    if (!path.contains("environments")) beforeUpload()
                    val body = ByteArrayOutputStream()
                    request.body!!.writeTo(
                        if (discardUploadBody)
                            object : java.io.OutputStream() {
                                override fun write(value: Int) {}

                                override fun write(bytes: ByteArray, offset: Int, length: Int) {}
                            }
                        else body
                    )
                    bodies.add(body.toString("UTF-8"))
                    if (path.contains("environments")) {
                        if (stageFailure)
                            response(
                                """{"error":{"message":"stage failed","type":"server_error"}}""",
                                503,
                            )
                        else
                            response(
                                """{"path":"/workspace/source.txt","type":"file_id","file_id":"file-$uploads"}"""
                            )
                    } else {
                        uploads++
                        if (uploads == uploadFailureAt)
                            response(
                                """{"error":{"message":"upload failed","type":"server_error"}}""",
                                503,
                            )
                        else response("""{"id":"file-$uploads"}""")
                    }
                }
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

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            try {
                asyncOverride?.invoke(request, requestOptions)
                    ?: CompletableFuture.completedFuture(execute(request, requestOptions))
            } catch (error: Throwable) {
                CompletableFuture<HttpResponse>().apply { completeExceptionally(error) }
            }

        override fun close() {}

        fun client() =
            OpenAIClientImpl(
                ClientOptions.builder().httpClient(this).apiKey("synthetic").maxRetries(0).build()
            )
    }

    private fun <T> withClient(t: Transport, block: (OpenAIClientImpl) -> T): T {
        val client = t.client()
        return try {
            block(client)
        } finally {
            client.close()
        }
    }

    private fun prepare(
        t: Transport,
        async: Boolean,
        files: Map<String, Path>,
    ): PreparedAgentFiles {
        val client = t.client()
        return try {
            if (async)
                AgentEnvironmentFiles.prepare(client.async(), files, options)
                    .get(5, TimeUnit.SECONDS)
            else AgentEnvironmentFiles.prepare(client, files, options)
        } catch (error: Exception) {
            throw unwrap(error)
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `prepare uploads selected sources and returns ordinary inputs with ownership`(
        async: Boolean
    ) {
        val t = Transport()
        val prepared =
            prepare(
                t,
                async,
                linkedMapOf(
                    "/workspace/a.txt" to file("a.txt"),
                    "/workspace/b.txt" to file("b.txt"),
                ),
            )
        assertThat(prepared.uploadedFileIds()).containsExactly("file-1", "file-2")
        assertThat(prepared.files().map { it.asFileId().path() })
            .containsExactly("/workspace/a.txt", "/workspace/b.txt")
        assertThat(t.bodies).allSatisfy { assertThat(it).contains("user_data") }
        assertThat(t.requestOptions).allSatisfy {
            assertThat(it.timeout).isEqualTo(options.timeout)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `all destination and source validation happens before uploads`(async: Boolean) {
        val source = file()
        for (invalid in
            listOf(
                "/elsewhere/file",
                "/workspace/../file",
                "/workspace/a//b",
                "/workspace/.codex/file",
                "/workspace/.managed-agents-a/file",
                "/workspace/outputs",
                "/workspace/a\\b",
            )) {
            val t = Transport()
            assertThatThrownBy {
                    prepare(t, async, linkedMapOf("/workspace/good" to source, invalid to source))
                }
                .isInstanceOf(IllegalArgumentException::class.java)
            assertThat(t.requests).isEmpty()
        }
        val collision = Transport()
        assertThatThrownBy {
                prepare(
                    collision,
                    async,
                    linkedMapOf(
                        "/workspace/a" to source,
                        "/workspace/a-b" to source,
                        "/workspace/a/b" to source,
                    ),
                )
            }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThat(collision.requests).isEmpty()
        val symlink = directory.resolve("link.txt")
        Files.createSymbolicLink(symlink, source)
        val t = Transport()
        assertThatThrownBy {
                prepare(
                    t,
                    async,
                    linkedMapOf("/workspace/good" to source, "/workspace/link" to symlink),
                )
            }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThat(t.requests).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `multi upload checks effective client idempotency header without changing defaults`(
        async: Boolean
    ) {
        val t = Transport()
        val client = t.client().withOptions { it.putHeader("iDeMpOtEnCy-KeY", "synthetic") }
        try {
            val files = mapOf("/workspace/a" to file("a"), "/workspace/b" to file("b"))
            assertThatThrownBy {
                    if (async) AgentEnvironmentFiles.prepare(client.async(), files).join()
                    else AgentEnvironmentFiles.prepare(client, files)
                }
                .satisfies(
                    java.util.function.Consumer {
                        assertThat(unwrap(it)).isInstanceOf(IllegalArgumentException::class.java)
                    }
                )
            assertThat(t.requests).isEmpty()
            val without = client.withOptions { it.removeHeaders("Idempotency-Key") }
            if (async) AgentEnvironmentFiles.prepare(without.async(), files).join()
            else AgentEnvironmentFiles.prepare(without, files)
            assertThat(t.uploads).isEqualTo(2)
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `partial upload and stage failures retain known uploaded IDs without deleting them`(
        async: Boolean
    ) {
        val t = Transport().apply { uploadFailureAt = 2 }
        val error =
            unwrap(
                catchThrowable {
                    prepare(
                        t,
                        async,
                        linkedMapOf("/workspace/a" to file("a"), "/workspace/b" to file("b")),
                    )
                }
            )
                as AgentFilePreparationException
        assertThat(error.uploadedFileIds()).containsExactly("file-1")
        assertThat(t.requests.none { it.method == HttpMethod.DELETE }).isTrue()
        val staging = Transport().apply { stageFailure = true }
        val client = staging.client()
        try {
            val failure =
                unwrap(
                    catchThrowable {
                        if (async)
                            AgentEnvironmentFiles.upload(
                                    client.async(),
                                    "env",
                                    file(),
                                    "/workspace/source.txt",
                                    options,
                                )
                                .join()
                        else
                            AgentEnvironmentFiles.upload(
                                client,
                                "env",
                                file(),
                                "/workspace/source.txt",
                                options,
                            )
                    }
                )
                    as AgentFilePreparationException
            assertThat(failure.uploadedFileIds()).containsExactly("file-1")
            assertThat(staging.requests.none { it.method == HttpMethod.DELETE }).isTrue()
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `directory selection is explicit and preserves relative paths`(async: Boolean) {
        file("a.txt")
        file("skip.csv")
        Files.createDirectory(directory.resolve("nested"))
        file("nested/b.txt")
        val t = Transport()
        val client = t.client()
        try {
            val prepared =
                if (async)
                    AgentEnvironmentFiles.prepareDirectory(
                            client.async(),
                            directory,
                            "/workspace/docs",
                            listOf("*.txt", "**/*.txt"),
                            options,
                        )
                        .join()
                else
                    AgentEnvironmentFiles.prepareDirectory(
                        client,
                        directory,
                        "/workspace/docs",
                        listOf("*.txt", "**/*.txt"),
                        options,
                    )
            assertThat(prepared.files().map { it.asFileId().path() })
                .containsExactlyInAnyOrder("/workspace/docs/a.txt", "/workspace/docs/nested/b.txt")
        } finally {
            client.close()
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
    fun `live upload stages a file with original request options`(async: Boolean) {
        val t = Transport()
        val client = t.client().withOptions { it.putHeader("Idempotency-Key", "synthetic-single") }
        try {
            val staged =
                if (async)
                    AgentEnvironmentFiles.upload(
                            client.async(),
                            "env",
                            file(),
                            "/workspace/source.txt",
                            options,
                        )
                        .join()
                else
                    AgentEnvironmentFiles.upload(
                        client,
                        "env",
                        file(),
                        "/workspace/source.txt",
                        options,
                    )
            assertThat(staged.uploadedFileId()).isEqualTo("file-1")
            assertThat(t.bodies.last()).contains("/workspace/source.txt", "file-1")
            assertThat(t.requests).hasSize(2)
            assertThat(t.requests).allSatisfy {
                assertThat(it.headers.values("Idempotency-Key")).containsExactly("synthetic-single")
            }
            assertThat(t.requestOptions).allSatisfy {
                assertThat(it.timeout).isEqualTo(options.timeout)
            }
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `selected symlink is rejected but a normal parent alias is supported`(async: Boolean) {
        val root = Files.createDirectory(directory.resolve("real"))
        Files.write(root.resolve("source.txt"), byteArrayOf(1))
        val alias = directory.resolve("alias")
        Files.createSymbolicLink(alias, root)
        val t = Transport()
        assertThat(
                prepare(t, async, mapOf("/workspace/source.txt" to alias.resolve("source.txt")))
                    .uploadedFileIds()
            )
            .hasSize(1)
        val client = t.client()
        try {
            assertThatThrownBy {
                    if (async)
                        AgentEnvironmentFiles.prepareDirectory(
                                client.async(),
                                alias,
                                "/workspace/docs",
                                listOf("*.txt"),
                            )
                            .join()
                    else
                        AgentEnvironmentFiles.prepareDirectory(
                            client,
                            alias,
                            "/workspace/docs",
                            listOf("*.txt"),
                        )
                }
                .satisfies(
                    java.util.function.Consumer { error ->
                        assertThat(unwrap(error)).isInstanceOf(IllegalArgumentException::class.java)
                    }
                )
            Files.createSymbolicLink(root.resolve("selected.txt"), root.resolve("source.txt"))
            assertThatThrownBy {
                    if (async)
                        AgentEnvironmentFiles.prepareDirectory(
                                client.async(),
                                root,
                                "/workspace/docs",
                                listOf("*.txt"),
                            )
                            .join()
                    else
                        AgentEnvironmentFiles.prepareDirectory(
                            client,
                            root,
                            "/workspace/docs",
                            listOf("*.txt"),
                        )
                }
                .satisfies(
                    java.util.function.Consumer { error ->
                        assertThat(unwrap(error)).isInstanceOf(IllegalArgumentException::class.java)
                    }
                )
            assertThat(t.uploads).isEqualTo(1)
        } finally {
            client.close()
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
    fun `long destination paths are preserved for API validation`() {
        val source = file()
        val t = Transport()
        val destination = "/workspace/" + "😀".repeat(5000)
        assertThat(
                prepare(t, true, mapOf(destination to source)).files().single().asFileId().path()
            )
            .isEqualTo(destination)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `later selected files are checked again after earlier uploads`(async: Boolean) {
        for (replace in listOf(false, true)) {
            val first = file("first")
            val second = file("second", "old")
            val t =
                Transport().apply {
                    beforeUpload = {
                        if (uploads == 0) {
                            if (replace) Files.delete(second)
                            Files.write(
                                second,
                                (if (replace) "new" else "grown after preflight").toByteArray(),
                            )
                        }
                    }
                }
            val error =
                unwrap(
                    catchThrowable {
                        prepare(
                            t,
                            async,
                            linkedMapOf("/workspace/first" to first, "/workspace/second" to second),
                        )
                    }
                )
                    as AgentFilePreparationException
            assertThat(error.uploadedFileIds()).containsExactly("file-1")
            assertThat(t.uploads).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `opened upload detects size changes while streaming`(async: Boolean) {
        for (contents in listOf("more bytes than before", "")) {
            val source = file(text = "old")
            val t =
                Transport().apply { beforeUpload = { Files.write(source, contents.toByteArray()) } }
            val error =
                unwrap(catchThrowable { prepare(t, async, mapOf("/workspace/source" to source)) })
            assertThat(error).isInstanceOf(AgentFilePreparationException::class.java)
            assertThat(error).hasStackTraceContaining("during upload")
            assertThat(t.uploads).isZero()
        }
    }

    @Test
    fun `directory replacement during resolution is rejected before uploads`() {
        val root = Files.createDirectory(directory.resolve("selected"))
        val outside = Files.createDirectory(directory.resolve("other"))
        Files.write(outside.resolve("not-selected.txt"), byteArrayOf(1))
        val original =
            Files.readAttributes(
                root,
                java.nio.file.attribute.BasicFileAttributes::class.java,
                java.nio.file.LinkOption.NOFOLLOW_LINKS,
            )
        val t = Transport()
        val client = t.client()
        var replaced = false
        org.mockito.Mockito.mockStatic(Files::class.java, org.mockito.Mockito.CALLS_REAL_METHODS)
            .use { mocked ->
                mocked
                    .`when`<java.nio.file.attribute.BasicFileAttributes> {
                        Files.readAttributes(
                            root,
                            java.nio.file.attribute.BasicFileAttributes::class.java,
                            java.nio.file.LinkOption.NOFOLLOW_LINKS,
                        )
                    }
                    .thenAnswer {
                        if (!replaced) {
                            replaced = true
                            Files.move(root, directory.resolve("original"))
                            Files.createSymbolicLink(root, outside)
                            original
                        } else it.callRealMethod()
                    }
                try {
                    assertThatThrownBy {
                            AgentEnvironmentFiles.prepareDirectory(
                                client,
                                root,
                                "/workspace/docs",
                                listOf("*.txt"),
                            )
                        }
                        .isInstanceOf(IllegalArgumentException::class.java)
                    assertThat(t.requests).isEmpty()
                } finally {
                    client.close()
                }
            }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `explicit source paths preserve symlink dotdot filesystem semantics`(async: Boolean) {
        val target = Files.createDirectories(directory.resolve("target/child"))
        val selected = file("target/source.txt", "selected filesystem contents")
        file("source.txt", "unselected lexical sibling")
        val alias = directory.resolve("alias")
        Files.createSymbolicLink(alias, target)
        val source = alias.resolve("../source.txt")
        val t = Transport()
        prepare(t, async, mapOf("/workspace/source.txt" to source))
        assertThat(t.bodies.single())
            .contains("selected filesystem contents")
            .doesNotContain("unselected lexical sibling")
        Files.delete(selected)
        val missing = Transport()
        assertThatThrownBy { prepare(missing, async, mapOf("/workspace/source.txt" to source)) }
            .isInstanceOf(java.nio.file.NoSuchFileException::class.java)
        assertThat(missing.requests).isEmpty()
    }

    @Test
    fun `directory walk cannot authorize files outside a cached child directory`() {
        val root = Files.createDirectory(directory.resolve("selected"))
        val child = Files.createDirectory(root.resolve("nested"))
        val outside = Files.createDirectory(directory.resolve("other"))
        Files.write(outside.resolve("not-selected.txt"), "outside".toByteArray())
        val original =
            Files.readAttributes(
                child,
                java.nio.file.attribute.BasicFileAttributes::class.java,
                java.nio.file.LinkOption.NOFOLLOW_LINKS,
            )
        val t = Transport()
        val client = t.client()
        var replaced = false
        org.mockito.Mockito.mockStatic(Files::class.java, org.mockito.Mockito.CALLS_REAL_METHODS)
            .use { mocked ->
                mocked
                    .`when`<java.nio.file.attribute.BasicFileAttributes> {
                        Files.readAttributes(
                            child,
                            java.nio.file.attribute.BasicFileAttributes::class.java,
                            java.nio.file.LinkOption.NOFOLLOW_LINKS,
                        )
                    }
                    .thenAnswer {
                        if (!replaced) {
                            replaced = true
                            Files.move(child, directory.resolve("original-child"))
                            Files.createSymbolicLink(child, outside)
                            original
                        } else it.callRealMethod()
                    }
                try {
                    catchThrowable {
                        AgentEnvironmentFiles.prepareDirectory(
                            client,
                            root,
                            "/workspace/docs",
                            listOf("**/*.txt"),
                        )
                    }
                    assertThat(replaced).isTrue()
                    assertThat(t.requests).isEmpty()
                } finally {
                    client.close()
                }
            }
    }

    @Test
    fun `regular ZIP filesystem sources work for preparation and staging`() {
        val uri = java.net.URI.create("jar:" + directory.resolve("sources.zip").toUri())
        java.nio.file.FileSystems.newFileSystem(uri, mapOf("create" to "true")).use { fs ->
            val source = fs.getPath("/source.txt")
            Files.write(source, "zip contents".toByteArray())
            val t = Transport()
            assertThat(prepare(t, true, mapOf("/workspace/source.txt" to source)).files())
                .hasSize(1)
            withClient(t) { client ->
                val staged =
                    AgentEnvironmentFiles.upload(client, "env", source, "/workspace/source.txt")
                assertThat(staged.uploadedFileId()).isEqualTo("file-2")
            }
            assertThat(t.bodies.take(2)).allSatisfy { assertThat(it).contains("zip contents") }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["prepare", "upload", "stage"])
    fun `cancelling an upload keeps native response cleanup and stops subsequent work`(
        mode: String
    ) {
        val t = Transport()
        val pending = CompletableFuture<HttpResponse>()
        var request: HttpRequest? = null
        val requested = CountDownLatch(1)
        t.asyncOverride = { candidate, _ ->
            if (mode != "stage" || candidate.pathSegments.contains("environments")) {
                request = candidate
                requested.countDown()
                pending
            } else null
        }
        withClient(t) { client ->
            val source = file()
            val operation =
                if (mode == "prepare")
                    AgentEnvironmentFiles.prepare(
                        client.async(),
                        linkedMapOf("/workspace/a" to source, "/workspace/b" to source),
                    )
                else
                    AgentEnvironmentFiles.upload(
                        client.async(),
                        "env",
                        source,
                        "/workspace/source.txt",
                    )
            assertThat(requested.await(5, TimeUnit.SECONDS)).isTrue()
            val response = t.execute(requireNotNull(request), options)
            assertThat(operation.cancel(true)).isTrue()
            val closed = CountDownLatch(1)
            pending.complete(
                object : HttpResponse by response {
                    override fun close() {
                        response.close()
                        closed.countDown()
                    }
                }
            )
            assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(t.uploads).isEqualTo(1)
            assertThat(t.requests).hasSize(if (mode == "stage") 2 else 1)
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

    @ParameterizedTest
    @ValueSource(strings = ["directory", "prepare", "upload"])
    fun `asynchronous file helpers do not inspect files on the caller thread`(operation: String) {
        val source = file()
        val t = Transport()
        withClient(t) { client ->
            org.mockito.Mockito.mockStatic(
                    Files::class.java,
                    org.mockito.Mockito.CALLS_REAL_METHODS,
                )
                .use { mocked ->
                    mocked
                        .`when`<java.nio.file.attribute.BasicFileAttributes> {
                            Files.readAttributes(
                                if (operation == "directory") directory else source,
                                java.nio.file.attribute.BasicFileAttributes::class.java,
                                java.nio.file.LinkOption.NOFOLLOW_LINKS,
                            )
                        }
                        .thenThrow(AssertionError("Filesystem work ran on the calling thread"))
                    val pending =
                        when (operation) {
                            "directory" ->
                                AgentEnvironmentFiles.prepareDirectory(
                                    client.async(),
                                    directory,
                                    "/workspace/docs",
                                    listOf("*.txt"),
                                )
                            "prepare" ->
                                AgentEnvironmentFiles.prepare(
                                    client.async(),
                                    mapOf("/workspace/source.txt" to source),
                                )
                            else ->
                                AgentEnvironmentFiles.upload(
                                    client.async(),
                                    "env",
                                    source,
                                    "/workspace/source.txt",
                                )
                        }
                    pending.get(5, TimeUnit.SECONDS)
                    assertThat(t.uploads).isEqualTo(1)
                }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `overlap validation handles interleaved names and preserves input order`(async: Boolean) {
        val source = file()
        val siblings =
            listOf("/workspace/a-", "/workspace/a/b", "/workspace/a%2Fb", "/workspace/😀/b")
        val valid = Transport()
        val prepared = prepare(valid, async, siblings.associateWith { source })
        assertThat(prepared.files().map { it.asFileId().path() })
            .containsExactlyElementsOf(siblings)
        for (parent in listOf("/workspace/a", "/workspace/😀")) {
            val invalid = Transport()
            assertThatThrownBy {
                    prepare(invalid, async, (siblings + parent).associateWith { source })
                }
                .isInstanceOf(IllegalArgumentException::class.java)
            assertThat(invalid.requests).isEmpty()
        }
    }

    @Test
    fun `preparation submits large selections and preserves ordinary API errors`() {
        val source = file()
        java.io.RandomAccessFile(source.toFile(), "rw").use { it.setLength(50L * 1024 * 1024 + 1) }
        val t =
            Transport().apply {
                uploadFailureAt = 1
                discardUploadBody = true
            }
        val error = catchThrowable {
            prepare(t, true, (1..51).associate { "/workspace/files/$it.txt" to source })
        }
        assertThat(error).isInstanceOf(AgentFilePreparationException::class.java)
        assertThat(error.cause).isInstanceOf(com.openai.errors.InternalServerException::class.java)
        assertThat(t.uploads).isEqualTo(1)
    }

    @Test
    fun `async preparation snapshots a mutable selection before returning`() {
        val original = file("original.txt")
        val blocked = org.mockito.Mockito.mock(Path::class.java)
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        org.mockito.Mockito.`when`(blocked.toAbsolutePath()).thenAnswer {
            entered.countDown()
            check(release.await(5, TimeUnit.SECONDS))
            original
        }
        val selected = linkedMapOf("/workspace/first" to blocked, "/workspace/second" to original)
        val t = Transport()
        withClient(t) { client ->
            val pending = AgentEnvironmentFiles.prepare(client.async(), selected)
            try {
                assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                selected.clear()
                selected["/workspace/replacement"] = file("replacement.txt")
            } finally {
                release.countDown()
            }
            assertThat(pending.get(5, TimeUnit.SECONDS).files().map { it.asFileId().path() })
                .containsExactly("/workspace/first", "/workspace/second")
        }
    }

    @Test
    fun `async directory preparation snapshots mutable include patterns before returning`() {
        file("selected.txt")
        file("unselected.csv")
        val blocked = org.mockito.Mockito.spy(directory)
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        org.mockito.Mockito.doAnswer {
                entered.countDown()
                check(release.await(5, TimeUnit.SECONDS))
                directory.toRealPath()
            }
            .`when`(blocked)
            .toRealPath()
        val include = mutableListOf("*.txt")
        val t = Transport()
        withClient(t) { client ->
            val pending =
                AgentEnvironmentFiles.prepareDirectory(
                    client.async(),
                    blocked,
                    "/workspace/docs",
                    include,
                )
            try {
                assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                include.clear()
                include.add("*.csv")
            } finally {
                release.countDown()
            }
            assertThat(pending.get(5, TimeUnit.SECONDS).files().map { it.asFileId().path() })
                .containsExactly("/workspace/docs/selected.txt")
        }
    }

    @Test
    fun `cancelling a pending upload closes its source before transport completion`() {
        val t = Transport()
        val pending = CompletableFuture<HttpResponse>()
        val requested = CountDownLatch(1)
        var request: HttpRequest? = null
        t.asyncOverride = { candidate, _ ->
            request = candidate
            requested.countDown()
            pending
        }
        withClient(t) { client ->
            val operation =
                AgentEnvironmentFiles.prepare(client.async(), mapOf("/workspace/source" to file()))
            assertThat(requested.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(operation.cancel(true)).isTrue()
            try {
                assertThat(pending.isDone).isFalse()
                assertThatThrownBy { request!!.body!!.writeTo(ByteArrayOutputStream()) }
                    .hasStackTraceContaining("ClosedChannelException")
            } finally {
                pending.completeExceptionally(java.io.IOException("Synthetic transport stopped"))
            }
        }
    }

    @Test
    fun `preparation supports a JDK runtime image source`() {
        val fs = java.nio.file.FileSystems.getFileSystem(java.net.URI.create("jrt:/"))
        val source = fs.getPath("/modules/java.base/java/lang/Object.class")
        val t = Transport()
        assertThat(prepare(t, true, mapOf("/workspace/Object.class" to source)).files()).hasSize(1)
        assertThat(t.bodies.single()).contains("Object.class")
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
