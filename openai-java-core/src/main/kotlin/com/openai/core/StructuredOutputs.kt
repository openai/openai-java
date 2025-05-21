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
import com.openai.models.responses.ResponseFormatTextJsonSchemaConfig
import com.openai.models.responses.ResponseTextConfig

// The SDK `ObjectMappers.jsonMapper()` requires that all fields of classes be marked with
// `@JsonProperty`, which is not desirable in this context, as it impedes usability. Therefore, a
// custom JSON mapper configuration is required.
private val MAPPER =
    JsonMapper.builder()
        .addModule(kotlinModule())
        .addModule(Jdk8Module())
        .addModule(JavaTimeModule())
        .build()

/**
 * Builds a response format using a JSON schema derived from the structure of an arbitrary Java
 * class.
 */
@JvmSynthetic
internal fun <T> responseFormatFromClass(
    type: Class<T>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): ResponseFormatJsonSchema =
    ResponseFormatJsonSchema.builder()
        .jsonSchema(
            ResponseFormatJsonSchema.JsonSchema.builder()
                .name("json-schema-from-${type.simpleName}")
                .schema(JsonValue.fromJsonNode(extractAndValidateSchema(type, localValidation)))
                // Ensure the model's output strictly adheres to this JSON schema. This is the
                // essential "ON switch" for Structured Outputs.
                .strict(true)
                .build()
        )
        .build()

private fun <T> extractAndValidateSchema(
    type: Class<T>,
    localValidation: JsonSchemaLocalValidation,
): JsonNode {
    val schema = extractSchema(type)

    if (localValidation == JsonSchemaLocalValidation.YES) {
        val validator = JsonSchemaValidator.create().validate(schema)

        require(validator.isValid()) {
            "Local validation failed for JSON schema derived from $type:\n" +
                validator.errors().joinToString("\n") { " - $it" }
        }
    }

    return schema
}

/**
 * Builds a text configuration with its format set to a JSON schema derived from the structure of an
 * arbitrary Java class.
 */
@JvmSynthetic
internal fun <T> textConfigFromClass(
    type: Class<T>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): ResponseTextConfig =
    ResponseTextConfig.builder()
        .format(
            ResponseFormatTextJsonSchemaConfig.builder()
                .name("json-schema-from-${type.simpleName}")
                .schema(JsonValue.fromJsonNode(extractAndValidateSchema(type, localValidation)))
                // Ensure the model's output strictly adheres to this JSON schema. This is the
                // essential "ON switch" for Structured Outputs.
                .strict(true)
                .build()
        )
        .build()

/**
 * Derives a JSON schema from the structure of an arbitrary Java class.
 *
 * Validation is not performed by this function, as it allows extraction of the schema and
 * validation of the schema to be controlled more easily when unit testing, as no exceptions will be
 * thrown and any recorded validation errors can be inspected at leisure by the tests.
 */
@JvmSynthetic
internal fun <T> extractSchema(type: Class<T>): JsonNode {
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

/**
 * Creates an instance of a Java class using data from a JSON. The JSON data should conform to the
 * JSON schema previously extracted from the Java class.
 */
@JvmSynthetic
internal fun <T> responseTypeFromJson(json: String, responseType: Class<T>): T =
    try {
        MAPPER.readValue(json, responseType)
    } catch (e: Exception) {
        // The JSON document is included in the exception message to aid diagnosis of the problem.
        // It is the responsibility of the SDK user to ensure that exceptions that may contain
        // sensitive data are not exposed in logs.
        throw OpenAIInvalidDataException("Error parsing JSON: $json", e)
    }
