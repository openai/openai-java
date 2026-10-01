package com.openai.services.beta.agents

import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.extractSchema
import com.openai.core.responseTypeFromJson
import com.openai.core.validateSchema
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.TextFormatParam

/** A beta Agents output schema and the Java type used to parse its completed answer. */
class AgentOutputType<T : Any>
private constructor(private val type: Class<T>, private val format: TextFormatParam) {
    companion object {
        /**
         * Derives and validates the same supported schema subset as existing structured outputs.
         */
        @JvmStatic
        fun <T : Any> of(type: Class<T>): AgentOutputType<T> {
            val schema = validateSchema(extractSchema(type), type, JsonSchemaLocalValidation.YES)
            require(schema.path("type").asText() == "object") {
                "Agents output types must have an object root"
            }
            require(listOf("oneOf", "anyOf", "allOf", "enum", "not").none(schema::has)) {
                "Agents output schemas cannot use root composition or enum keywords"
            }
            return AgentOutputType(
                type,
                TextFormatParam.ofJsonSchema(
                    TextFormatParam.JsonSchema.builder()
                        .schema(
                            TextFormatParam.JsonSchema.Schema.builder()
                                .putAllAdditionalProperties(
                                    JsonValue.fromJsonNode(schema).asObject().get()
                                )
                                .build()
                        )
                        .build()
                ),
            )
        }
    }

    /** Ordinary wire format; contains no Responses-only name or strict envelope fields. */
    fun format(): TextFormatParam = format

    /**
     * Set this on the agent at creation; parsing follow-ups never changes session configuration.
     */
    fun text(): AgentTextParam = AgentTextParam.builder().format(format).build()

    /** Parses a completed result with the SDK's existing Java structured-output mapper. */
    fun parse(result: AgentTurnResult): ParsedAgentTurnResult<T> =
        try {
            ParsedAgentTurnResult(result, responseTypeFromJson(result.outputText(), type))
        } catch (cause: Exception) {
            throw AgentOutputParseException(result, cause)
        }
}
