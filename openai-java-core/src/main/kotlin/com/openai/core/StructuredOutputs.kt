package com.openai.core

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.github.victools.jsonschema.generator.Option
import com.github.victools.jsonschema.generator.OptionPreset
import com.github.victools.jsonschema.generator.SchemaGenerator
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder
import com.github.victools.jsonschema.module.jackson.JacksonModule
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ResponseFormatJsonSchema

// The SDK `ObjectMappers.jsonMapper()` requires that all fields of classes be marked with
// `@JsonProperty`, which is not desirable in this context, as it impedes usability. Therefore, a
// custom JSON mapper configuration is required.
private val MAPPER =
    JsonMapper.builder()
        .addModule(kotlinModule())
        .addModule(Jdk8Module())
        .addModule(JavaTimeModule())
        .build()

internal fun <T> fromClass(
    type: Class<T>,
    localValidation: Boolean = true,
): ResponseFormatJsonSchema {
    val schema = extractSchema(type)

    if (localValidation) {
        val validator = JsonSchemaValidator.create().validate(schema)

        if (!validator.isValid()) {
            throw IllegalArgumentException(
                "Local validation failed for JSON schema derived from $type:\n" +
                    validator.errors().joinToString("\n") { " - $it" }
            )
        }
    }

    return ResponseFormatJsonSchema.builder()
        .jsonSchema(
            ResponseFormatJsonSchema.JsonSchema.builder()
                .name("json-schema-from-${type.simpleName}")
                .schema(JsonValue.from(schema))
                .build()
        )
        .build()
}

internal fun <T> extractSchema(type: Class<T>): JsonNode {
    // Validation is not performed by this function, as it allows extraction of the schema and
    // validation of the schema to be controlled more easily when unit testing, as no exceptions
    // will be thrown and any recorded validation errors can be inspected at leisure by the tests.
    val configBuilder =
        SchemaGeneratorConfigBuilder(
                com.github.victools.jsonschema.generator.SchemaVersion.DRAFT_2020_12,
                OptionPreset.PLAIN_JSON,
            )
            // Add `"additionalProperties" : false` to all object schemas (see OpenAI).
            .with(Option.FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT)
            // Use `JacksonModule` to support the use of Jackson annotations to set property and
            // class names and descriptions and to mark fields with `@JsonIgnore`.
            .with(JacksonModule())

    configBuilder
        .forFields()
        // For OpenAI schemas, _all_ properties _must_ be required. Override the interpretation of
        // the Jackson `required` parameter to the `@JsonProperty` annotation: it will always be
        // assumed to be `true`, even if explicitly `false` and even if there is no `@JsonProperty`
        // annotation present.
        .withRequiredCheck { true }

    return SchemaGenerator(configBuilder.build()).generateSchema(type)
}

internal fun <T> fromJson(json: String, type: Class<T>): T =
    try {
        MAPPER.readValue(json, type)
    } catch (e: Exception) {
        // The JSON document is included in the exception message to aid diagnosis of the problem.
        // It is the responsibility of the SDK user to ensure that exceptions that may contain
        // sensitive data are not exposed in logs.
        throw OpenAIInvalidDataException("Error parsing JSON: $json", e)
    }
