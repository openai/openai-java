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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Optional per-session configuration settings for ChatKit behavior. */
class ChatSessionChatKitConfigurationParam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val automaticThreadTitling: JsonField<AutomaticThreadTitling>,
    private val fileUpload: JsonField<FileUpload>,
    private val history: JsonField<History>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("automatic_thread_titling")
        @ExcludeMissing
        automaticThreadTitling: JsonField<AutomaticThreadTitling> = JsonMissing.of(),
        @JsonProperty("file_upload")
        @ExcludeMissing
        fileUpload: JsonField<FileUpload> = JsonMissing.of(),
        @JsonProperty("history") @ExcludeMissing history: JsonField<History> = JsonMissing.of(),
    ) : this(automaticThreadTitling, fileUpload, history, mutableMapOf())

    /**
     * Configuration for automatic thread titling. When omitted, automatic thread titling is enabled
     * by default.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun automaticThreadTitling(): Optional<AutomaticThreadTitling> =
        automaticThreadTitling.getOptional("automatic_thread_titling")

    /**
     * Configuration for upload enablement and limits. When omitted, uploads are disabled by default
     * (max_files 10, max_file_size 512 MB).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileUpload(): Optional<FileUpload> = fileUpload.getOptional("file_upload")

    /**
     * Configuration for chat history retention. When omitted, history is enabled by default with no
     * limit on recent_threads (null).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun history(): Optional<History> = history.getOptional("history")

    /**
     * Returns the raw JSON value of [automaticThreadTitling].
     *
     * Unlike [automaticThreadTitling], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("automatic_thread_titling")
    @ExcludeMissing
    fun _automaticThreadTitling(): JsonField<AutomaticThreadTitling> = automaticThreadTitling

    /**
     * Returns the raw JSON value of [fileUpload].
     *
     * Unlike [fileUpload], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_upload")
    @ExcludeMissing
    fun _fileUpload(): JsonField<FileUpload> = fileUpload

    /**
     * Returns the raw JSON value of [history].
     *
     * Unlike [history], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("history") @ExcludeMissing fun _history(): JsonField<History> = history

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
         * [ChatSessionChatKitConfigurationParam].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSessionChatKitConfigurationParam]. */
    class Builder internal constructor() {

        private var automaticThreadTitling: JsonField<AutomaticThreadTitling> = JsonMissing.of()
        private var fileUpload: JsonField<FileUpload> = JsonMissing.of()
        private var history: JsonField<History> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            chatSessionChatKitConfigurationParam: ChatSessionChatKitConfigurationParam
        ) = apply {
            automaticThreadTitling = chatSessionChatKitConfigurationParam.automaticThreadTitling
            fileUpload = chatSessionChatKitConfigurationParam.fileUpload
            history = chatSessionChatKitConfigurationParam.history
            additionalProperties =
                chatSessionChatKitConfigurationParam.additionalProperties.toMutableMap()
        }

        /**
         * Configuration for automatic thread titling. When omitted, automatic thread titling is
         * enabled by default.
         */
        fun automaticThreadTitling(automaticThreadTitling: AutomaticThreadTitling) =
            automaticThreadTitling(JsonField.of(automaticThreadTitling))

        /**
         * Sets [Builder.automaticThreadTitling] to an arbitrary JSON value.
         *
         * You should usually call [Builder.automaticThreadTitling] with a well-typed
         * [AutomaticThreadTitling] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun automaticThreadTitling(automaticThreadTitling: JsonField<AutomaticThreadTitling>) =
            apply {
                this.automaticThreadTitling = automaticThreadTitling
            }

        /**
         * Configuration for upload enablement and limits. When omitted, uploads are disabled by
         * default (max_files 10, max_file_size 512 MB).
         */
        fun fileUpload(fileUpload: FileUpload) = fileUpload(JsonField.of(fileUpload))

        /**
         * Sets [Builder.fileUpload] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileUpload] with a well-typed [FileUpload] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fileUpload(fileUpload: JsonField<FileUpload>) = apply { this.fileUpload = fileUpload }

        /**
         * Configuration for chat history retention. When omitted, history is enabled by default
         * with no limit on recent_threads (null).
         */
        fun history(history: History) = history(JsonField.of(history))

        /**
         * Sets [Builder.history] to an arbitrary JSON value.
         *
         * You should usually call [Builder.history] with a well-typed [History] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun history(history: JsonField<History>) = apply { this.history = history }

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
         * Returns an immutable instance of [ChatSessionChatKitConfigurationParam].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ChatSessionChatKitConfigurationParam =
            ChatSessionChatKitConfigurationParam(
                automaticThreadTitling,
                fileUpload,
                history,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSessionChatKitConfigurationParam = apply {
        if (validated) {
            return@apply
        }

        automaticThreadTitling().ifPresent { it.validate() }
        fileUpload().ifPresent { it.validate() }
        history().ifPresent { it.validate() }
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

    /**
     * Configuration for automatic thread titling. When omitted, automatic thread titling is enabled
     * by default.
     */
    class AutomaticThreadTitling
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of()
        ) : this(enabled, mutableMapOf())

        /**
         * Enable automatic thread title generation. Defaults to true.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun enabled(): Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

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
             * Returns a mutable builder for constructing an instance of [AutomaticThreadTitling].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AutomaticThreadTitling]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(automaticThreadTitling: AutomaticThreadTitling) = apply {
                enabled = automaticThreadTitling.enabled
                additionalProperties = automaticThreadTitling.additionalProperties.toMutableMap()
            }

            /** Enable automatic thread title generation. Defaults to true. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * Returns an immutable instance of [AutomaticThreadTitling].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AutomaticThreadTitling =
                AutomaticThreadTitling(enabled, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): AutomaticThreadTitling = apply {
            if (validated) {
                return@apply
            }

            enabled()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = (if (enabled.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AutomaticThreadTitling &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AutomaticThreadTitling{enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    /**
     * Configuration for upload enablement and limits. When omitted, uploads are disabled by default
     * (max_files 10, max_file_size 512 MB).
     */
    class FileUpload
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
         * Enable uploads for this session. Defaults to false.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun enabled(): Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * Maximum size in megabytes for each uploaded file. Defaults to 512 MB, which is the
         * maximum allowable size.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxFileSize(): Optional<Long> = maxFileSize.getOptional("max_file_size")

        /**
         * Maximum number of files that can be uploaded to the session. Defaults to 10.
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
        @JsonProperty("max_file_size")
        @ExcludeMissing
        fun _maxFileSize(): JsonField<Long> = maxFileSize

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

            /** Returns a mutable builder for constructing an instance of [FileUpload]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileUpload]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var maxFileSize: JsonField<Long> = JsonMissing.of()
            private var maxFiles: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileUpload: FileUpload) = apply {
                enabled = fileUpload.enabled
                maxFileSize = fileUpload.maxFileSize
                maxFiles = fileUpload.maxFiles
                additionalProperties = fileUpload.additionalProperties.toMutableMap()
            }

            /** Enable uploads for this session. Defaults to false. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

            /**
             * Maximum size in megabytes for each uploaded file. Defaults to 512 MB, which is the
             * maximum allowable size.
             */
            fun maxFileSize(maxFileSize: Long) = maxFileSize(JsonField.of(maxFileSize))

            /**
             * Sets [Builder.maxFileSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxFileSize] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxFileSize(maxFileSize: JsonField<Long>) = apply { this.maxFileSize = maxFileSize }

            /** Maximum number of files that can be uploaded to the session. Defaults to 10. */
            fun maxFiles(maxFiles: Long) = maxFiles(JsonField.of(maxFiles))

            /**
             * Sets [Builder.maxFiles] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxFiles] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [FileUpload].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FileUpload =
                FileUpload(enabled, maxFileSize, maxFiles, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): FileUpload = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

            return other is FileUpload &&
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
            "FileUpload{enabled=$enabled, maxFileSize=$maxFileSize, maxFiles=$maxFiles, additionalProperties=$additionalProperties}"
    }

    /**
     * Configuration for chat history retention. When omitted, history is enabled by default with no
     * limit on recent_threads (null).
     */
    class History
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val recentThreads: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("recent_threads")
            @ExcludeMissing
            recentThreads: JsonField<Long> = JsonMissing.of(),
        ) : this(enabled, recentThreads, mutableMapOf())

        /**
         * Enables chat users to access previous ChatKit threads. Defaults to true.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun enabled(): Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * Number of recent ChatKit threads users have access to. Defaults to unlimited when unset.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recentThreads(): Optional<Long> = recentThreads.getOptional("recent_threads")

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

        /**
         * Returns the raw JSON value of [recentThreads].
         *
         * Unlike [recentThreads], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("recent_threads")
        @ExcludeMissing
        fun _recentThreads(): JsonField<Long> = recentThreads

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

            /** Returns a mutable builder for constructing an instance of [History]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [History]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var recentThreads: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(history: History) = apply {
                enabled = history.enabled
                recentThreads = history.recentThreads
                additionalProperties = history.additionalProperties.toMutableMap()
            }

            /** Enables chat users to access previous ChatKit threads. Defaults to true. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

            /**
             * Number of recent ChatKit threads users have access to. Defaults to unlimited when
             * unset.
             */
            fun recentThreads(recentThreads: Long) = recentThreads(JsonField.of(recentThreads))

            /**
             * Sets [Builder.recentThreads] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recentThreads] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recentThreads(recentThreads: JsonField<Long>) = apply {
                this.recentThreads = recentThreads
            }

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
             * Returns an immutable instance of [History].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): History =
                History(enabled, recentThreads, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): History = apply {
            if (validated) {
                return@apply
            }

            enabled()
            recentThreads()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (enabled.asKnown().isPresent) 1 else 0) +
                (if (recentThreads.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is History &&
                enabled == other.enabled &&
                recentThreads == other.recentThreads &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(enabled, recentThreads, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "History{enabled=$enabled, recentThreads=$recentThreads, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSessionChatKitConfigurationParam &&
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
        "ChatSessionChatKitConfigurationParam{automaticThreadTitling=$automaticThreadTitling, fileUpload=$fileUpload, history=$history, additionalProperties=$additionalProperties}"
}
