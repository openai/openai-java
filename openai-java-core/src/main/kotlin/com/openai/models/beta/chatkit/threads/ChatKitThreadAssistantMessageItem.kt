// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Assistant-authored message within a thread. */
class ChatKitThreadAssistantMessageItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val content: JsonField<List<ChatKitResponseOutputText>>,
    private val createdAt: JsonField<Long>,
    private val object_: JsonValue,
    private val threadId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("content")
        @ExcludeMissing
        content: JsonField<List<ChatKitResponseOutputText>> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("thread_id") @ExcludeMissing threadId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, content, createdAt, object_, threadId, type, mutableMapOf())

    /**
     * Identifier of the thread item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Ordered assistant response segments.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun content(): List<ChatKitResponseOutputText> = content.getRequired("content")

    /**
     * Unix timestamp (in seconds) for when the item was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Type discriminator that is always `chatkit.thread_item`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("chatkit.thread_item")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Identifier of the parent thread.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun threadId(): String = threadId.getRequired("thread_id")

    /**
     * Type discriminator that is always `chatkit.assistant_message`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("chatkit.assistant_message")
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
     * Returns the raw JSON value of [content].
     *
     * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content")
    @ExcludeMissing
    fun _content(): JsonField<List<ChatKitResponseOutputText>> = content

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [threadId].
     *
     * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("thread_id") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

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
         * Returns a mutable builder for constructing an instance of
         * [ChatKitThreadAssistantMessageItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .createdAt()
         * .threadId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatKitThreadAssistantMessageItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var content: JsonField<MutableList<ChatKitResponseOutputText>>? = null
        private var createdAt: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("chatkit.thread_item")
        private var threadId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("chatkit.assistant_message")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatkitThreadAssistantMessageItem: ChatKitThreadAssistantMessageItem) =
            apply {
                id = chatkitThreadAssistantMessageItem.id
                content = chatkitThreadAssistantMessageItem.content.map { it.toMutableList() }
                createdAt = chatkitThreadAssistantMessageItem.createdAt
                object_ = chatkitThreadAssistantMessageItem.object_
                threadId = chatkitThreadAssistantMessageItem.threadId
                type = chatkitThreadAssistantMessageItem.type
                additionalProperties =
                    chatkitThreadAssistantMessageItem.additionalProperties.toMutableMap()
            }

        /** Identifier of the thread item. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Ordered assistant response segments. */
        fun content(content: List<ChatKitResponseOutputText>) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed
         * `List<ChatKitResponseOutputText>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun content(content: JsonField<List<ChatKitResponseOutputText>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /**
         * Adds a single [ChatKitResponseOutputText] to [Builder.content].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContent(content: ChatKitResponseOutputText) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).also {
                    checkKnown("content", it).add(content)
                }
        }

        /** Unix timestamp (in seconds) for when the item was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("chatkit.thread_item")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Identifier of the parent thread. */
        fun threadId(threadId: String) = threadId(JsonField.of(threadId))

        /**
         * Sets [Builder.threadId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.threadId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("chatkit.assistant_message")
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
         * Returns an immutable instance of [ChatKitThreadAssistantMessageItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .createdAt()
         * .threadId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatKitThreadAssistantMessageItem =
            ChatKitThreadAssistantMessageItem(
                checkRequired("id", id),
                checkRequired("content", content).map { it.toImmutable() },
                checkRequired("createdAt", createdAt),
                object_,
                checkRequired("threadId", threadId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatKitThreadAssistantMessageItem = apply {
        if (validated) {
            return@apply
        }

        id()
        content().forEach { it.validate() }
        createdAt()
        _object_().let {
            if (it != JsonValue.from("chatkit.thread_item")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        threadId()
        _type().let {
            if (it != JsonValue.from("chatkit.assistant_message")) {
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
            (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("chatkit.thread_item")) 1 else 0 } +
            (if (threadId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("chatkit.assistant_message")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatKitThreadAssistantMessageItem &&
            id == other.id &&
            content == other.content &&
            createdAt == other.createdAt &&
            object_ == other.object_ &&
            threadId == other.threadId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, content, createdAt, object_, threadId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatKitThreadAssistantMessageItem{id=$id, content=$content, createdAt=$createdAt, object_=$object_, threadId=$threadId, type=$type, additionalProperties=$additionalProperties}"
}
