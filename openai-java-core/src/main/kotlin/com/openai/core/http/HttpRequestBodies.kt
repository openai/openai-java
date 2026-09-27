@file:JvmName("HttpRequestBodies")

package com.openai.core.http

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.node.JsonNodeType
import com.fasterxml.jackson.databind.node.POJONode
import com.openai.core.MultipartField
import com.openai.core.multipartValueToTree
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.Collections
import java.util.IdentityHashMap
import java.util.UUID
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletionException
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.jvm.optionals.getOrNull

@JvmSynthetic
internal inline fun <reified T> json(jsonMapper: JsonMapper, value: T): HttpRequestBody =
    object : HttpRequestBody {
        private val bytes: ByteArray by lazy { jsonMapper.writeValueAsBytes(value) }

        override fun writeTo(outputStream: OutputStream) = outputStream.write(bytes)

        override fun contentType(): String = "application/json"

        override fun contentLength(): Long = bytes.size.toLong()

        override fun repeatable(): Boolean = true

        override fun close() {}
    }

@JvmSynthetic
internal fun multipartFormData(
    jsonMapper: JsonMapper,
    fields: Map<String, MultipartField<*>>,
): HttpRequestBody {
    // Only newly retained union/list streams need restoration of the serializer's abort cleanup.
    val retainedStreams = Collections.newSetFromMap(IdentityHashMap<InputStream, Boolean>())
    val closeAttempts =
        Collections.synchronizedSet(
            Collections.newSetFromMap(IdentityHashMap<InputStream, Boolean>())
        )
    fun closeStream(stream: InputStream) {
        if (closeAttempts.add(stream)) stream.close()
    }
    try {
        return MultipartBody.Builder()
            .apply {
                fields.forEach { (name, field) ->
                    val knownValue = field.value.asKnown().getOrNull()
                    val parts =
                        if (knownValue is InputStream) {
                            // Read directly from the `InputStream` instead of reading it all
                            // into memory due to the `jsonMapper` serialization below.
                            sequenceOf(name to knownValue)
                        } else {
                            val node = jsonMapper.multipartValueToTree(field.value, retainedStreams)
                            serializePart(name, node)
                        }

                    parts.forEach { (name, bytes) ->
                        val partBody =
                            if (bytes is ByteArrayInputStream) {
                                retainedStreams.remove(bytes)
                                val byteArray = bytes.use { it.readBytes() }

                                object : HttpRequestBody {

                                    override fun writeTo(outputStream: OutputStream) {
                                        outputStream.write(byteArray)
                                    }

                                    override fun contentType(): String = field.contentType

                                    override fun contentLength(): Long = byteArray.size.toLong()

                                    override fun repeatable(): Boolean = true

                                    override fun close() {}
                                }
                            } else {
                                object : HttpRequestBody {

                                    override fun writeTo(outputStream: OutputStream) {
                                        bytes.copyTo(outputStream)
                                    }

                                    override fun contentType(): String = field.contentType

                                    override fun contentLength(): Long = -1L

                                    override fun repeatable(): Boolean = false

                                    override fun close() = closeStream(bytes)
                                }
                            }

                        addPart(
                            MultipartBody.Part.create(
                                name,
                                field.filename().getOrNull(),
                                field.contentType,
                                partBody,
                            )
                        )
                    }
                }
            }
            .build(retainedStreams.toList(), ::closeStream)
    } catch (failure: Throwable) {
        retainedStreams.forEach { stream ->
            try {
                stream.close()
            } catch (closeFailure: Throwable) {
                if (closeFailure !== failure) failure.addSuppressed(closeFailure)
            }
        }
        throw failure
    }
}

private fun serializePart(name: String, node: JsonNode): Sequence<Pair<String, InputStream>> =
    when (node.nodeType) {
        JsonNodeType.MISSING,
        JsonNodeType.NULL -> emptySequence()
        JsonNodeType.BINARY -> sequenceOf(name to node.binaryValue().inputStream())
        JsonNodeType.STRING -> sequenceOf(name to node.textValue().byteInputStream())
        JsonNodeType.BOOLEAN -> sequenceOf(name to node.booleanValue().toString().byteInputStream())
        JsonNodeType.NUMBER -> sequenceOf(name to node.numberValue().toString().byteInputStream())
        JsonNodeType.ARRAY ->
            node.elements().asSequence().flatMap { element -> serializePart("$name[]", element) }
        JsonNodeType.OBJECT ->
            node.fields().asSequence().flatMap { (key, value) ->
                serializePart("$name[$key]", value)
            }
        JsonNodeType.POJO -> {
            val stream =
                (node as POJONode).pojo as? InputStream
                    ?: throw OpenAIInvalidDataException("Unexpected multipart embedded value")
            sequenceOf(name to stream)
        }
        null -> throw OpenAIInvalidDataException("Unexpected JsonNode type: ${node.nodeType}")
    }

