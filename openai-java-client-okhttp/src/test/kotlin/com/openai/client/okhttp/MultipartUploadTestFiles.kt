package com.openai.client.okhttp

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.openai.core.jsonMapper
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.mockwebserver.MockWebServer

internal data class FileBehavior(
    val closeFailure: IOException? = null,
    val readFailure: IOException? = null,
    val equalityGroup: String? = null,
    val beforeClose: (() -> Unit)? = null,
)

internal class ObservedFileInputStream(path: Path, private val behavior: FileBehavior) :
    FileInputStream(path.toFile()) {
    val closeCalls = AtomicInteger()
    val readCalls = AtomicInteger()

    override fun read(): Int {
        readCalls.incrementAndGet()
        behavior.readFailure?.let { throw it }
        return super.read()
    }

    override fun read(bytes: ByteArray): Int {
        readCalls.incrementAndGet()
        behavior.readFailure?.let { throw it }
        return super.read(bytes)
    }

    override fun read(bytes: ByteArray, offset: Int, length: Int): Int {
        readCalls.incrementAndGet()
        behavior.readFailure?.let { throw it }
        return super.read(bytes, offset, length)
    }

    override fun close() {
        if (closeCalls.incrementAndGet() == 1) {
            behavior.beforeClose?.invoke()
        }
        super.close()
        behavior.closeFailure?.let { throw it }
    }

    override fun equals(other: Any?): Boolean =
        if (behavior.equalityGroup == null) this === other
        else
            other is ObservedFileInputStream &&
                behavior.equalityGroup == other.behavior.equalityGroup

    override fun hashCode(): Int =
        behavior.equalityGroup?.hashCode() ?: System.identityHashCode(this)
}

internal fun withUploadFixture(
    directory: Path,
    vararg behaviors: FileBehavior,
    block: (List<ObservedFileInputStream>, MockWebServer) -> Unit,
) {
    val files =
        behaviors.mapIndexed { index, behavior ->
            val path = Files.createTempFile(directory, "multipart-compatibility", ".bin")
            Files.write(path, "file $index payload".toByteArray())
            ObservedFileInputStream(path, behavior)
        }
    try {
        MockWebServer().use { server -> block(files, server) }
    } finally {
        // Observe descriptors and close counts before fixture cleanup can hide a leak.
        files.forEach {
            try {
                it.close()
            } catch (_: IOException) {}
        }
    }
}

/** A caller-configured buffering serializer exercises failures before transport owns the body. */
internal fun bufferingUploadMapper(): JsonMapper =
    jsonMapper()
        .copy()
        .registerModule(
            SimpleModule()
                .addSerializer(
                    InputStream::class.java,
                    object : JsonSerializer<InputStream>() {
                        override fun serialize(
                            value: InputStream,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            generator.writeTree(jsonMapper().valueToTree<JsonNode>(value))
                        }
                    },
                )
        ) as JsonMapper
