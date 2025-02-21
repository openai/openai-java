// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** A list of files attached to a vector store. */
@NoAutoDetect
class VectorStoreFile
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("last_error")
    @ExcludeMissing
    private val lastError: JsonField<LastError> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("usage_bytes")
    @ExcludeMissing
    private val usageBytes: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("vector_store_id")
    @ExcludeMissing
    private val vectorStoreId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("chunking_strategy")
    @ExcludeMissing
    private val chunkingStrategy: JsonField<FileChunkingStrategy> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the vector store file was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The last error associated with this vector store file. Will be `null` if there are no errors.
     */
    fun lastError(): Optional<LastError> = Optional.ofNullable(lastError.getNullable("last_error"))

    /** The object type, which is always `vector_store.file`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The status of the vector store file, which can be either `in_progress`, `completed`,
     * `cancelled`, or `failed`. The status `completed` indicates that the vector store file is
     * ready for use.
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The total vector store usage in bytes. Note that this may be different from the original file
     * size.
     */
    fun usageBytes(): Long = usageBytes.getRequired("usage_bytes")

    /**
     * The ID of the
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that the
     * [File](https://platform.openai.com/docs/api-reference/files) is attached to.
     */
    fun vectorStoreId(): String = vectorStoreId.getRequired("vector_store_id")

    /** The strategy used to chunk the file. */
    fun chunkingStrategy(): Optional<FileChunkingStrategy> =
        Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The Unix timestamp (in seconds) for when the vector store file was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * The last error associated with this vector store file. Will be `null` if there are no errors.
     */
    @JsonProperty("last_error") @ExcludeMissing fun _lastError(): JsonField<LastError> = lastError

    /**
     * The status of the vector store file, which can be either `in_progress`, `completed`,
     * `cancelled`, or `failed`. The status `completed` indicates that the vector store file is
     * ready for use.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * The total vector store usage in bytes. Note that this may be different from the original file
     * size.
     */
    @JsonProperty("usage_bytes") @ExcludeMissing fun _usageBytes(): JsonField<Long> = usageBytes

    /**
     * The ID of the
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that the
     * [File](https://platform.openai.com/docs/api-reference/files) is attached to.
     */
    @JsonProperty("vector_store_id")
    @ExcludeMissing
    fun _vectorStoreId(): JsonField<String> = vectorStoreId

    /** The strategy used to chunk the file. */
    @JsonProperty("chunking_strategy")
    @ExcludeMissing
    fun _chunkingStrategy(): JsonField<FileChunkingStrategy> = chunkingStrategy

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): VectorStoreFile = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        lastError().ifPresent { it.validate() }
        _object_().let {
            if (it != JsonValue.from("vector_store.file")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        status()
        usageBytes()
        vectorStoreId()
        chunkingStrategy().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStoreFile]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var lastError: JsonField<LastError>? = null
        private var object_: JsonValue = JsonValue.from("vector_store.file")
        private var status: JsonField<Status>? = null
        private var usageBytes: JsonField<Long>? = null
        private var vectorStoreId: JsonField<String>? = null
        private var chunkingStrategy: JsonField<FileChunkingStrategy> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStoreFile: VectorStoreFile) = apply {
            id = vectorStoreFile.id
            createdAt = vectorStoreFile.createdAt
            lastError = vectorStoreFile.lastError
            object_ = vectorStoreFile.object_
            status = vectorStoreFile.status
            usageBytes = vectorStoreFile.usageBytes
            vectorStoreId = vectorStoreFile.vectorStoreId
            chunkingStrategy = vectorStoreFile.chunkingStrategy
            additionalProperties = vectorStoreFile.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the vector store file was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the vector store file was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * The last error associated with this vector store file. Will be `null` if there are no
         * errors.
         */
        fun lastError(lastError: LastError?) = lastError(JsonField.ofNullable(lastError))

        /**
         * The last error associated with this vector store file. Will be `null` if there are no
         * errors.
         */
        fun lastError(lastError: Optional<LastError>) = lastError(lastError.orElse(null))

        /**
         * The last error associated with this vector store file. Will be `null` if there are no
         * errors.
         */
        fun lastError(lastError: JsonField<LastError>) = apply { this.lastError = lastError }

        /** The object type, which is always `vector_store.file`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The status of the vector store file, which can be either `in_progress`, `completed`,
         * `cancelled`, or `failed`. The status `completed` indicates that the vector store file is
         * ready for use.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The status of the vector store file, which can be either `in_progress`, `completed`,
         * `cancelled`, or `failed`. The status `completed` indicates that the vector store file is
         * ready for use.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * The total vector store usage in bytes. Note that this may be different from the original
         * file size.
         */
        fun usageBytes(usageBytes: Long) = usageBytes(JsonField.of(usageBytes))

        /**
         * The total vector store usage in bytes. Note that this may be different from the original
         * file size.
         */
        fun usageBytes(usageBytes: JsonField<Long>) = apply { this.usageBytes = usageBytes }

        /**
         * The ID of the
         * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that
         * the [File](https://platform.openai.com/docs/api-reference/files) is attached to.
         */
        fun vectorStoreId(vectorStoreId: String) = vectorStoreId(JsonField.of(vectorStoreId))

        /**
         * The ID of the
         * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object) that
         * the [File](https://platform.openai.com/docs/api-reference/files) is attached to.
         */
        fun vectorStoreId(vectorStoreId: JsonField<String>) = apply {
            this.vectorStoreId = vectorStoreId
        }

        /** The strategy used to chunk the file. */
        fun chunkingStrategy(chunkingStrategy: FileChunkingStrategy) =
            chunkingStrategy(JsonField.of(chunkingStrategy))

        /** The strategy used to chunk the file. */
        fun chunkingStrategy(chunkingStrategy: JsonField<FileChunkingStrategy>) = apply {
            this.chunkingStrategy = chunkingStrategy
        }

        /** The strategy used to chunk the file. */
        fun chunkingStrategy(static_: StaticFileChunkingStrategyObject) =
            chunkingStrategy(FileChunkingStrategy.ofStatic(static_))

        /** The strategy used to chunk the file. */
        fun staticChunkingStrategy(static_: StaticFileChunkingStrategy) =
            chunkingStrategy(StaticFileChunkingStrategyObject.builder().static_(static_).build())

        /**
         * This is returned when the chunking strategy is unknown. Typically, this is because the
         * file was indexed before the `chunking_strategy` concept was introduced in the API.
         */
        fun chunkingStrategy(other: OtherFileChunkingStrategyObject) =
            chunkingStrategy(FileChunkingStrategy.ofOther(other))

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

        fun build(): VectorStoreFile =
            VectorStoreFile(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("lastError", lastError),
                object_,
                checkRequired("status", status),
                checkRequired("usageBytes", usageBytes),
                checkRequired("vectorStoreId", vectorStoreId),
                chunkingStrategy,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The last error associated with this vector store file. Will be `null` if there are no errors.
     */
    @NoAutoDetect
    class LastError
    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing private val code: JsonField<Code> = JsonMissing.of(),
        @JsonProperty("message")
        @ExcludeMissing
        private val message: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** One of `server_error` or `rate_limit_exceeded`. */
        fun code(): Code = code.getRequired("code")

        /** A human-readable description of the error. */
        fun message(): String = message.getRequired("message")

        /** One of `server_error` or `rate_limit_exceeded`. */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

        /** A human-readable description of the error. */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): LastError = apply {
            if (validated) {
                return@apply
            }

            code()
            message()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LastError]. */
        class Builder internal constructor() {

            private var code: JsonField<Code>? = null
            private var message: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(lastError: LastError) = apply {
                code = lastError.code
                message = lastError.message
                additionalProperties = lastError.additionalProperties.toMutableMap()
            }

            /** One of `server_error` or `rate_limit_exceeded`. */
            fun code(code: Code) = code(JsonField.of(code))

            /** One of `server_error` or `rate_limit_exceeded`. */
            fun code(code: JsonField<Code>) = apply { this.code = code }

            /** A human-readable description of the error. */
            fun message(message: String) = message(JsonField.of(message))

            /** A human-readable description of the error. */
            fun message(message: JsonField<String>) = apply { this.message = message }

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

            fun build(): LastError =
                LastError(
                    checkRequired("code", code),
                    checkRequired("message", message),
                    additionalProperties.toImmutable(),
                )
        }

        /** One of `server_error` or `rate_limit_exceeded`. */
        class Code @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SERVER_ERROR = of("server_error")

                @JvmField val UNSUPPORTED_FILE = of("unsupported_file")

                @JvmField val INVALID_FILE = of("invalid_file")

                @JvmStatic fun of(value: String) = Code(JsonField.of(value))
            }

            /** An enum containing [Code]'s known values. */
            enum class Known {
                SERVER_ERROR,
                UNSUPPORTED_FILE,
                INVALID_FILE,
            }

            /**
             * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Code] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SERVER_ERROR,
                UNSUPPORTED_FILE,
                INVALID_FILE,
                /** An enum member indicating that [Code] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SERVER_ERROR -> Value.SERVER_ERROR
                    UNSUPPORTED_FILE -> Value.UNSUPPORTED_FILE
                    INVALID_FILE -> Value.INVALID_FILE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SERVER_ERROR -> Known.SERVER_ERROR
                    UNSUPPORTED_FILE -> Known.UNSUPPORTED_FILE
                    INVALID_FILE -> Known.INVALID_FILE
                    else -> throw OpenAIInvalidDataException("Unknown Code: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Code && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is LastError && code == other.code && message == other.message && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(code, message, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LastError{code=$code, message=$message, additionalProperties=$additionalProperties}"
    }

    /**
     * The status of the vector store file, which can be either `in_progress`, `completed`,
     * `cancelled`, or `failed`. The status `completed` indicates that the vector store file is
     * ready for use.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            COMPLETED,
            CANCELLED,
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IN_PROGRESS,
            COMPLETED,
            CANCELLED,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
                FAILED -> Value.FAILED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
                FAILED -> Known.FAILED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreFile && id == other.id && createdAt == other.createdAt && lastError == other.lastError && object_ == other.object_ && status == other.status && usageBytes == other.usageBytes && vectorStoreId == other.vectorStoreId && chunkingStrategy == other.chunkingStrategy && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, lastError, object_, status, usageBytes, vectorStoreId, chunkingStrategy, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStoreFile{id=$id, createdAt=$createdAt, lastError=$lastError, object_=$object_, status=$status, usageBytes=$usageBytes, vectorStoreId=$vectorStoreId, chunkingStrategy=$chunkingStrategy, additionalProperties=$additionalProperties}"
}
