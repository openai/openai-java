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
                    request.body!!.writeTo(body)
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
    fun `limits are checked before uploading any member`(async: Boolean) {
        val source = file()
        val many = (1..51).associate { "/workspace/$it" to source }
        val t = Transport()
        assertThatThrownBy { prepare(t, async, many) }
            .isInstanceOf(IllegalArgumentException::class.java)
        java.io.RandomAccessFile(source.toFile(), "rw").use { it.setLength(26L * 1024 * 1024) }
        assertThatThrownBy {
                prepare(t, async, mapOf("/workspace/a" to source, "/workspace/b" to source))
            }
            .isInstanceOf(IllegalArgumentException::class.java)
        java.io.RandomAccessFile(source.toFile(), "rw").use { it.setLength(50L * 1024 * 1024 + 1) }
        assertThatThrownBy { prepare(t, async, mapOf("/workspace/a" to source)) }
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
                    if (async) AgentEnvironmentFiles.prepare(client.async(), files)
                    else AgentEnvironmentFiles.prepare(client, files)
                }
                .isInstanceOf(IllegalArgumentException::class.java)
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
                    else
                        AgentEnvironmentFiles.prepareDirectory(
                            client,
                            alias,
                            "/workspace/docs",
                            listOf("*.txt"),
                        )
                }
                .isInstanceOf(IllegalArgumentException::class.java)
            Files.createSymbolicLink(root.resolve("selected.txt"), root.resolve("source.txt"))
            assertThatThrownBy {
                    if (async)
                        AgentEnvironmentFiles.prepareDirectory(
                            client.async(),
                            root,
                            "/workspace/docs",
                            listOf("*.txt"),
                        )
                    else
                        AgentEnvironmentFiles.prepareDirectory(
                            client,
                            root,
                            "/workspace/docs",
                            listOf("*.txt"),
                        )
                }
                .isInstanceOf(IllegalArgumentException::class.java)
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

    @Test
    fun `cancelling an async download closes a late content response without writing`() {
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
            val download =
                AgentArtifactDownloads.forResult(
                        client.async().beta().agents().sessions().artifacts(),
                        result(),
                    )
                    .download("/workspace/outputs/report.txt", destination)
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

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `path limit counts Unicode code points before uploading any file`(async: Boolean) {
        val source = file()
        val t = Transport()
        val maximum = "/workspace/" + "😀".repeat(4085)
        assertThat(prepare(t, async, mapOf(maximum to source)).files().single().asFileId().path())
            .isEqualTo(maximum)
        val rejected = Transport()
        assertThatThrownBy {
                prepare(
                    rejected,
                    async,
                    linkedMapOf("/workspace/good" to source, maximum + "a" to source),
                )
            }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThat(rejected.requests).isEmpty()
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
}
