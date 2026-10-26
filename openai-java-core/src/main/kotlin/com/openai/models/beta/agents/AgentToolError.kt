package com.openai.models.beta.agents

import java.util.function.Function

/**
 * A beta, local-only diagnostic for a handled tool call. The error may contain application data.
 */
class AgentToolError
internal constructor(
    private val error: Throwable,
    private val toolName: String,
    private val sessionId: String,
    private val turnId: String,
    private val callId: String,
    private val stage: Stage,
) {
    fun error(): Throwable = error

    fun toolName(): String = toolName

    fun sessionId(): String = sessionId

    fun turnId(): String = turnId

    fun callId(): String = callId

    fun stage(): Stage = stage

    enum class Stage {
        ARGUMENTS,
        EXECUTION,
        OUTPUT,
    }
}

internal class AgentToolArgumentException(val original: Exception) :
    IllegalArgumentException(original.message, original)

internal interface AgentToolHandler<R> : Function<Map<String, Any?>, R> {
    fun applyWithDiagnostics(arguments: Map<String, Any?>): R
}

internal fun <R> invokeToolHandler(
    handler: Function<Map<String, Any?>, R>,
    arguments: Map<String, Any?>,
): R =
    if (handler is AgentToolHandler<R>) handler.applyWithDiagnostics(arguments)
    else handler.apply(arguments)
