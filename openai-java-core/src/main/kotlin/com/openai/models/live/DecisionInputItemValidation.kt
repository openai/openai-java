// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import kotlin.jvm.optionals.getOrNull

/** Validates the service wire shape without changing the released Item model API. */
internal object DecisionInputItemValidation {
    @JvmSynthetic
    fun validate(properties: Map<String, JsonValue>) {
        if (!isItem(JsonValue.from(properties))) {
            throw OpenAIInvalidDataException("Invalid Live Decision item")
        }
    }

    private inline fun optional(value: JsonValue?, accepts: (JsonValue) -> Boolean): Boolean =
        value == null || value.isMissing() || value.isNull() || accepts(value)

    private inline fun required(value: JsonValue?, accepts: (JsonValue) -> Boolean): Boolean =
        value != null && !value.isMissing() && !value.isNull() && accepts(value)

    private fun isItem(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return when (
            properties.getOrDefault("type", JsonValue.from("message")).asString().getOrNull()
        ) {
            "message" ->
                when (properties["role"]?.asString()?.getOrNull()) {
                    "user" -> isUserMessage(value)
                    "developer" -> isDeveloperMessage(value)
                    "system" -> isSystemMessage(value)
                    "assistant" -> isAssistantMessage(value)
                    else -> false
                }
            "function_call" -> (isFunctionCall(value))
            "function_call_output" -> (isFunctionCallOutput(value))
            "custom_tool_call" -> (isCustomToolCall(value))
            "custom_tool_call_output" -> (isCustomToolCallOutput(value))
            else -> false
        }
    }

