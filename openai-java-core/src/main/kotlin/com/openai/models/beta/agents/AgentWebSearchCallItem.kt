// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A web search call produced by the agent. */
class AgentWebSearchCallItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val action: JsonField<WebSearchAction>,
    private val status: JsonField<AgentOutputItemStatus>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("action")
        @ExcludeMissing
        action: JsonField<WebSearchAction> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<AgentOutputItemStatus> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, action, status, turnId, type, mutableMapOf())

    /**
     * The ID of the web search call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * An action performed by the web search tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun action(): Optional<WebSearchAction> = action.getOptional("action")

    /**
     * The status of the web search call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): AgentOutputItemStatus = status.getRequired("status")

    /**
     * The ID of the turn that contains this item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun turnId(): String = turnId.getRequired("turn_id")

    /**
     * The item type. Always `web_search_call`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("web_search_call")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [action].
     *
     * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<WebSearchAction> = action

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<AgentOutputItemStatus> = status

    /**
     * Returns the raw JSON value of [turnId].
     *
     * Unlike [turnId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("turn_id") @ExcludeMissing fun _turnId(): JsonField<String> = turnId

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AgentWebSearchCallItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .action()
         * .status()
         * .turnId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentWebSearchCallItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var action: JsonField<WebSearchAction>? = null
        private var status: JsonField<AgentOutputItemStatus>? = null
        private var turnId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("web_search_call")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentWebSearchCallItem: AgentWebSearchCallItem) = apply {
            id = agentWebSearchCallItem.id
            action = agentWebSearchCallItem.action
            status = agentWebSearchCallItem.status
            turnId = agentWebSearchCallItem.turnId
            type = agentWebSearchCallItem.type
            additionalProperties = agentWebSearchCallItem.additionalProperties.toMutableMap()
        }

        /** The ID of the web search call. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** An action performed by the web search tool. */
        fun action(action: WebSearchAction?) = action(JsonField.ofNullable(action))

        /** Alias for calling [Builder.action] with `action.orElse(null)`. */
        fun action(action: Optional<WebSearchAction>) = action(action.getOrNull())

        /**
         * Sets [Builder.action] to an arbitrary JSON value.
         *
         * You should usually call [Builder.action] with a well-typed [WebSearchAction] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun action(action: JsonField<WebSearchAction>) = apply { this.action = action }

        /** Alias for calling [action] with `WebSearchAction.ofSearch(search)`. */
        fun action(search: WebSearchAction.Search) = action(WebSearchAction.ofSearch(search))

        /** Alias for calling [action] with `WebSearchAction.ofOpenPage(openPage)`. */
        fun action(openPage: WebSearchAction.OpenPage) =
            action(WebSearchAction.ofOpenPage(openPage))

        /**
         * Alias for calling [action] with the following:
         * ```java
         * WebSearchAction.OpenPage.builder()
         *     .url(url)
         *     .build()
         * ```
         */
        fun openPageAction(url: String?) =
            action(WebSearchAction.OpenPage.builder().url(url).build())

        /** Alias for calling [openPageAction] with `url.orElse(null)`. */
        fun openPageAction(url: Optional<String>) = openPageAction(url.getOrNull())

        /** Alias for calling [action] with `WebSearchAction.ofFindInPage(findInPage)`. */
        fun action(findInPage: WebSearchAction.FindInPage) =
            action(WebSearchAction.ofFindInPage(findInPage))

        /** Alias for calling [action] with `WebSearchAction.ofOther()`. */
        fun actionOther() = action(WebSearchAction.ofOther())

        /** The status of the web search call. */
        fun status(status: AgentOutputItemStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [AgentOutputItemStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<AgentOutputItemStatus>) = apply { this.status = status }

        /** The ID of the turn that contains this item. */
        fun turnId(turnId: String) = turnId(JsonField.of(turnId))

        /**
         * Sets [Builder.turnId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("web_search_call")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [AgentWebSearchCallItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .action()
         * .status()
         * .turnId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentWebSearchCallItem =
            AgentWebSearchCallItem(
                checkRequired("id", id),
                checkRequired("action", action),
                checkRequired("status", status),
                checkRequired("turnId", turnId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): AgentWebSearchCallItem = apply {
        if (validated) {
            return@apply
        }

        id()
        action().ifPresent { it.validate() }
        status().validate()
        turnId()
        _type().let {
            if (it != JsonValue.from("web_search_call")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (action.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("web_search_call")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentWebSearchCallItem &&
            id == other.id &&
            action == other.action &&
            status == other.status &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, action, status, turnId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentWebSearchCallItem{id=$id, action=$action, status=$status, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
