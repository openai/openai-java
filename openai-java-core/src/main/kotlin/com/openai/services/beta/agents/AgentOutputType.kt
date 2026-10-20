package com.openai.services.beta.agents

import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.extractSchema
import com.openai.core.jsonMapper
import com.openai.core.responseTypeFromJson
import com.openai.core.validateSchema
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.TextFormatParam

/** A beta Agents output schema and the Java type used to parse its completed answer. */
class AgentOutputType<T : Any>
private constructor(private val type: Class<T>, private val format: TextFormatParam) {
    companion object {
        /**
         * Derives and validates a class schema using the existing structured-output conventions.
         */
        @JvmStatic
        fun <T : Any> of(type: Class<T>): AgentOutputType<T> {
            val schema = validateSchema(extractSchema(type), type, JsonSchemaLocalValidation.YES)
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

    /** Parses every output-text part and returns the first parsed value in output order. */
    fun parse(result: AgentTurnResult): ParsedAgentTurnResult<T> =
        try {
            var first: T? = null
            for (message in result.messages()) {
                for (content in message.content()) {
                    val text = content.outputText().orElse(null)?.text() ?: continue
                    jsonMapper().factory.createParser(text).use { parser ->
                        require(parser.nextToken() != null) {
                            "Agents structured output must contain a JSON document"
                        }
                        parser.skipChildren()
                        require(parser.nextToken() == null) {
                            "Agents structured output must contain exactly one JSON document"
                        }
                    }
                    val parsed = requireNotNull(responseTypeFromJson(text, type))
                    if (first == null) first = parsed
                }
            }
            ParsedAgentTurnResult(result, requireNotNull(first))
        } catch (_: Exception) {
            // Parser exception messages may include output; retain it only through rawResult().
            throw AgentOutputParseException(result)
        }
}
