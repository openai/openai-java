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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** ChatKit configuration for the session. */
class ChatSessionChatKitConfiguration
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val automaticThreadTitling: JsonField<ChatSessionAutomaticThreadTitling>,
    private val fileUpload: JsonField<ChatSessionFileUpload>,
    private val history: JsonField<ChatSessionHistory>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("automatic_thread_titling")
        @ExcludeMissing
        automaticThreadTitling: JsonField<ChatSessionAutomaticThreadTitling> = JsonMissing.of(),
        @JsonProperty("file_upload")
        @ExcludeMissing
        fileUpload: JsonField<ChatSessionFileUpload> = JsonMissing.of(),
        @JsonProperty("history")
        @ExcludeMissing
        history: JsonField<ChatSessionHistory> = JsonMissing.of(),
    ) : this(automaticThreadTitling, fileUpload, history, mutableMapOf())

    /**
     * Automatic thread titling preferences.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun automaticThreadTitling(): ChatSessionAutomaticThreadTitling =
        automaticThreadTitling.getRequired("automatic_thread_titling")

    /**
     * Upload settings for the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fileUpload(): ChatSessionFileUpload = fileUpload.getRequired("file_upload")

    /**
     * History retention configuration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun history(): ChatSessionHistory = history.getRequired("history")

    /**
     * Returns the raw JSON value of [automaticThreadTitling].
     *
     * Unlike [automaticThreadTitling], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("automatic_thread_titling")
    @ExcludeMissing
    fun _automaticThreadTitling(): JsonField<ChatSessionAutomaticThreadTitling> =
        automaticThreadTitling

    /**
     * Returns the raw JSON value of [fileUpload].
     *
     * Unlike [fileUpload], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_upload")
    @ExcludeMissing
    fun _fileUpload(): JsonField<ChatSessionFileUpload> = fileUpload

    /**
     * Returns the raw JSON value of [history].
     *
     * Unlike [history], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("history") @ExcludeMissing fun _history(): JsonField<ChatSessionHistory> = history

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
         * [ChatSessionChatKitConfiguration].
         *
         * The following fields are required:
         * ```java
         * .automaticThreadTitling()
         * .fileUpload()
         * .history()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSessionChatKitConfiguration]. */
    class Builder internal constructor() {

        private var automaticThreadTitling: JsonField<ChatSessionAutomaticThreadTitling>? = null
        private var fileUpload: JsonField<ChatSessionFileUpload>? = null
        private var history: JsonField<ChatSessionHistory>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatSessionChatKitConfiguration: ChatSessionChatKitConfiguration) =
            apply {
                automaticThreadTitling = chatSessionChatKitConfiguration.automaticThreadTitling
                fileUpload = chatSessionChatKitConfiguration.fileUpload
                history = chatSessionChatKitConfiguration.history
                additionalProperties =
                    chatSessionChatKitConfiguration.additionalProperties.toMutableMap()
            }

        /** Automatic thread titling preferences. */
        fun automaticThreadTitling(automaticThreadTitling: ChatSessionAutomaticThreadTitling) =
            automaticThreadTitling(JsonField.of(automaticThreadTitling))

        /**
         * Sets [Builder.automaticThreadTitling] to an arbitrary JSON value.
         *
         * You should usually call [Builder.automaticThreadTitling] with a well-typed
         * [ChatSessionAutomaticThreadTitling] value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun automaticThreadTitling(
            automaticThreadTitling: JsonField<ChatSessionAutomaticThreadTitling>
        ) = apply { this.automaticThreadTitling = automaticThreadTitling }

        /** Upload settings for the session. */
        fun fileUpload(fileUpload: ChatSessionFileUpload) = fileUpload(JsonField.of(fileUpload))

        /**
         * Sets [Builder.fileUpload] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileUpload] with a well-typed [ChatSessionFileUpload]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun fileUpload(fileUpload: JsonField<ChatSessionFileUpload>) = apply {
            this.fileUpload = fileUpload
        }

        /** History retention configuration. */
        fun history(history: ChatSessionHistory) = history(JsonField.of(history))

        /**
         * Sets [Builder.history] to an arbitrary JSON value.
         *
         * You should usually call [Builder.history] with a well-typed [ChatSessionHistory] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun history(history: JsonField<ChatSessionHistory>) = apply { this.history = history }

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
         * Returns an immutable instance of [ChatSessionChatKitConfiguration].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .automaticThreadTitling()
         * .fileUpload()
         * .history()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatSessionChatKitConfiguration =
            ChatSessionChatKitConfiguration(
                checkRequired("automaticThreadTitling", automaticThreadTitling),
                checkRequired("fileUpload", fileUpload),
                checkRequired("history", history),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSessionChatKitConfiguration = apply {
        if (validated) {
            return@apply
        }

        automaticThreadTitling().validate()
        fileUpload().validate()
        history().validate()
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
        (automaticThreadTitling.asKnown().getOrNull()?.validity() ?: 0) +
            (fileUpload.asKnown().getOrNull()?.validity() ?: 0) +
            (history.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSessionChatKitConfiguration &&
            automaticThreadTitling == other.automaticThreadTitling &&
            fileUpload == other.fileUpload &&
            history == other.history &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(automaticThreadTitling, fileUpload, history, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatSessionChatKitConfiguration{automaticThreadTitling=$automaticThreadTitling, fileUpload=$fileUpload, history=$history, additionalProperties=$additionalProperties}"
}
