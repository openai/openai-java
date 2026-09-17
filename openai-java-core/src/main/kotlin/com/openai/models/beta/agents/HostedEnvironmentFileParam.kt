// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A file materialized in an OpenAI-hosted execution environment. */
@JsonDeserialize(using = HostedEnvironmentFileParam.Deserializer::class)
@JsonSerialize(using = HostedEnvironmentFileParam.Serializer::class)
class HostedEnvironmentFileParam
private constructor(
    private val fileId: FileId? = null,
    private val inline: Inline? = null,
    private val _json: JsonValue? = null,
) {

    /** A file previously uploaded through the OpenAI Files API. */
    fun fileId(): Optional<FileId> = Optional.ofNullable(fileId)

    /** A file supplied directly as standard-base64 data. */
    fun inline(): Optional<Inline> = Optional.ofNullable(inline)

    fun isFileId(): Boolean = fileId != null

    fun isInline(): Boolean = inline != null

    /** A file previously uploaded through the OpenAI Files API. */
    fun asFileId(): FileId = fileId.getOrThrow("fileId")

    /** A file supplied directly as standard-base64 data. */
    fun asInline(): Inline = inline.getOrThrow("inline")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = hostedEnvironmentFileParam.accept(new HostedEnvironmentFileParam.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitFileId(FileId fileId) {
     *         return Optional.of(fileId.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            fileId != null -> visitor.visitFileId(fileId)
            inline != null -> visitor.visitInline(inline)
            else -> visitor.unknown(_json)
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
    fun validate(): HostedEnvironmentFileParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFileId(fileId: FileId) {
                    fileId.validate()
                }

                override fun visitInline(inline: Inline) {
                    inline.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitFileId(fileId: FileId) = fileId.validity()

                override fun visitInline(inline: Inline) = inline.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is HostedEnvironmentFileParam &&
            fileId == other.fileId &&
            inline == other.inline
    }

    override fun hashCode(): Int = Objects.hash(fileId, inline)

    override fun toString(): String =
        when {
            fileId != null -> "HostedEnvironmentFileParam{fileId=$fileId}"
            inline != null -> "HostedEnvironmentFileParam{inline=$inline}"
            _json != null -> "HostedEnvironmentFileParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid HostedEnvironmentFileParam")
        }

    companion object {

        /** A file previously uploaded through the OpenAI Files API. */
        @JvmStatic fun ofFileId(fileId: FileId) = HostedEnvironmentFileParam(fileId = fileId)

        /** A file supplied directly as standard-base64 data. */
        @JvmStatic fun ofInline(inline: Inline) = HostedEnvironmentFileParam(inline = inline)
    }

    /**
     * An interface that defines how to map each variant of [HostedEnvironmentFileParam] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** A file previously uploaded through the OpenAI Files API. */
        fun visitFileId(fileId: FileId): T

        /** A file supplied directly as standard-base64 data. */
        fun visitInline(inline: Inline): T

        /**
         * Maps an unknown variant of [HostedEnvironmentFileParam] to a value of type [T].
         *
         * An instance of [HostedEnvironmentFileParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown HostedEnvironmentFileParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<HostedEnvironmentFileParam>(HostedEnvironmentFileParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): HostedEnvironmentFileParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "file_id" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileId>())?.let {
                        HostedEnvironmentFileParam(fileId = it, _json = json)
                    } ?: HostedEnvironmentFileParam(_json = json)
                }
                "inline" -> {
                    return tryDeserialize(node, jacksonTypeRef<Inline>())?.let {
                        HostedEnvironmentFileParam(inline = it, _json = json)
                    } ?: HostedEnvironmentFileParam(_json = json)
                }
            }

            return HostedEnvironmentFileParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<HostedEnvironmentFileParam>(HostedEnvironmentFileParam::class) {

        override fun serialize(
            value: HostedEnvironmentFileParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.fileId != null -> generator.writeObject(value.fileId)
                value.inline != null -> generator.writeObject(value.inline)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid HostedEnvironmentFileParam")
            }
        }
    }

    /** A file previously uploaded through the OpenAI Files API. */
    class FileId
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val fileId: JsonField<String>,
        private val path: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(fileId, path, type, mutableMapOf())

        /**
         * The ID of the uploaded file.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fileId(): String = fileId.getRequired("file_id")

        /**
         * The absolute destination path inside `/workspace`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun path(): String = path.getRequired("path")

        /**
         * The type of the object. Always `file_id`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("file_id")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [fileId].
         *
         * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        /**
         * Returns the raw JSON value of [path].
         *
         * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

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
             * Returns a mutable builder for constructing an instance of [FileId].
             *
             * The following fields are required:
             * ```java
             * .fileId()
             * .path()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileId]. */
        class Builder internal constructor() {

            private var fileId: JsonField<String>? = null
            private var path: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("file_id")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileId: FileId) = apply {
                this.fileId = fileId.fileId
                path = fileId.path
                type = fileId.type
                additionalProperties = fileId.additionalProperties.toMutableMap()
            }

            /** The ID of the uploaded file. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /**
             * Sets [Builder.fileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

            /** The absolute destination path inside `/workspace`. */
            fun path(path: String) = path(JsonField.of(path))

            /**
             * Sets [Builder.path] to an arbitrary JSON value.
             *
             * You should usually call [Builder.path] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun path(path: JsonField<String>) = apply { this.path = path }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("file_id")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [FileId].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .fileId()
             * .path()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FileId =
                FileId(
                    checkRequired("fileId", fileId),
                    checkRequired("path", path),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): FileId = apply {
            if (validated) {
                return@apply
            }

            fileId()
            path()
            _type().let {
                if (it != JsonValue.from("file_id")) {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (fileId.asKnown().isPresent) 1 else 0) +
                (if (path.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("file_id")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FileId &&
                fileId == other.fileId &&
                path == other.path &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(fileId, path, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileId{fileId=$fileId, path=$path, type=$type, additionalProperties=$additionalProperties}"
    }

    /** A file supplied directly as standard-base64 data. */
    class Inline
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<String>,
        private val path: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<String> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(data, path, type, mutableMapOf())

        /**
         * The standard-base64-encoded file contents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): String = data.getRequired("data")

        /**
         * The absolute destination path inside `/workspace`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun path(): String = path.getRequired("path")

        /**
         * The type of the object. Always `inline`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("inline")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

        /**
         * Returns the raw JSON value of [path].
         *
         * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

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
             * Returns a mutable builder for constructing an instance of [Inline].
             *
             * The following fields are required:
             * ```java
             * .data()
             * .path()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Inline]. */
        class Builder internal constructor() {

            private var data: JsonField<String>? = null
            private var path: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("inline")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inline: Inline) = apply {
                data = inline.data
                path = inline.path
                type = inline.type
                additionalProperties = inline.additionalProperties.toMutableMap()
            }

            /** The standard-base64-encoded file contents. */
            fun data(data: String) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<String>) = apply { this.data = data }

            /** The absolute destination path inside `/workspace`. */
            fun path(path: String) = path(JsonField.of(path))

            /**
             * Sets [Builder.path] to an arbitrary JSON value.
             *
             * You should usually call [Builder.path] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun path(path: JsonField<String>) = apply { this.path = path }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("inline")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Inline].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * .path()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Inline =
                Inline(
                    checkRequired("data", data),
                    checkRequired("path", path),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Inline = apply {
            if (validated) {
                return@apply
            }

            data()
            path()
            _type().let {
                if (it != JsonValue.from("inline")) {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (data.asKnown().isPresent) 1 else 0) +
                (if (path.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("inline")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Inline &&
                data == other.data &&
                path == other.path &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(data, path, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Inline{data=$data, path=$path, type=$type, additionalProperties=$additionalProperties}"
    }
}
