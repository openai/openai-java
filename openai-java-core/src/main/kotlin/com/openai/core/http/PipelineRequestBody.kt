package com.openai.core.http

import java.io.OutputStream
import java.util.concurrent.atomic.AtomicBoolean

/** Request body whose terminal cleanup is owned by the authenticated request pipeline. */
internal interface PipelineOwnedRequestBody : HttpRequestBody

/** Shares one close across pre-dispatch cancellation, the transport, and terminal cleanup. */
@JvmSynthetic
internal fun HttpRequest.withPipelineOwnedBody(): HttpRequest {
    val current = body ?: return this
    if (current is PipelineOwnedRequestBody) return this
    return toBuilder().body(CloseOncePipelineRequestBody(current)).build()
}

/** Gives one transport attempt a close-isolated view of the pipeline-owned request body. */
@JvmSynthetic
internal fun HttpRequest.forPipelineAttempt(): HttpRequest {
    val current = body as? PipelineOwnedRequestBody ?: return this
    return toBuilder().body(PipelineAttemptRequestBody(current)).build()
}

/** Best-effort terminal cleanup for an authenticated request body. */
@JvmSynthetic
internal fun HttpRequest.closePipelineBody(failure: Throwable? = null) {
    val owned = body as? PipelineOwnedRequestBody ?: return
    try {
        owned.close()
    } catch (closeFailure: Throwable) {
        if (failure == null) throw closeFailure
        if (closeFailure !== failure) failure.addSuppressed(closeFailure)
    }
}

/** Best-effort terminal cleanup for cancellation or an already completed async result. */
@JvmSynthetic
internal fun HttpRequest.discardPipelineBody() {
    try {
        closePipelineBody()
    } catch (_: Throwable) {}
}

private class CloseOncePipelineRequestBody(private val delegate: HttpRequestBody) :
    PipelineOwnedRequestBody {
    private val closed = AtomicBoolean()

    override fun writeTo(outputStream: OutputStream) = delegate.writeTo(outputStream)

    override fun contentType(): String? = delegate.contentType()

    override fun contentLength(): Long = delegate.contentLength()

    override fun repeatable(): Boolean = delegate.repeatable()

    override fun close() {
        if (closed.compareAndSet(false, true)) delegate.close()
    }
}

private class PipelineAttemptRequestBody(private val delegate: PipelineOwnedRequestBody) :
    HttpRequestBody {
    override fun writeTo(outputStream: OutputStream) = delegate.writeTo(outputStream)

    override fun contentType(): String? = delegate.contentType()

    override fun contentLength(): Long = delegate.contentLength()

    override fun repeatable(): Boolean = delegate.repeatable()

    override fun close() = Unit
}
