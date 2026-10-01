package com.openai.helpers.beta.agents

import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientAsync
import com.openai.core.MultipartField
import com.openai.core.RequestOptions
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.environments.files.FileCreateParams as StageParams
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FilePurpose
import java.io.IOException
import java.io.InputStream
import java.nio.channels.Channels
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.LinkOption.NOFOLLOW_LINKS
import java.nio.file.Path
import java.nio.file.StandardOpenOption.READ
import java.nio.file.attribute.BasicFileAttributes
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.atomic.AtomicReference

/** File preparation and live staging for beta Agents hosted environments. */
object AgentEnvironmentFiles {
    private const val MAX_FILES = 50
    private const val MAX_BYTES = 50L * 1024 * 1024

    @JvmStatic
    @JvmOverloads
    fun prepare(
        client: OpenAIClient,
        files: Map<String, Path>,
        options: RequestOptions = RequestOptions.none(),
    ): PreparedAgentFiles {
        val selected = preflight(files, initial = true)
        if (selected.size > 1)
            client.withOptions {
                require(it.build().headers.values("Idempotency-Key").isEmpty()) {
                    "A multi-file preparation cannot reuse an Idempotency-Key"
                }
            }
        val prepared = mutableListOf<HostedEnvironmentFileParam>()
        try {
            selected.forEach { (destination, source) ->
                val params = uploadParams(source)
                params.file().use {
                    val uploaded = client.files().create(params, options)
                    prepared.add(reference(destination, uploaded.id()))
                }
            }
        } catch (error: Exception) {
            throw AgentFilePreparationException(ids(prepared), error)
        }
        return PreparedAgentFiles(prepared)
    }