private class MultipartBody
private constructor(
    private val boundary: String,
    private val parts: List<Part>,
    private val retainedStreams: List<InputStream>,
    private val closeStream: (InputStream) -> Unit,
) : HttpRequestBody, MultipartTransportGuard {
    private val closed = AtomicBoolean()
    private val cancellationLock = Any()
    private var cancelled = false

    override fun <T> beforeTransport(action: () -> T): T =
        synchronized(cancellationLock) {
            if (cancelled) throw CancellationException("Multipart upload was cancelled")
            action()
        }

    fun cancel(failure: Throwable) =
        synchronized(cancellationLock) {
            cancelled = true
            // Cancellation is terminal: no transport can take ownership of direct parts later.
            try {
                close()
            } catch (closeFailure: Throwable) {
                if (closeFailure !== failure) failure.addSuppressed(closeFailure)
            }
        }

    private val boundaryBytes: ByteArray = boundary.toByteArray()
    private val contentType = "multipart/form-data; boundary=$boundary"

    // This must remain in sync with `contentLength`.
    override fun writeTo(outputStream: OutputStream) {
        parts.forEach { part ->
            outputStream.write(DASHDASH)
            outputStream.write(boundaryBytes)
            outputStream.write(CRLF)

            outputStream.write(CONTENT_DISPOSITION)
            outputStream.write(part.contentDisposition.toByteArray())
            outputStream.write(CRLF)

            outputStream.write(CONTENT_TYPE)
            outputStream.write(part.contentType.toByteArray())
            outputStream.write(CRLF)

            outputStream.write(CRLF)
            part.body.writeTo(outputStream)
            outputStream.write(CRLF)
        }

        outputStream.write(DASHDASH)
        outputStream.write(boundaryBytes)
        outputStream.write(DASHDASH)
        outputStream.write(CRLF)
    }

    override fun contentType(): String = contentType

    // This must remain in sync with `writeTo`.
    override fun contentLength(): Long {
        var byteCount = 0L

        parts.forEach { part ->
            val contentLength = part.body.contentLength()
            if (contentLength == -1L) {
                return -1L
            }

            byteCount +=
                DASHDASH.size +
                    boundaryBytes.size +
                    CRLF.size +
                    CONTENT_DISPOSITION.size +
                    part.contentDisposition.toByteArray().size +
                    CRLF.size +
                    CONTENT_TYPE.size +
                    part.contentType.toByteArray().size +
                    CRLF.size +
                    CRLF.size +
                    contentLength +
                    CRLF.size
        }

        byteCount += DASHDASH.size + boundaryBytes.size + DASHDASH.size + CRLF.size
        return byteCount
    }

    override fun repeatable(): Boolean = parts.all { it.body.repeatable() }

    override fun close() {
        if (closed.compareAndSet(false, true)) {
            AutoCloseable { closeRetained() }.use { closeAll(parts) { it.body.close() } }
        }
    }

    fun closeRetained() = closeAll(retainedStreams, closeStream)

    class Builder {
        private val boundary = UUID.randomUUID().toString()
        private val parts: MutableList<Part> = mutableListOf()

        fun addPart(part: Part) = apply { parts.add(part) }

        fun build(retainedStreams: List<InputStream>, closeStream: (InputStream) -> Unit) =
            MultipartBody(boundary, parts.toImmutable(), retainedStreams, closeStream)
    }

    class Part
    private constructor(
        val contentDisposition: String,
        val contentType: String,
        val body: HttpRequestBody,
    ) {
        companion object {
            fun create(
                name: String,
                filename: String?,
                contentType: String,
                body: HttpRequestBody,
            ): Part {
                val disposition = buildString {
                    append("form-data; name=")
                    appendQuotedString(name)
                    if (filename != null) {
                        append("; filename=")
                        appendQuotedString(filename)
                    }
                }
                return Part(disposition, contentType, body)
            }
        }
    }

    companion object {
        private val CRLF = byteArrayOf('\r'.code.toByte(), '\n'.code.toByte())
        private val DASHDASH = byteArrayOf('-'.code.toByte(), '-'.code.toByte())
        private val CONTENT_DISPOSITION = "Content-Disposition: ".toByteArray()
        private val CONTENT_TYPE = "Content-Type: ".toByteArray()

        private fun StringBuilder.appendQuotedString(key: String) {
            append('"')
            for (ch in key) {
                when (ch) {
                    '\n' -> append("%0A")
                    '\r' -> append("%0D")
                    '"' -> append("%22")
                    else -> append(ch)
                }
            }
            append('"')
        }
    }
}

@JvmSynthetic internal fun HttpRequestBody?.isMultipartUpload(): Boolean = this is MultipartBody

/**
 * Serialize cancellation with a deferred transport handoff, including authentication and retries.
 */
@JvmSynthetic
internal fun <T> HttpRequestBody?.beforeMultipartTransport(action: () -> T): T =
    if (this is MultipartTransportGuard) beforeTransport(action) else action()

@JvmSynthetic
internal fun HttpRequestBody?.cancelMultipart(failure: Throwable) {
    if (this is MultipartBody) cancel(failure)
}

/** Release multipart ownership when a request fails before or during transport handoff. */
@JvmSynthetic
internal fun HttpRequestBody?.closeMultipartOnFailure(failure: Throwable) {
    if (this !is MultipartBody) return
    val primary =
        if (failure is CompletionException && failure.cause != null) failure.cause!! else failure
    try {
        closeRetained()
    } catch (closeFailure: Throwable) {
        if (closeFailure !== primary) primary.addSuppressed(closeFailure)
    }
}

private inline fun <T> closeAll(items: Iterable<T>, close: (T) -> Unit) {
    var failure: Throwable? = null
    items.forEach { item ->
        try {
            close(item)
        } catch (closeFailure: Throwable) {
            if (failure == null) failure = closeFailure
            else if (failure !== closeFailure) failure!!.addSuppressed(closeFailure)
        }
    }
    failure?.let { throw it }
}
