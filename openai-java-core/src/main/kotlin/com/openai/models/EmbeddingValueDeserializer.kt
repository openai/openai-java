package com.openai.models

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import java.io.IOException
import java.util.Optional

/** JsonDeserializer for EmbeddingValue */
class EmbeddingValueDeserializer : JsonDeserializer<EmbeddingValue>() {
    @Throws(IOException::class)

    /*
     * Deserialize the JSON representation of an EmbeddingValue.
     * The JSON can either be an array of floats or a base64 string.
     */
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): EmbeddingValue {
        val node = jp.codec.readTree<JsonNode>(jp)
        val embeddingValue = EmbeddingValue()

        if (node.isArray) {
            val floats = mutableListOf<Double>()
            (node as ArrayNode).forEach { item -> floats.add(item.asDouble()) }
            embeddingValue.floatEmbedding = Optional.of(floats)
        } else if (node.isTextual) {
            embeddingValue.base64Embedding = Optional.of(node.asText())
        }
        return embeddingValue
    }
}
