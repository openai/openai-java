package com.openai.core

import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.github.victools.jsonschema.generator.Option
import com.github.victools.jsonschema.generator.OptionPreset
import com.github.victools.jsonschema.generator.SchemaGenerator
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder
import com.github.victools.jsonschema.module.jackson.JacksonModule
import com.github.victools.jsonschema.module.swagger2.Swagger2Module
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.FunctionDefinition
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.chat.completions.ChatCompletionTool
import com.openai.models.responses.FunctionTool
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
internal fun responseFormatFromClass(
    type: Class<*>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): ResponseFormatJsonSchema =
    ResponseFormatJsonSchema.builder()
        .jsonSchema(
            ResponseFormatJsonSchema.JsonSchema.builder()
                .name("json-schema-from-${type.simpleName}")
                .schema(
                    JsonValue.fromJsonNode(
                        validateSchema(extractSchema(type), type, localValidation)
                    )
                )
                // Ensure the model's output strictly adheres to this JSON schema. This is the
                // essential "ON switch" for Structured Outputs.
                .strict(true)
                .build()
        )
        .build()

/**
 * Validates the given JSON schema with respect to OpenAI's JSON schema restrictions.
 *
 * @param schema The JSON schema to be validated.
 * @param sourceType The class from which the JSON schema was derived. This is only used in error
 *   messages.
 * @param localValidation Set to [JsonSchemaLocalValidation.YES] to perform the validation. Other
 *   values will cause validation to be skipped.
 */
@JvmSynthetic
internal fun validateSchema(
    schema: ObjectNode,
    sourceType: Class<*>,
    localValidation: JsonSchemaLocalValidation,
): ObjectNode {
    if (localValidation == JsonSchemaLocalValidation.YES) {
        val validator = JsonSchemaValidator.create().validate(schema)

        require(validator.isValid()) {
            "Local validation failed for JSON schema derived from $sourceType:\n" +
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
internal fun textConfigFromClass(
    type: Class<*>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): ResponseTextConfig =
    ResponseTextConfig.builder()
        .format(
            ResponseFormatTextJsonSchemaConfig.builder()
                .name("json-schema-from-${type.simpleName}")
                .schema(
                    JsonValue.fromJsonNode(
                        validateSchema(extractSchema(type), type, localValidation)
                    )
                )
                // Ensure the model's output strictly adheres to this JSON schema. This is the
                // essential "ON switch" for Structured Outputs.
                .strict(true)
                .build()
        )
        .build()

// "internal" instead of "private" for testing purposes.
internal data class FunctionInfo(
    val name: String,
    val description: String?,
    val schema: ObjectNode,
)

@JvmSynthetic
// "internal" instead of "private" for testing purposes.
internal fun extractFunctionInfo(
    parametersType: Class<*>,
    localValidation: JsonSchemaLocalValidation,
): FunctionInfo {
    val schema = extractSchema(parametersType)

    validateSchema(schema, parametersType, localValidation)

    // The JSON schema generator ignores the `@JsonTypeName` annotation, so it never sets the "name"
    // field at the root of the schema. Respect that annotation here and use it to set the name
    // (outside the schema). Fall back to using the simple name of the class.
    val name =
        parametersType.getAnnotation(JsonTypeName::class.java)?.value ?: parametersType.simpleName

    // The JSON schema generator will copy the `@JsonClassDescription` into the schema. If present,
    // remove it from the schema so it can be set on the function definition/tool.
    val descriptionNode: JsonNode? = schema.remove("description")
    val description: String? = descriptionNode?.textValue()

    return FunctionInfo(name, description, schema)
}

/**
 * Creates a Chat Completions API tool defining a function whose input parameters are derived from
 * the fields of a class.
 */
@JvmSynthetic
internal fun functionToolFromClass(
    parametersType: Class<*>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): ChatCompletionTool {
    val functionInfo = extractFunctionInfo(parametersType, localValidation)

    return ChatCompletionTool.builder()
        .function(
            FunctionDefinition.builder()
                .name(functionInfo.name)
                .apply { functionInfo.description?.let(::description) }
                .parameters(JsonValue.fromJsonNode(functionInfo.schema))
                // OpenAI: "Setting strict to true will ensure function calls reliably adhere to the
                // function schema, instead of being best effort. We recommend always enabling
                // strict mode."
                .strict(true)
                .build()
        )
        .build()
}

/**
 * Creates a Responses API function tool defining a function whose input parameters are derived from
 * the fields of a class.
 */
@JvmSynthetic
internal fun responseFunctionToolFromClass(
    parametersType: Class<*>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): FunctionTool {
    val functionInfo = extractFunctionInfo(parametersType, localValidation)

    return FunctionTool.builder()
        .name(functionInfo.name)
        .apply { functionInfo.description?.let(::description) }
        .parameters(JsonValue.fromJsonNode(functionInfo.schema))
        .strict(true)
        .build()
}

/**
 * Derives a JSON schema from the structure of an arbitrary Java class.
 *
 * Validation is not performed by this function, as it allows extraction of the schema and
 * validation of the schema to be controlled more easily when unit testing, as no exceptions will be
 * thrown and any recorded validation errors can be inspected at leisure by the tests.
 */
@JvmSynthetic
internal fun extractSchema(type: Class<*>): ObjectNode {
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
            // Use `Swagger2Module` to support OpenAPI Swagger 2 `@Schema` annotations to set
            // property constraints (e.g., a `"pattern"` constraint for a string property).
            .with(Swagger2Module())

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
 *
 * @throws OpenAIInvalidDataException If the JSON data cannot be parsed to an instance of the
 *   [responseType] class.
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

/**
 * Converts any object into a JSON-formatted string. For `Object` types (other than strings and
 * boxed primitives) a JSON object is created with its fields and values set from the fields of the
 * object.
 */
@JvmSynthetic internal fun toJsonString(obj: Any): String = MAPPER.writeValueAsString(obj)
