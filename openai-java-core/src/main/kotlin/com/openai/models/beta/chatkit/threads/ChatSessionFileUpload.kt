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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Upload permissions and limits applied to the session. */
class ChatSessionFileUpload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val enabled: JsonField<Boolean>,
    private val maxFileSize: JsonField<Long>,
    private val maxFiles: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("max_file_size")
        @ExcludeMissing
        maxFileSize: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_files") @ExcludeMissing maxFiles: JsonField<Long> = JsonMissing.of(),
    ) : this(enabled, maxFileSize, maxFiles, mutableMapOf())

    /**
     * Indicates if uploads are enabled for the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun enabled(): Boolean = enabled.getRequired("enabled")

    /**
     * Maximum upload size in megabytes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxFileSize(): Optional<Long> = maxFileSize.getOptional("max_file_size")

    /**
     * Maximum number of uploads allowed during the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxFiles(): Optional<Long> = maxFiles.getOptional("max_files")

    /**
     * Returns the raw JSON value of [enabled].
     *
     * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

    /**
     * Returns the raw JSON value of [maxFileSize].
     *
     * Unlike [maxFileSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_file_size") @ExcludeMissing fun _maxFileSize(): JsonField<Long> = maxFileSize

    /**
     * Returns the raw JSON value of [maxFiles].
     *
     * Unlike [maxFiles], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_files") @ExcludeMissing fun _maxFiles(): JsonField<Long> = maxFiles

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
         * Returns a mutable builder for constructing an instance of [ChatSessionFileUpload].
         *
         * The following fields are required:
         * ```java
         * .enabled()
         * .maxFileSize()
         * .maxFiles()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSessionFileUpload]. */
    class Builder internal constructor() {

        private var enabled: JsonField<Boolean>? = null
        private var maxFileSize: JsonField<Long>? = null
        private var maxFiles: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatSessionFileUpload: ChatSessionFileUpload) = apply {
            enabled = chatSessionFileUpload.enabled
            maxFileSize = chatSessionFileUpload.maxFileSize
            maxFiles = chatSessionFileUpload.maxFiles
            additionalProperties = chatSessionFileUpload.additionalProperties.toMutableMap()
        }

        /** Indicates if uploads are enabled for the session. */
        fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

        /**
         * Sets [Builder.enabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

        /** Maximum upload size in megabytes. */
        fun maxFileSize(maxFileSize: Long?) = maxFileSize(JsonField.ofNullable(maxFileSize))

        /**
         * Alias for [Builder.maxFileSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxFileSize(maxFileSize: Long) = maxFileSize(maxFileSize as Long?)

        /** Alias for calling [Builder.maxFileSize] with `maxFileSize.orElse(null)`. */
        fun maxFileSize(maxFileSize: Optional<Long>) = maxFileSize(maxFileSize.getOrNull())

        /**
         * Sets [Builder.maxFileSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxFileSize] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxFileSize(maxFileSize: JsonField<Long>) = apply { this.maxFileSize = maxFileSize }

        /** Maximum number of uploads allowed during the session. */
        fun maxFiles(maxFiles: Long?) = maxFiles(JsonField.ofNullable(maxFiles))

        /**
         * Alias for [Builder.maxFiles].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxFiles(maxFiles: Long) = maxFiles(maxFiles as Long?)

        /** Alias for calling [Builder.maxFiles] with `maxFiles.orElse(null)`. */
        fun maxFiles(maxFiles: Optional<Long>) = maxFiles(maxFiles.getOrNull())

        /**
         * Sets [Builder.maxFiles] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxFiles] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxFiles(maxFiles: JsonField<Long>) = apply { this.maxFiles = maxFiles }

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
         * Returns an immutable instance of [ChatSessionFileUpload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .enabled()
         * .maxFileSize()
         * .maxFiles()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatSessionFileUpload =
            ChatSessionFileUpload(
                checkRequired("enabled", enabled),
                checkRequired("maxFileSize", maxFileSize),
                checkRequired("maxFiles", maxFiles),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSessionFileUpload = apply {
        if (validated) {
            return@apply
        }

        enabled()
        maxFileSize()
        maxFiles()
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
        (if (enabled.asKnown().isPresent) 1 else 0) +
            (if (maxFileSize.asKnown().isPresent) 1 else 0) +
            (if (maxFiles.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSessionFileUpload &&
            enabled == other.enabled &&
            maxFileSize == other.maxFileSize &&
            maxFiles == other.maxFiles &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(enabled, maxFileSize, maxFiles, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatSessionFileUpload{enabled=$enabled, maxFileSize=$maxFileSize, maxFiles=$maxFiles, additionalProperties=$additionalProperties}"
}