    private fun isUserMessage(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["content"]) { isUserMessageContent(it) } &&
            properties["role"] == JsonValue.from("user") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["type"]) { it == JsonValue.from("message") }
    }

    private fun isUserMessageContent(value: JsonValue): Boolean =
        (value.asString().isPresent) ||
            (value.asArray().getOrNull()?.all { element ->
                isUserMessageContentDecisionInputItemValidationUserMessageContentItem(element)
            } == true)

    private fun isUserMessageContentDecisionInputItemValidationUserMessageContentItem(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return when (properties["type"]?.asString()?.getOrNull()) {
            "input_text" ->
                (isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputText(
                    value
                ))
            "input_image" ->
                (isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputImage(
                    value
                ))
            "input_json" ->
                (isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputJson(
                    value
                ))
            else -> false
        }
    }

    private fun isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputText(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["text"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_text")
    }

    private fun isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputImage(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["image_url"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_image") &&
            optional(properties["detail"]) {
                it == JsonValue.from("low") ||
                    it == JsonValue.from("high") ||
                    it == JsonValue.from("auto") ||
                    it == JsonValue.from("original")
            }
    }

    private fun isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputJson(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["data"]) {
            isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputJsonData(it)
        } && properties["type"] == JsonValue.from("input_json")
    }

    private fun isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputJsonData(
        value: JsonValue
    ): Boolean =
        (isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputJsonDataLiveDecisionJsonObject(
            value
        )) || (value.asArray().getOrNull()?.all { element -> element.asObject().isPresent } == true)

    private fun isUserMessageContentDecisionInputItemValidationUserMessageContentItemInputJsonDataLiveDecisionJsonObject(
        value: JsonValue
    ): Boolean = value.asObject().isPresent

    private fun isDeveloperMessage(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["content"]) { isDeveloperMessageContent(it) } &&
            properties["role"] == JsonValue.from("developer") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["type"]) { it == JsonValue.from("message") }
    }

    private fun isDeveloperMessageContent(value: JsonValue): Boolean =
        (value.asString().isPresent) ||
            (value.asArray().getOrNull()?.all { element ->
                isDeveloperMessageContentLiveDecisionInputTextParam(element)
            } == true)

    private fun isDeveloperMessageContentLiveDecisionInputTextParam(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["text"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_text")
    }

    private fun isSystemMessage(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["content"]) { isSystemMessageContent(it) } &&
            properties["role"] == JsonValue.from("system") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["type"]) { it == JsonValue.from("message") }
    }

    private fun isSystemMessageContent(value: JsonValue): Boolean =
        (value.asString().isPresent) ||
            (value.asArray().getOrNull()?.all { element ->
                isSystemMessageContentLiveDecisionInputTextParam(element)
            } == true)

    private fun isSystemMessageContentLiveDecisionInputTextParam(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["text"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_text")
    }

    private fun isAssistantMessage(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["content"]) { isAssistantMessageContent(it) } &&
            properties["role"] == JsonValue.from("assistant") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["phase"]) {
                it == JsonValue.from("commentary") || it == JsonValue.from("final_answer")
            } &&
            optional(properties["type"]) { it == JsonValue.from("message") }
    }

    private fun isAssistantMessageContent(value: JsonValue): Boolean =
        (value.asString().isPresent) ||
            (value.asArray().getOrNull()?.all { element ->
                isAssistantMessageContentDecisionInputItemValidationAssistantMessageContentItem(
                    element
                )
            } == true)

    private fun isAssistantMessageContentDecisionInputItemValidationAssistantMessageContentItem(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return when (properties["type"]?.asString()?.getOrNull()) {
            "output_text" ->
                (isAssistantMessageContentDecisionInputItemValidationAssistantMessageContentItemOutputText(
                    value
                ))
            "refusal" ->
                (isAssistantMessageContentDecisionInputItemValidationAssistantMessageContentItemRefusal(
                    value
                ))
            else -> false
        }
    }

    private fun isAssistantMessageContentDecisionInputItemValidationAssistantMessageContentItemOutputText(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["text"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("output_text")
    }

    private fun isAssistantMessageContentDecisionInputItemValidationAssistantMessageContentItemRefusal(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["refusal"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("refusal")
    }

    private fun isFunctionCall(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["arguments"]) { it.asString().isPresent } &&
            required(properties["call_id"]) { it.asString().isPresent } &&
            required(properties["name"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("function_call") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["namespace"]) { it.asString().isPresent } &&
            optional(properties["status"]) {
                it == JsonValue.from("in_progress") ||
                    it == JsonValue.from("completed") ||
                    it == JsonValue.from("incomplete")
            }
    }

    private fun isFunctionCallOutput(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["call_id"]) { it.asString().isPresent } &&
            required(properties["output"]) { isFunctionCallOutputOutput(it) } &&
            properties["type"] == JsonValue.from("function_call_output") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["status"]) {
                it == JsonValue.from("in_progress") ||
                    it == JsonValue.from("completed") ||
                    it == JsonValue.from("incomplete")
            }
    }

    private fun isFunctionCallOutputOutput(value: JsonValue): Boolean =
        (value.asString().isPresent) ||
            (value.asArray().getOrNull()?.all { element ->
                isFunctionCallOutputOutputDecisionInputItemValidationFunctionCallOutputOutputItem(
                    element
                )
            } == true)

    private fun isFunctionCallOutputOutputDecisionInputItemValidationFunctionCallOutputOutputItem(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return when (properties["type"]?.asString()?.getOrNull()) {
            "input_text" ->
                (isFunctionCallOutputOutputDecisionInputItemValidationFunctionCallOutputOutputItemInputText(
                    value
                ))
            "input_image" ->
                (isFunctionCallOutputOutputDecisionInputItemValidationFunctionCallOutputOutputItemInputImage(
                    value
                ))
            else -> false
        }
    }

    private fun isFunctionCallOutputOutputDecisionInputItemValidationFunctionCallOutputOutputItemInputText(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["text"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_text")
    }

    private fun isFunctionCallOutputOutputDecisionInputItemValidationFunctionCallOutputOutputItemInputImage(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["image_url"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_image") &&
            optional(properties["detail"]) {
                it == JsonValue.from("low") ||
                    it == JsonValue.from("high") ||
                    it == JsonValue.from("auto") ||
                    it == JsonValue.from("original")
            }
    }

    private fun isCustomToolCall(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["call_id"]) { it.asString().isPresent } &&
            required(properties["input"]) { it.asString().isPresent } &&
            required(properties["name"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("custom_tool_call") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["namespace"]) { it.asString().isPresent } &&
            optional(properties["status"]) {
                it == JsonValue.from("in_progress") ||
                    it == JsonValue.from("completed") ||
                    it == JsonValue.from("incomplete")
            }
    }

    private fun isCustomToolCallOutput(value: JsonValue): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["call_id"]) { it.asString().isPresent } &&
            required(properties["output"]) { isCustomToolCallOutputOutput(it) } &&
            properties["type"] == JsonValue.from("custom_tool_call_output") &&
            optional(properties["id"]) { it.asString().isPresent } &&
            optional(properties["status"]) {
                it == JsonValue.from("in_progress") ||
                    it == JsonValue.from("completed") ||
                    it == JsonValue.from("incomplete")
            }
    }

    private fun isCustomToolCallOutputOutput(value: JsonValue): Boolean =
        (value.asString().isPresent) ||
            (value.asArray().getOrNull()?.all { element ->
                isCustomToolCallOutputOutputDecisionInputItemValidationCustomToolCallOutputOutputItem(
                    element
                )
            } == true)

    private fun isCustomToolCallOutputOutputDecisionInputItemValidationCustomToolCallOutputOutputItem(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return when (properties["type"]?.asString()?.getOrNull()) {
            "input_text" ->
                (isCustomToolCallOutputOutputDecisionInputItemValidationCustomToolCallOutputOutputItemInputText(
                    value
                ))
            "input_image" ->
                (isCustomToolCallOutputOutputDecisionInputItemValidationCustomToolCallOutputOutputItemInputImage(
                    value
                ))
            else -> false
        }
    }

    private fun isCustomToolCallOutputOutputDecisionInputItemValidationCustomToolCallOutputOutputItemInputText(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["text"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_text")
    }

    private fun isCustomToolCallOutputOutputDecisionInputItemValidationCustomToolCallOutputOutputItemInputImage(
        value: JsonValue
    ): Boolean {
        val properties = value.asObject().getOrNull() ?: return false
        return required(properties["image_url"]) { it.asString().isPresent } &&
            properties["type"] == JsonValue.from("input_image") &&
            optional(properties["detail"]) {
                it == JsonValue.from("low") ||
                    it == JsonValue.from("high") ||
                    it == JsonValue.from("auto") ||
                    it == JsonValue.from("original")
            }
    }
}
