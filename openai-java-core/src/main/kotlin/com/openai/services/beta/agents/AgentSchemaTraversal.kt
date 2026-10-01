package com.openai.services.beta.agents

import com.fasterxml.jackson.databind.JsonNode

// Walk the schema locations emitted by the SDK's class-based schema generator. Policies remain
// with their caller: function parameters and structured output support different constraints.
@JvmSynthetic
internal fun forEachAgentSchemaNode(schema: JsonNode, visit: (JsonNode) -> Unit) {
    visit(schema)
    listOf("properties", "\$defs", "anyOf").forEach { keyword ->
        schema[keyword]?.forEach { forEachAgentSchemaNode(it, visit) }
    }
    schema["items"]?.let { forEachAgentSchemaNode(it, visit) }
}
