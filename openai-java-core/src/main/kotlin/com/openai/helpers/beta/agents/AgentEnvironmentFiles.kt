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
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.LinkOption.NOFOLLOW_LINKS
import java.nio.file.Path
import java.nio.file.StandardOpenOption.READ
import java.nio.file.attribute.BasicFileAttributes
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.atomic.AtomicReference

/**
 * Path-based file preparation and live staging for beta Agents hosted environments. Sources must be
 * application-owned and stable during preparation; this is not a filesystem sandbox.
 */
object AgentEnvironmentFiles {
    @JvmStatic
    @JvmOverloads
    fun prepare(
        client: OpenAIClient,
        files: Map<String, Path>,
        options: RequestOptions = RequestOptions.none(),
    ): PreparedAgentFiles = prepare(client, preflight(files), options)

    private fun prepare(
        client: OpenAIClient,
        selected: List<Pair<String, Source>>,
        options: RequestOptions,
    ): PreparedAgentFiles {
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
        val selectedFiles = files.toMap()
        return prepareAsync(client, options) { preflight(selectedFiles) }
    }

    private fun prepareAsync(
        client: OpenAIClientAsync,
        options: RequestOptions,
        select: () -> List<Pair<String, Source>>,
    ): CompletableFuture<PreparedAgentFiles> {
        val result = CompletableFuture<PreparedAgentFiles>()
        val activeSource = AtomicReference<InputStream?>()
        fun closeSource(input: InputStream) {
            if (activeSource.compareAndSet(input, null)) input.close()
        }
        result.whenComplete { _, _ ->
            if (result.isCancelled) runCatching { activeSource.getAndSet(null)?.close() }
        }
        CompletableFuture.runAsync {
            try {
                if (result.isDone) return@runAsync
                val selected = select()
                if (selected.size > 1)
                    client.withOptions {
                        require(it.build().headers.values("Idempotency-Key").isEmpty()) {
                            "A multi-file preparation cannot reuse an Idempotency-Key"
                        }
                    }
                val prepared = mutableListOf<HostedEnvironmentFileParam>()
                fun next(index: Int) {
                    if (result.isDone) return
                    if (index == selected.size) {
                        result.complete(PreparedAgentFiles(prepared))
                        return
                    }
                    try {
                        val (destination, source) = selected[index]
                        val params = uploadParams(source)
                        val input = params.file()
                        activeSource.set(input)
                        if (result.isDone) {
                            closeSource(input)
                            return
                        }
                        val request =
                            try {
                                client.files().create(params, options)
                            } catch (error: Throwable) {
                                runCatching { closeSource(input) }
                                throw error
                            }
                        // Keep the generated service future alive so late responses are parsed and
                        // closed.
                        request.whenCompleteAsync { uploaded, failure ->
                            try {
                                if (failure != null) throw failure
                                prepared.add(reference(destination, uploaded.id()))
                                closeSource(input)
                                next(index + 1)
                            } catch (error: Throwable) {
                                runCatching { closeSource(input) }
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
            } catch (error: Throwable) {
                result.completeExceptionally(unwrap(error))
            }
        }
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
    ): CompletableFuture<PreparedAgentFiles> {
        val patterns = include.toList()
        return prepareAsync(client, options) { directoryFiles(source, destination, patterns) }
    }

    @JvmStatic
    @JvmOverloads
    fun upload(
        client: OpenAIClient,
        environmentId: String,
        source: Path,
        destination: String,
        options: RequestOptions = RequestOptions.none(),
    ): StagedAgentFile {
        val selected = preflight(mapOf(destination to source)).single()
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
        result.whenComplete { _, _ -> if (result.isCancelled) prepared.cancel(true) }
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

    private data class DirectoryRoot(val path: Path, val attributes: BasicFileAttributes)

    private data class Source(
        val path: Path,
        val attributes: BasicFileAttributes,
        val root: DirectoryRoot? = null,
    )

    private fun verifyDirectoryPath(path: Path, root: DirectoryRoot) {
        require(sameIdentity(root.attributes, attributes(root.path))) {
            "The selected directory changed before upload"
        }
        val resolved = path.toRealPath()
        require(resolved.startsWith(root.path) && resolved == path) {
            "Selected directory entries cannot traverse a symlink"
        }
    }

    private fun verifySource(source: Source) {
        source.root?.let { verifyDirectoryPath(source.path, it) }
        require(sameIdentity(source.attributes, attributes(source.path))) {
            "The selected file changed before upload"
        }
    }

    private fun attributes(path: Path): BasicFileAttributes =
        Files.readAttributes(path, BasicFileAttributes::class.java, NOFOLLOW_LINKS)

    private fun sameIdentity(before: BasicFileAttributes, after: BasicFileAttributes): Boolean =
        before.fileKey() == after.fileKey() &&
            before.creationTime() == after.creationTime() &&
            before.isRegularFile == after.isRegularFile &&
            before.isDirectory == after.isDirectory

    private fun uploadParams(source: Source): FileCreateParams {
        verifySource(source)
        // Non-default providers may only support READ. Sources must remain application-owned
        // and stable; the attribute checks below are not a filesystem sandbox.
        val openOptions =
            if (source.path.fileSystem == FileSystems.getDefault()) setOf(READ, NOFOLLOW_LINKS)
            else setOf(READ)
        val channel = Files.newByteChannel(source.path, openOptions)
        try {
            verifySource(source)
            require(channel.size() == source.attributes.size()) {
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

    private fun preflight(files: Map<String, Path>): List<Pair<String, Source>> {
        val destinations = files.keys.toHashSet()
        destinations.forEach { destination ->
            validateDestination(destination)
            var separator = destination.indexOf('/', "/workspace/".length)
            while (separator != -1) {
                require(destination.substring(0, separator) !in destinations) {
                    "Hosted destinations cannot overlap a parent file"
                }
                separator = destination.indexOf('/', separator + 1)
            }
        }
        return files.map { (destination, input) ->
            val source = input.toAbsolutePath()
            val snapshot = attributes(source)
            require(snapshot.isRegularFile) { "Select a regular file, not a symlink" }
            destination to Source(source, snapshot)
        }
    }

    private fun validateDestination(path: String) {
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
    ): List<Pair<String, Source>> {
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
        val selectedDirectory = DirectoryRoot(root, selectedRoot)
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
                    verifyDirectoryPath(path, selectedDirectory)
                    files[destination.trimEnd('/') + "/" + relative.joinToString("/")] = path
                }
            }
        }
        val selected = preflight(files)
        require(sameIdentity(selectedRoot, attributes(root))) {
            "The selected directory changed during enumeration"
        }
        return selected.map { (destination, file) ->
            val scoped = file.copy(root = selectedDirectory)
            verifySource(scoped)
            destination to scoped
        }
    }
}
