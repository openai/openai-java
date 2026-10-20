package com.openai.helpers.beta.agents

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.extractFunctionInfo
import com.openai.core.jsonMapper
import com.openai.core.responseTypeFromJson
import com.openai.core.toJsonString
import com.openai.models.beta.agents.AgentToolArgumentException
import com.openai.models.beta.agents.AgentToolHandler
import com.openai.models.beta.agents.AgentToolParam
import java.util.concurrent.CompletionStage
import java.util.function.Function

/**
 * A beta Agent function definition and its local, typed application callback. Argument classes use
 * the SDK's class-based schema and Jackson deserialization conventions. Bind dependencies with a
 * closure or method reference; only the argument class becomes part of the hosted definition.
 * Schema annotations are preserved; validate business rules in the callback.
 */
class AgentFunctionTool<R>
private constructor(
    private val definition: AgentToolParam,
    private val handler: Function<Map<String, Any?>, R>,
) {
    /** Add this definition to the agent's tools when creating or updating its configuration. */
    fun definition(): AgentToolParam = definition

    fun name(): String = definition.asFunction().name()

    /** Register with `toolHandler`, or `asyncToolHandler` for a binding created by [ofAsync]. */
    fun handler(): Function<Map<String, Any?>, R> = handler

    /** Returns a new binding with deferred loading configured; the typed handler is unchanged. */
    fun withDeferLoading(value: Boolean): AgentFunctionTool<R> =
        AgentFunctionTool(
            AgentToolParam.ofFunction(
                definition.asFunction().toBuilder().deferLoading(value).build()
            ),
            handler,
        )

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
            require(info.schema.path("type").asText() == "object") {
                "Function parameters must be an object class"
            }
            val definition =
                AgentToolParam.ofFunction(
                    AgentToolParam.Function.builder()
                        .name(info.name)
                        .description(info.description ?: "")
                        .deferLoading(false)
                        .parameters(
                            AgentToolParam.Function.Parameters.builder()
                                .apply {
                                    info.schema.fields().forEach { (name, value) ->
                                        putAdditionalProperty(name, JsonValue.fromJsonNode(value))
                                    }
                                }
                                .build()
                        )
                        .build()
                )
            return AgentFunctionTool(
                definition,
                object : AgentToolHandler<R> {
                    private fun parse(arguments: Map<String, Any?>): T {
                        val json = toJsonString(arguments)
                        require(
                            hasArgumentShape(jsonMapper().readTree(json), info.schema, info.schema)
                        ) {
                            "Function arguments do not match the declared parameter shape"
                        }
                        return responseTypeFromJson(json, parametersType)
                    }

                    override fun apply(arguments: Map<String, Any?>): R =
                        handler.apply(parse(arguments))

                    override fun applyWithDiagnostics(arguments: Map<String, Any?>): R {
                        val parsed =
                            try {
                                parse(arguments)
                            } catch (error: Exception) {
                                throw AgentToolArgumentException(error)
                            }
                        return handler.apply(parsed)
                    }
                },
            )
        }
    }
}

// Check declared values and JSON types before Jackson supplies defaults or coerces scalar values.
private fun hasArgumentShape(value: JsonNode, schema: JsonNode, root: JsonNode): Boolean {
    schema["enum"]?.let { if (value !in it) return false }
    schema["const"]?.let { if (value != it) return false }
    schema["\$ref"]?.asText()?.let { reference ->
        if (reference != "#" && !reference.startsWith("#/")) return false
        val target = root.at(reference.substring(1))
        if (target.isMissingNode || !hasArgumentShape(value, target, root)) return false
    }
    schema["anyOf"]?.let { options ->
        if (options.none { hasArgumentShape(value, it, root) }) return false
    }
    schema["type"]?.let { type ->
        val types = if (type.isArray) type.toList() else listOf(type)
        if (
            types.none {
                when (it.asText()) {
                    "object" -> value.isObject
                    "array" -> value.isArray
                    "string" -> value.isTextual
                    "boolean" -> value.isBoolean
                    "null" -> value.isNull
                    "number" -> value.isNumber
                    "integer" ->
                        value.isNumber && value.decimalValue().stripTrailingZeros().scale() <= 0
                    else -> false
                }
            }
        )
            return false
    }
    if (value.isObject) {
        if (schema.path("required").any { !value.has(it.asText()) }) return false
        val properties = schema.path("properties")
        for ((name, child) in value.fields()) {
            val property = properties[name]
            if (property != null && !hasArgumentShape(child, property, root)) return false
            if (
                property == null &&
                    schema.path("additionalProperties").isBoolean &&
                    !schema.path("additionalProperties").asBoolean()
            )
                return false
        }
    }
    if (value.isArray) {
        schema["items"]?.let { itemSchema ->
            if (value.any { !hasArgumentShape(it, itemSchema, root) }) return false
        }
    }
    return true
}
