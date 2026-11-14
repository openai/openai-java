package com.openai.models.chat.completions

import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.extractFunctionInfo
import com.openai.core.extractSchema
import com.openai.core.validateSchema
import com.openai.models.FunctionDefinition
import com.openai.models.ResponseFormatJsonSchema

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
 * Creates a Chat Completions API tool defining a function whose input parameters are derived from
 * the fields of a class.
 */
@JvmSynthetic
internal fun functionToolFromClass(
    parametersType: Class<*>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): ChatCompletionTool {
    val functionInfo = extractFunctionInfo(parametersType, localValidation)

    return ChatCompletionTool.ofFunction(
        ChatCompletionFunctionTool.builder()
            .function(
                FunctionDefinition.builder()
                    .name(functionInfo.name)
                    .apply { functionInfo.description?.let(::description) }
                    .parameters(JsonValue.fromJsonNode(functionInfo.schema))
                    // OpenAI: "Setting strict to true will ensure function calls reliably adhere to
                    // the function schema, instead of being best effort. We recommend always
                    // enabling strict mode."
                    .strict(true)
                    .build()
            )
            .build()
    )
}
