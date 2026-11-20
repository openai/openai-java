package com.openai.helpers

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.openai.core.jsonMapper
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.ResponseOutputItem
import java.util.Optional

/**
 * Converts locally managed Responses history into input items without modifying the source.
 *
 * Known non-replayable states are omitted. Unknown item types fail explicitly so new API items
 * cannot silently disappear. This helper does not fetch history, validate a complete conversation,
 * or repair missing tool results. Preserve the original history order and reasoning context.
 */
object ResponseInputItems {
    /** Normalize response output in its original order. The returned list can be appended to. */
    @JvmStatic
    fun toInputItems(items: Iterable<ResponseOutputItem>): List<ResponseInputItem> =
        items.mapNotNull { toInputItem(it).orElse(null) }.toMutableList()

    /** Normalize previously stored input items, including user messages and tool results. */
    @JvmStatic
    fun normalizeInputItems(items: Iterable<ResponseInputItem>): List<ResponseInputItem> =
        items.mapNotNull { toInputItem(it).orElse(null) }.toMutableList()

    /** Returns empty only for a known non-replayable state. */
    @JvmStatic
    fun toInputItem(item: ResponseOutputItem): Optional<ResponseInputItem> = normalize(item)

    /** Returns empty only for a known non-replayable state. */
    @JvmStatic
    fun toInputItem(item: ResponseInputItem): Optional<ResponseInputItem> = normalize(item)

    private fun normalize(item: Any): Optional<ResponseInputItem> {
        // Deep-copy even raw JsonValue-backed union variants before removing fields.
        val tree = jsonMapper().valueToTree<JsonNode>(item)
        require(tree is ObjectNode) { "Expected a Responses history item object" }
        val value = tree.deepCopy()
        value.remove("created_by")
        val type = value.get("type")
        if (type == null || type.isNull) {
            // These input variants allow an omitted discriminator. Hydrate them directly because
            // the generated union deserializer needs an explicit type to select a variant.
            if (
                item is ResponseInputItem &&
                    value.path("id").isTextual &&
                    !value.has("role") &&
                    !value.has("content")
            ) {
                return Optional.of(
                    ResponseInputItem.ofItemReference(
                        jsonMapper().treeToValue(value, ResponseInputItem.ItemReference::class.java)
                    )
                )
            }
            require(
                value.path("role").asText() in setOf("user", "assistant", "system", "developer") &&
                    (value.path("content").isTextual || value.path("content").isArray)
            ) {
                "Expected a message or item reference when the history item type is omitted"
            }
            return Optional.of(
                ResponseInputItem.ofEasyInputMessage(
                    jsonMapper().treeToValue(value, EasyInputMessage::class.java)
                )
            )
        } else {
            require(type.isTextual && type.asText() in supportedTypes) {
                "Unsupported Responses history item type; update the SDK or convert it explicitly"
            }
        }
        when (type?.asText()) {
            "additional_tools" ->
                if (value.path("role").asText() != "developer") return Optional.empty()
            "computer_call_output" ->
                if (value.path("status").asText() == "failed") return Optional.empty()
            "custom_tool_call_output" -> {
                if (value.has("status") && value.path("status").asText() != "completed") {
                    return Optional.empty()
                }
                value.remove("status")
            }
            "function_call" -> value.remove("parsed_arguments")
            "message" -> {
                if (value.path("role").asText() == "assistant" && value.has("id")) {
                    val content = value.path("content")
                    if (content.isArray) {
                        for (part in content) {
                            if (
                                part is ObjectNode &&
                                    part.path("type").asText() in setOf("output_text", "refusal")
                            ) {
                                part.remove("parsed")
                            }
                        }
                    }
                }
            }
            "shell_call_output" -> {
                val output = value.path("output")
                require(output.isArray) { "Expected shell output chunks in a history item" }
                for (chunk in output) {
                    require(chunk is ObjectNode) { "Expected a shell output chunk object" }
                    chunk.remove("created_by")
                }
            }
        }
        return Optional.of(jsonMapper().treeToValue(value, ResponseInputItem::class.java))
    }

    // Matches the maintained Node ResponseInputItems helper. Keep this explicit: passing unknown
    // item kinds through would claim replay semantics we do not yet know.
    private val supportedTypes =
        setOf(
            "message",
            "function_call",
            "additional_tools",
            "shell_call_output",
            "computer_call_output",
            "custom_tool_call_output",
            "apply_patch_call",
            "apply_patch_call_output",
            "code_interpreter_call",
            "compaction",
            "compaction_trigger",
            "computer_call",
            "configuration_update",
            "custom_tool_call",
            "file_search_call",
            "function_call_output",
            "image_generation_call",
            "item_reference",
            "local_shell_call",
            "local_shell_call_output",
            "mcp_approval_request",
            "mcp_approval_response",
            "mcp_call",
            "mcp_list_tools",
            "program",
            "program_output",
            "reasoning",
            "shell_call",
            "tool_search_call",
            "tool_search_output",
            "web_search_call",
        )
}
