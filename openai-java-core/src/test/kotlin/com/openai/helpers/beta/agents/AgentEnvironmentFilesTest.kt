package com.openai.helpers.beta.agents

import com.openai.core.http.*
import java.io.ByteArrayOutputStream
import java.nio.file.Files
import java.nio.file.Path
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

internal class AgentEnvironmentFilesTest {
    @TempDir lateinit var directory: Path
    private val options = fileTestOptions

    private fun unwrapFileTestError(error: Throwable): Throwable =
        if ((error is CompletionException || error is ExecutionException) && error.cause != null)
            unwrapFileTestError(error.cause!!)
        else error

    private fun file(name: String = "source.txt", text: String = "source") =
        directory.resolve(name).also { Files.write(it, text.toByteArray()) }

    private class Transport : AgentFileTestTransport() {
        val bodies = mutableListOf<String>()
        var uploads = 0
        var discardUploadBody = false
        var uploadFailureAt = 0
        var beforeUpload: () -> Unit = {}
        var stageFailure = false

        override fun respond(request: HttpRequest): HttpResponse {
            check(request.method == HttpMethod.POST) { "Unexpected endpoint" }
            val path = request.pathSegments
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
            return if (path.contains("environments")) {
                if (stageFailure)
                    response("""{"error":{"message":"stage failed","type":"server_error"}}""", 503)
                else
                    response(
                        """{"path":"/workspace/source.txt","type":"file_id","file_id":"file-$uploads"}"""
                    )
            } else {
                uploads++
                if (uploads == uploadFailureAt)
                    response("""{"error":{"message":"upload failed","type":"server_error"}}""", 503)
                else response("""{"id":"file-$uploads"}""")
            }
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
            throw unwrapFileTestError(error)
        } finally {
            client.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `directory selection skips unreadable neighbors but fails selected files and roots`(
        async: Boolean
    ) {
        org.junit.jupiter.api.Assumptions.assumeTrue(
            Files.getFileStore(directory).supportsFileAttributeView("posix")
        )
        val selected = file("one.txt")
        val neighbor = Files.createDirectory(directory.resolve("private"))
        val rootPermissions = Files.getPosixFilePermissions(directory)
        val filePermissions = Files.getPosixFilePermissions(selected)
        val neighborPermissions = Files.getPosixFilePermissions(neighbor)
        fun select(t: Transport) =
            withClient(t) { client ->
                try {
                    if (async)
                        AgentEnvironmentFiles.prepareDirectory(
                                client.async(),
                                directory,
                                "/workspace/docs",
                                listOf("one.txt"),
                            )
                            .get(5, TimeUnit.SECONDS)
                    else
                        AgentEnvironmentFiles.prepareDirectory(
                            client,
                            directory,
                            "/workspace/docs",
                            listOf("one.txt"),
                        )
                } catch (error: Exception) {
                    throw unwrapFileTestError(error)
                }
            }
        try {
            Files.setPosixFilePermissions(neighbor, emptySet())
            org.junit.jupiter.api.Assumptions.assumeFalse(Files.isReadable(neighbor))
            val successful = Transport()
            assertThat(select(successful).files().map { it.asFileId().path() })
                .containsExactly("/workspace/docs/one.txt")
            assertThat(successful.uploads).isEqualTo(1)

            Files.setPosixFilePermissions(selected, emptySet())
            val unreadableFile = Transport()
            assertThatThrownBy { select(unreadableFile) }
                .isInstanceOf(AgentFilePreparationException::class.java)
                .hasCauseInstanceOf(java.nio.file.AccessDeniedException::class.java)
            assertThat(unreadableFile.requests).isEmpty()

            Files.setPosixFilePermissions(directory, emptySet())
            val unreadableRoot = Transport()
            assertThatThrownBy { select(unreadableRoot) }
                .isInstanceOf(java.nio.file.AccessDeniedException::class.java)
            assertThat(unreadableRoot.requests).isEmpty()
        } finally {
            Files.setPosixFilePermissions(directory, rootPermissions)
            Files.setPosixFilePermissions(selected, filePermissions)
            Files.setPosixFilePermissions(neighbor, neighborPermissions)
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
                        assertThat(unwrapFileTestError(it))
                            .isInstanceOf(IllegalArgumentException::class.java)
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
            unwrapFileTestError(
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
                unwrapFileTestError(
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
                        assertThat(unwrapFileTestError(error))
                            .isInstanceOf(IllegalArgumentException::class.java)
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
                        assertThat(unwrapFileTestError(error))
                            .isInstanceOf(IllegalArgumentException::class.java)
                    }
                )
            assertThat(t.uploads).isEqualTo(1)
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
                unwrapFileTestError(
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
                unwrapFileTestError(
                    catchThrowable { prepare(t, async, mapOf("/workspace/source" to source)) }
                )
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
            listOf(
                "/workspace/a-",
                "/workspace/a/b",
                "/workspace/a%2Fb",
                "/workspace/😀/b",
                "/workspace/" + "deep/".repeat(4096) + "file.txt",
            )
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
}