    @JvmStatic
    @JvmOverloads
    fun prepare(
        client: OpenAIClientAsync,
        files: Map<String, Path>,
        options: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreparedAgentFiles> {
        val selected = preflight(files, initial = true)
        if (selected.size > 1)
            client.withOptions {
                require(it.build().headers.values("Idempotency-Key").isEmpty()) {
                    "A multi-file preparation cannot reuse an Idempotency-Key"
                }
            }
        val prepared = mutableListOf<HostedEnvironmentFileParam>()
        val result = CompletableFuture<PreparedAgentFiles>()
        val active = AtomicReference<CompletableFuture<*>?>()
        result.whenComplete { _, _ -> if (result.isCancelled) active.get()?.cancel(true) }
        fun next(index: Int) {
            if (result.isDone) return
            if (index == selected.size) {
                result.complete(PreparedAgentFiles(prepared))
                return
            }
            try {
                val (destination, source) = selected[index]
                val params = uploadParams(source)
                val request =
                    try {
                        client.files().create(params, options)
                    } catch (error: Throwable) {
                        runCatching { params.file().close() }
                        throw error
                    }
                active.set(request)
                if (result.isCancelled) request.cancel(true)
                request.whenComplete { uploaded, failure ->
                    try {
                        if (failure != null) throw failure
                        prepared.add(reference(destination, uploaded.id()))
                        params.file().close()
                        next(index + 1)
                    } catch (error: Throwable) {
                        runCatching { params.file().close() }
                        result.completeExceptionally(
                            AgentFilePreparationException(ids(prepared), unwrap(error))
                        )
                    }
                }
            } catch (error: Throwable) {
                result.completeExceptionally(
                    AgentFilePreparationException(ids(prepared), unwrap(error))
                )
            }
        }
        next(0)
        return result
    }

    /**
     * JDK glob patterns match paths relative to the selected directory; symlink entries are not
     * followed.
     */
    @JvmStatic
    @JvmOverloads
    fun prepareDirectory(
        client: OpenAIClient,
        source: Path,
        destination: String,
        include: List<String>,
        options: RequestOptions = RequestOptions.none(),
    ): PreparedAgentFiles = prepare(client, directoryFiles(source, destination, include), options)

    @JvmStatic
    @JvmOverloads
    fun prepareDirectory(
        client: OpenAIClientAsync,
        source: Path,
        destination: String,
        include: List<String>,
        options: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreparedAgentFiles> =
        prepare(client, directoryFiles(source, destination, include), options)

    @JvmStatic
    @JvmOverloads
    fun upload(
        client: OpenAIClient,
        environmentId: String,
        source: Path,
        destination: String,
        options: RequestOptions = RequestOptions.none(),
    ): StagedAgentFile {
        val selected = preflight(mapOf(destination to source), initial = false).single()
        var id: String? = null
        try {
            val params = uploadParams(selected.second)
            params.file().use { id = client.files().create(params, options).id() }
            val file =
                client
                    .beta()
                    .agents()
                    .environments()
                    .files()
                    .create(
                        StageParams.builder()
                            .environmentId(environmentId)
                            .hostedEnvironmentFileParam(reference(destination, requireNotNull(id)))
                            .build(),
                        options,
                    )
            return StagedAgentFile(requireNotNull(id), file)
        } catch (error: Exception) {
            throw AgentFilePreparationException(listOfNotNull(id), error)
        }
    }

    @JvmStatic
    @JvmOverloads
    fun upload(
        client: OpenAIClientAsync,
        environmentId: String,
        source: Path,
        destination: String,
        options: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StagedAgentFile> {
        val prepared = prepare(client, mapOf(destination to source), options)
        val result = CompletableFuture<StagedAgentFile>()
        val active = AtomicReference<CompletableFuture<*>>(prepared)
        result.whenComplete { _, _ -> if (result.isCancelled) active.get().cancel(true) }
        prepared.whenComplete { inputs, failure ->
            if (failure != null) result.completeExceptionally(unwrap(failure))
            else if (!result.isDone) {
                val id = inputs.uploadedFileIds().single()
                try {
                    val request =
                        client
                            .beta()
                            .agents()
                            .environments()
                            .files()
                            .create(
                                StageParams.builder()
                                    .environmentId(environmentId)
                                    .hostedEnvironmentFileParam(inputs.files().single())
                                    .build(),
                                options,
                            )
                    active.set(request)
                    if (result.isCancelled) request.cancel(true)
                    request.whenComplete { file, error ->
                        if (error != null)
                            result.completeExceptionally(
                                AgentFilePreparationException(listOf(id), unwrap(error))
                            )
                        else result.complete(StagedAgentFile(id, file))
                    }
                } catch (error: Throwable) {
                    result.completeExceptionally(AgentFilePreparationException(listOf(id), error))
                }
            }
        }
        return result
    }

    private data class Source(val path: Path, val attributes: BasicFileAttributes)

    private fun attributes(path: Path): BasicFileAttributes =
        Files.readAttributes(path, BasicFileAttributes::class.java, NOFOLLOW_LINKS)

    private fun sameIdentity(before: BasicFileAttributes, after: BasicFileAttributes): Boolean =
        before.fileKey() == after.fileKey() &&
            before.creationTime() == after.creationTime() &&
            before.isRegularFile == after.isRegularFile &&
            before.isDirectory == after.isDirectory

    private fun uploadParams(source: Source): FileCreateParams {
        require(sameIdentity(source.attributes, attributes(source.path))) {
            "The selected file changed before upload"
        }
        val channel = FileChannel.open(source.path, READ, NOFOLLOW_LINKS)
        try {
            require(
                sameIdentity(source.attributes, attributes(source.path)) &&
                    channel.size() == source.attributes.size()
            ) {
                "The selected file changed before upload"
            }
            val input = Channels.newInputStream(channel)
            val checked =
                object : InputStream() {
                    var remaining = source.attributes.size()

                    override fun read(): Int {
                        val one = ByteArray(1)
                        return if (read(one, 0, 1) < 0) -1 else one[0].toInt() and 0xff
                    }

                    override fun read(bytes: ByteArray, offset: Int, length: Int): Int {
                        if (length == 0) return 0
                        if (remaining == 0L) {
                            if (input.read() != -1)
                                throw IOException("The selected file grew during upload")
                            return -1
                        }
                        val read =
                            input.read(bytes, offset, minOf(length.toLong(), remaining).toInt())
                        if (read < 0) throw IOException("The selected file shrank during upload")
                        remaining -= read
                        return read
                    }

                    override fun close() = input.close()
                }
            return FileCreateParams.builder()
                .file(
                    MultipartField.builder<InputStream>()
                        .value(checked)
                        .filename(source.path.fileName.toString())
                        .build()
                )
                .purpose(FilePurpose.USER_DATA)
                .build()
        } catch (error: Throwable) {
            runCatching { channel.close() }
            throw error
        }
    }

    private fun reference(destination: String, id: String) =
        HostedEnvironmentFileParam.ofFileId(
            HostedEnvironmentFileParam.FileId.builder().path(destination).fileId(id).build()
        )

    private fun ids(files: List<HostedEnvironmentFileParam>) = files.map { it.asFileId().fileId() }

    private fun unwrap(error: Throwable): Throwable =
        if (error is CompletionException && error.cause != null) unwrap(error.cause!!) else error

    private fun preflight(files: Map<String, Path>, initial: Boolean): List<Pair<String, Source>> {
        require(!initial || files.size <= MAX_FILES) {
            "Hosted environment preparation supports at most 50 files"
        }
        val destinations = files.keys.toList()
        destinations.forEach { destination ->
            validateDestination(destination)
            require(destinations.none { it != destination && destination.startsWith("$it/") }) {
                "Hosted destinations cannot overlap a parent file"
            }
        }
        var total = 0L
        return files.map { (destination, input) ->
            val source = input.toAbsolutePath().normalize()
            val snapshot = attributes(source)
            require(snapshot.isRegularFile) { "Select a regular file, not a symlink" }
            val size = snapshot.size()
            require(size <= MAX_BYTES) { "A hosted file must be at most 50 MiB" }
            total += size
            require(!initial || total <= MAX_BYTES) {
                "Prepared hosted files must total at most 50 MiB"
            }
            destination to Source(source, snapshot)
        }
    }

    private fun validateDestination(path: String) {
        require(path.codePointCount(0, path.length) <= 4096) {
            "Hosted file paths must be at most 4096 characters"
        }
        require(path.startsWith("/workspace/") && '\u0000' !in path && '\\' !in path) {
            "Hosted file paths must be absolute paths beneath /workspace"
        }
        val parts = path.removePrefix("/workspace/").split('/')
        require(parts.all { it.isNotEmpty() && it != "." && it != ".." }) {
            "Hosted file paths cannot contain empty or relative components"
        }
        require(
            parts.first() != ".codex" &&
                parts.first() != ".managed-agents" &&
                !parts.first().startsWith(".managed-agents-") &&
                path != "/workspace/outputs"
        ) {
            "The hosted destination is reserved"
        }
    }

    private fun directoryFiles(
        source: Path,
        destination: String,
        include: List<String>,
    ): Map<String, Path> {
        require(include.isNotEmpty()) { "Specify at least one include glob" }
        val selectedRoot = attributes(source)
        require(selectedRoot.isDirectory) { "Select a directory, not a symlink" }
        val root = source.toRealPath()
        require(
            sameIdentity(selectedRoot, attributes(source)) &&
                sameIdentity(selectedRoot, attributes(root))
        ) {
            "The selected directory changed during resolution"
        }
        val matchers = include.map { root.fileSystem.getPathMatcher("glob:$it") }
        val files = linkedMapOf<String, Path>()
        Files.walk(root).use { paths ->
            paths.forEach { path ->
                val relative = root.relativize(path)
                if (
                    path != root &&
                        matchers.any { it.matches(relative) } &&
                        !Files.isDirectory(path, NOFOLLOW_LINKS)
                ) {
                    require(!Files.isSymbolicLink(path)) {
                        "Selected directory entries cannot be symlinks"
                    }
                    files[destination.trimEnd('/') + "/" + relative.joinToString("/")] = path
                    require(files.size <= MAX_FILES) {
                        "Hosted environment preparation supports at most 50 files"
                    }
                }
            }
        }
        require(sameIdentity(selectedRoot, attributes(root))) {
            "The selected directory changed during enumeration"
        }
        return files
    }
}
