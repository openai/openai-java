// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.core.http

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.MultipartField

/** Preserve explicitly encoded fields as single, filename-less parts. */
@JvmSynthetic
internal fun encodeMultipartFields(
    jsonMapper: JsonMapper,
    fields: Map<String, MultipartField<*>>,
    encodings: Map<String, Pair<String, Boolean>>,
): Map<String, MultipartField<*>> =
    fields
        .filterValues { !it.value.isMissing() }
        .mapValues { (name, field) ->
            val encoding = encodings[name] ?: return@mapValues field
            val node = jsonMapper.valueToTree<JsonNode>(field.value)
            val text =
                if (encoding.second) {
                    jsonMapper.writeValueAsString(node)
                } else {
                    require(node.isTextual) { "Multipart field $name must be a string" }
                    node.textValue()
                }
            MultipartField.builder<String>().value(text).contentType(encoding.first).build()
        }
