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

/** Metadata for a file materialized in an OpenAI-hosted execution environment. */
@JsonDeserialize(using = HostedEnvironmentFile.Deserializer::class)
@JsonSerialize(using = HostedEnvironmentFile.Serializer::class)
class HostedEnvironmentFile
private constructor(
    private val fileId: HostedEnvironmentFileId? = null,
    private val inline: Inline? = null,
    private val _json: JsonValue? = null,
) {

    /** A file copied from the OpenAI Files API. */
    fun fileId(): Optional<HostedEnvironmentFileId> = Optional.ofNullable(fileId)

    /** A file supplied inline when the session was created. */
    fun inline(): Optional<Inline> = Optional.ofNullable(inline)

    fun isFileId(): Boolean = fileId != null

    fun isInline(): Boolean = inline != null

    /** A file copied from the OpenAI Files API. */
    fun asFileId(): HostedEnvironmentFileId = fileId.getOrThrow("fileId")

    /** A file supplied inline when the session was created. */
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
     * Optional<String> result = hostedEnvironmentFile.accept(new HostedEnvironmentFile.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitFileId(HostedEnvironmentFileId fileId) {
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
    fun validate(): HostedEnvironmentFile = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFileId(fileId: HostedEnvironmentFileId) {
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
                override fun visitFileId(fileId: HostedEnvironmentFileId) = fileId.validity()

                override fun visitInline(inline: Inline) = inline.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is HostedEnvironmentFile && fileId == other.fileId && inline == other.inline
    }

    override fun hashCode(): Int = Objects.hash(fileId, inline)

    override fun toString(): String =
        when {
            fileId != null -> "HostedEnvironmentFile{fileId=$fileId}"
            inline != null -> "HostedEnvironmentFile{inline=$inline}"
            _json != null -> "HostedEnvironmentFile{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid HostedEnvironmentFile")
        }

    companion object {

        /** A file copied from the OpenAI Files API. */
        @JvmStatic
        fun ofFileId(fileId: HostedEnvironmentFileId) = HostedEnvironmentFile(fileId = fileId)

        /** A file supplied inline when the session was created. */
        @JvmStatic fun ofInline(inline: Inline) = HostedEnvironmentFile(inline = inline)
    }

    /**
     * An interface that defines how to map each variant of [HostedEnvironmentFile] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** A file copied from the OpenAI Files API. */
        fun visitFileId(fileId: HostedEnvironmentFileId): T

        /** A file supplied inline when the session was created. */
        fun visitInline(inline: Inline): T

        /**
         * Maps an unknown variant of [HostedEnvironmentFile] to a value of type [T].
         *
         * An instance of [HostedEnvironmentFile] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown HostedEnvironmentFile: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<HostedEnvironmentFile>(HostedEnvironmentFile::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): HostedEnvironmentFile {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "file_id" -> {
                    return tryDeserialize(node, jacksonTypeRef<HostedEnvironmentFileId>())?.let {
                        HostedEnvironmentFile(fileId = it, _json = json)
                    } ?: HostedEnvironmentFile(_json = json)
                }
                "inline" -> {
                    return tryDeserialize(node, jacksonTypeRef<Inline>())?.let {
                        HostedEnvironmentFile(inline = it, _json = json)
                    } ?: HostedEnvironmentFile(_json = json)
                }
            }

            return HostedEnvironmentFile(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<HostedEnvironmentFile>(HostedEnvironmentFile::class) {

        override fun serialize(
            value: HostedEnvironmentFile,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.fileId != null -> generator.writeObject(value.fileId)
                value.inline != null -> generator.writeObject(value.inline)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid HostedEnvironmentFile")
            }
        }
    }

    /** A file supplied inline when the session was created. */
    class Inline
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val path: JsonField<String>,
        private val sizeBytes: JsonField<Long>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
            @JsonProperty("size_bytes")
            @ExcludeMissing
            sizeBytes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, path, sizeBytes, type, mutableMapOf())

        /**
         * The session-scoped ID of the file in the execution environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The file's absolute path inside the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun path(): String = path.getRequired("path")

        /**
         * The decoded file size in bytes.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sizeBytes(): Long = sizeBytes.getRequired("size_bytes")

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
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [path].
         *
         * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

        /**
         * Returns the raw JSON value of [sizeBytes].
         *
         * Unlike [sizeBytes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("size_bytes") @ExcludeMissing fun _sizeBytes(): JsonField<Long> = sizeBytes

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
             * .id()
             * .path()
             * .sizeBytes()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Inline]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var path: JsonField<String>? = null
            private var sizeBytes: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("inline")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inline: Inline) = apply {
                id = inline.id
                path = inline.path
                sizeBytes = inline.sizeBytes
                type = inline.type
                additionalProperties = inline.additionalProperties.toMutableMap()
            }

            /** The session-scoped ID of the file in the execution environment. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The file's absolute path inside the environment. */
            fun path(path: String) = path(JsonField.of(path))

            /**
             * Sets [Builder.path] to an arbitrary JSON value.
             *
             * You should usually call [Builder.path] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun path(path: JsonField<String>) = apply { this.path = path }

            /** The decoded file size in bytes. */
            fun sizeBytes(sizeBytes: Long) = sizeBytes(JsonField.of(sizeBytes))

            /**
             * Sets [Builder.sizeBytes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sizeBytes] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sizeBytes(sizeBytes: JsonField<Long>) = apply { this.sizeBytes = sizeBytes }

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
             * .id()
             * .path()
             * .sizeBytes()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Inline =
                Inline(
                    checkRequired("id", id),
                    checkRequired("path", path),
                    checkRequired("sizeBytes", sizeBytes),
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

            id()
            path()
            sizeBytes()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (path.asKnown().isPresent) 1 else 0) +
                (if (sizeBytes.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("inline")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Inline &&
                id == other.id &&
                path == other.path &&
                sizeBytes == other.sizeBytes &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, path, sizeBytes, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Inline{id=$id, path=$path, sizeBytes=$sizeBytes, type=$type, additionalProperties=$additionalProperties}"
    }
}
