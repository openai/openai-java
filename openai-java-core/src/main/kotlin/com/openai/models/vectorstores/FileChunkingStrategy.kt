// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The strategy used to chunk the file. */
@JsonDeserialize(using = FileChunkingStrategy.Deserializer::class)
@JsonSerialize(using = FileChunkingStrategy.Serializer::class)
class FileChunkingStrategy
private constructor(
    private val static_: StaticFileChunkingStrategyObject? = null,
    private val other: OtherFileChunkingStrategyObject? = null,
    private val _json: JsonValue? = null,
) {

    fun static_(): Optional<StaticFileChunkingStrategyObject> = Optional.ofNullable(static_)

    /**
     * This is returned when the chunking strategy is unknown. Typically, this is because the file
     * was indexed before the `chunking_strategy` concept was introduced in the API.
     */
    fun other(): Optional<OtherFileChunkingStrategyObject> = Optional.ofNullable(other)

    fun isStatic(): Boolean = static_ != null

    fun isOther(): Boolean = other != null

    fun asStatic(): StaticFileChunkingStrategyObject = static_.getOrThrow("static_")

    /**
     * This is returned when the chunking strategy is unknown. Typically, this is because the file
     * was indexed before the `chunking_strategy` concept was introduced in the API.
     */
    fun asOther(): OtherFileChunkingStrategyObject = other.getOrThrow("other")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            static_ != null -> visitor.visitStatic(static_)
            other != null -> visitor.visitOther(other)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): FileChunkingStrategy = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitStatic(static_: StaticFileChunkingStrategyObject) {
                    static_.validate()
                }

                override fun visitOther(other: OtherFileChunkingStrategyObject) {
                    other.validate()
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
                override fun visitStatic(static_: StaticFileChunkingStrategyObject) =
                    static_.validity()

                override fun visitOther(other: OtherFileChunkingStrategyObject) = other.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileChunkingStrategy && static_ == other.static_ && this.other == other.other /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(static_, other) /* spotless:on */

    override fun toString(): String =
        when {
            static_ != null -> "FileChunkingStrategy{static_=$static_}"
            other != null -> "FileChunkingStrategy{other=$other}"
            _json != null -> "FileChunkingStrategy{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid FileChunkingStrategy")
        }

    companion object {

        @JvmStatic
        fun ofStatic(static_: StaticFileChunkingStrategyObject) =
            FileChunkingStrategy(static_ = static_)

        /**
         * This is returned when the chunking strategy is unknown. Typically, this is because the
         * file was indexed before the `chunking_strategy` concept was introduced in the API.
         */
        @JvmStatic
        fun ofOther(other: OtherFileChunkingStrategyObject) = FileChunkingStrategy(other = other)
    }

    /**
     * An interface that defines how to map each variant of [FileChunkingStrategy] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        fun visitStatic(static_: StaticFileChunkingStrategyObject): T

        /**
         * This is returned when the chunking strategy is unknown. Typically, this is because the
         * file was indexed before the `chunking_strategy` concept was introduced in the API.
         */
        fun visitOther(other: OtherFileChunkingStrategyObject): T

        /**
         * Maps an unknown variant of [FileChunkingStrategy] to a value of type [T].
         *
         * An instance of [FileChunkingStrategy] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown FileChunkingStrategy: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<FileChunkingStrategy>(FileChunkingStrategy::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): FileChunkingStrategy {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "static" -> {
                    return tryDeserialize(node, jacksonTypeRef<StaticFileChunkingStrategyObject>())
                        ?.let { FileChunkingStrategy(static_ = it, _json = json) }
                        ?: FileChunkingStrategy(_json = json)
                }
                "other" -> {
                    return tryDeserialize(node, jacksonTypeRef<OtherFileChunkingStrategyObject>())
                        ?.let { FileChunkingStrategy(other = it, _json = json) }
                        ?: FileChunkingStrategy(_json = json)
                }
            }

            return FileChunkingStrategy(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<FileChunkingStrategy>(FileChunkingStrategy::class) {

        override fun serialize(
            value: FileChunkingStrategy,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.static_ != null -> generator.writeObject(value.static_)
                value.other != null -> generator.writeObject(value.other)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid FileChunkingStrategy")
            }
        }
    }
}
