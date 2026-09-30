package com.openai.lib.beta.agents

import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.extractFunctionInfo
import com.openai.core.responseTypeFromJson
import com.openai.core.toJsonString
import com.openai.models.beta.agents.AgentTool
import java.util.concurrent.CompletionStage
import java.util.function.Function

/**
 * A beta Agent function definition and its local, typed application callback. Argument classes use
 * the SDK's class-based schema and Jackson deserialization conventions. Bind dependencies with a
 * closure or method reference; only the argument class becomes part of the hosted definition.
 */
class AgentFunctionTool<R>
private constructor(
    private val definition: AgentTool,
    private val handler: Function<Map<String, Any?>, R>,
) {
    /** Add this definition to the agent's tools when creating or updating its configuration. */
    fun definition(): AgentTool = definition

    fun name(): String = definition.asFunction().name()

    /** Register with `toolHandler`, or `asyncToolHandler` for a binding created by [ofAsync]. */
    fun handler(): Function<Map<String, Any?>, R> = handler

    companion object {
        /**
         * The callback returns the same string, map, content list, or null as a raw tool handler.
         */
        @JvmStatic
        fun <T> of(parametersType: Class<T>, handler: Function<T, *>): AgentFunctionTool<Any?> =
            bind(parametersType, Function { handler.apply(it) })

        /** The existing stream dispatcher awaits the callback's stage before continuing. */
        @JvmStatic
        fun <T> ofAsync(
            parametersType: Class<T>,
            handler: Function<T, out CompletionStage<*>>,
        ): AgentFunctionTool<CompletionStage<*>> =
            bind(parametersType, Function { handler.apply(it) })

        private fun <T, R> bind(
            parametersType: Class<T>,
            handler: Function<T, R>,
        ): AgentFunctionTool<R> {
            val info = extractFunctionInfo(parametersType, JsonSchemaLocalValidation.YES)
            val definition =
                AgentTool.ofFunction(
                    AgentTool.Function.builder()
                        .name(info.name)
                        .description(info.description ?: "")
                        .deferLoading(false)
                        .parameters(JsonValue.fromJsonNode(info.schema))
                        .build()
                )
            return AgentFunctionTool(
                definition,
                Function { arguments ->
                    handler.apply(responseTypeFromJson(toJsonString(arguments), parametersType))
                },
            )
        }
    }
}
